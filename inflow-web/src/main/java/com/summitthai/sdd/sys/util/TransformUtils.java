package com.summitthai.sdd.sys.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class TransformUtils {

	/**
	 * Copy property values from the origin bean to the destination bean for all
	 * cases where the property names are the same. For more details see
	 * BeanUtilsBean.
	 * 
	 * @param dest
	 *            Destination bean whose properties are modified
	 * @param orig
	 *            Origin bean whose properties are retrieved
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws ItpException
	 */
	public static void copyProperties(Object dest, Object orig)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, ClassNotFoundException,
			InstantiationException {
		String methodName = "";
		String parameterTypeName = "";
		Method[] methodList = null;
		Object valueObj = null;
//		ReferenceData rfObj = null;
		try {
			if (orig == null) {
				return;
			}
			if (dest == null) {
				return;
			}

			methodList = dest.getClass().getMethods();

			for (Method method : methodList) {
				methodName = method.getName();
				if (methodName.indexOf("set") == 0) {
					parameterTypeName = method.getParameterTypes()[0].getName();

					if (parameterTypeName.equals("boolean")) {
						valueObj = getValue(orig, "is".concat(methodName.substring(3)));
						if (valueObj != null) {
							method.invoke(dest,
									Boolean.valueOf(valueObj.toString()));
						}
					} else if (parameterTypeName.equals("int")) {
						valueObj = getValue(orig, "get".concat(methodName.substring(3)));
						if (valueObj != null) {
							method.invoke(dest,
									Integer.valueOf(valueObj.toString()));
						}
					} else if (parameterTypeName.equals("short")) {
						valueObj = getValue(orig, "get".concat(methodName.substring(3)));
						if (valueObj != null) {
							method.invoke(dest,
									Short.valueOf(valueObj.toString()));
						}
					} else if (parameterTypeName.equals("char")) {
						valueObj = getValue(orig, "get".concat(methodName.substring(3)));
						if (valueObj != null) {
							method.invoke(dest, ((Character)valueObj).charValue());
						}
//					} else if (parameterTypeName.indexOf(".rf") > 0) {
//						rfObj = (ReferenceData) getValue(orig, "get".concat(methodName.substring(3)));
//
//						if (rfObj != null) {
//							ReferenceData rdf = ReferenceDataMemory.get(
//									rfObj.getSubtableCode(), rfObj.getCode());
//
//							Class<?> c = Class.forName(parameterTypeName);
//							Object rfReturn = c.newInstance();
//
//							copyProperties(rfReturn, rdf);
//
//							method.invoke(dest, rfReturn);
//						}

					} else if (methodName.equals("setId") || parameterTypeName.indexOf(".entity") > 0) {
						valueObj = ClassUtils.createObject(parameterTypeName);
						copyProperties(valueObj, getValue(orig, "get".concat(methodName.substring(3))));
						method.invoke(dest, new Object[] { valueObj });
					} else {
						valueObj = getValue(orig, "get".concat(methodName.substring(3)));
						method.invoke(dest, new Object[] { valueObj });
					}
				}
			}
		} finally {

		}
	}

	public static void copyList(Object desc, Object orig) {
		try {
			if (desc instanceof java.util.List) {
				List<Object> o = (List<Object>) orig;

				for (Iterator<Object> iterator = o.iterator(); iterator.hasNext();) {
					Object objOrg = (Object) iterator.next();
					
					Class<?> c = Class.forName(objOrg.getClass().getName());
					Object objDes = c.newInstance();
					
					copyProperties(objDes, objOrg);

					((List<Object>) desc).add(objDes);
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void clearProperties(Object obj)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, ClassNotFoundException,
			InstantiationException {
		String methodName = "";
		String parameterTypeName = "";
		Method[] methodList = null;

		try {
			if (obj == null) {
				return;
			}

			methodList = obj.getClass().getMethods();
			for (Method method : methodList) {
				methodName = method.getName();
				if (methodName.indexOf("set") == 0) {
					parameterTypeName = method.getParameterTypes()[0].getName();

					if (parameterTypeName.equals("boolean")) {
						method.invoke(obj, false);
					} else if (parameterTypeName.equals("int")) {
						method.invoke(obj, 0);
					} else if (parameterTypeName.equals("short")) {
						method.invoke(obj, 0);
					} else if (parameterTypeName.equals("char")) {
						method.invoke(obj, "".toCharArray());
					} else if (parameterTypeName.indexOf("String") > 0) {
						method.invoke(obj, "");
					} else {
						method.invoke(obj, new Object[] { null });
					}
				}
			}
		} finally {

		}
	}

	public static void combineProperties(Object dest, Object orig,
			boolean condition) throws IllegalAccessException,
			InvocationTargetException {
		String methodName = "";
		Method[] methodList = null;
		Object valueOrig = null;
		Object valueDest = null;
		Method methodObj = null;
		try {
			if (orig == null) {
				return;
			}
			if (dest == null) {
				return;
			}
			methodList = orig.getClass().getMethods();
			for (Method method : methodList) {
				methodName = method.getName();
				if (methodName.indexOf("set") == 0) {
					if (!methodName.equals("setId")) {
						try {
							methodObj = dest.getClass().getMethod(
									method.getName(),
									method.getParameterTypes());
						} catch (Exception e) {
							continue;
						}
						valueOrig = getValue(orig,
								"get" + methodName.substring(3));
						valueDest = getValue(dest,
								"get" + methodName.substring(3));
						// logger.debug(checkEntityEror + " >>> " + valueDest+
						// " : " + valueOrig);
						if (condition) {
							if (isEqual(valueDest, valueOrig)) {
							} else {
								try {
									method.invoke(dest,
											new Object[] { valueOrig });
								} catch (IllegalArgumentException ex) {
									// no method for invoke value
								}
							}
						} else {
							methodObj.invoke(dest, new Object[] { valueOrig });
						}
					} else {
					}
				}
			}
		} finally {

		}
	}

	private static boolean isEqual(Object dest, Object orig) {
		if (orig == null) {
			return true;
		}
		if (dest == null) {
			return false;
		}
		if (dest.getClass().getName() == String.class.getName()) {
			return StringUtils.isEquals((String) dest, (String) orig);
		} else if (dest.getClass().getName() == BigDecimal.class.getName()) {
			return NumberUtils
					.isEqual(((BigDecimal) dest), ((BigDecimal) orig));
		} else if (dest.getClass().getName() == Long.class.getName()) {
			return NumberUtils.isEqual(NumberUtils.toBigDecimal((Long) dest),
					NumberUtils.toBigDecimal((Long) orig));
		} else if (dest.getClass().getName() == int.class.getName()) {
			return NumberUtils.isEqual(
					NumberUtils.toBigDecimal((Integer) dest),
					NumberUtils.toBigDecimal((Integer) orig));
		} else if (dest.getClass().getName() == Double.class.getName()) {
			return NumberUtils.isEqual(NumberUtils.toBigDecimal((Double) dest),
					NumberUtils.toBigDecimal((Double) orig));
		}
		return false;
	}

	public static Object getValue(Object obj, String methodName) {
		Object resultObj = null;
		Class<?> classIn = null;
		Method methodObj = null;
		try {
			if (obj == null) {
				return null;
			}

			classIn = obj.getClass();
			methodObj = classIn.getMethod(methodName, new Class[] {});
			resultObj = methodObj.invoke(obj, new Object[] {});

			return resultObj;
		} catch (SecurityException e) {
			e.printStackTrace();
			return null;
		} catch (NoSuchMethodException e) {
			// e.printStackTrace();
			return null;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			return null;
		} finally {
			classIn = null;
			methodObj = null;
			resultObj = null;
		}
	}
}

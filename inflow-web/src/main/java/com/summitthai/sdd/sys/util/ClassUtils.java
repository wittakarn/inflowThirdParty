package com.summitthai.sdd.sys.util;


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import java.math.BigDecimal;

import java.util.StringTokenizer;

/**
 * * Copyright (c) 2002-2005 Summit Computer Co., Ltd.
 * 109 Surawong Road, Bangruk, Bangkok, 10500, Thailand.
 * All Rights Reserved.
 * @version 1.0
 */

public class ClassUtils {
	
	// returns the class (without the package if any)
	public static String getClassName(Class<?> c) {
		String FQClassName = c.getName();
		int firstChar;
		firstChar = FQClassName.lastIndexOf('.') + 1;
		if (firstChar > 0) {
			FQClassName = FQClassName.substring(firstChar);
		}
		return FQClassName;
	}

	// returns package and class name
	public static String getFullClassName(Class<?> c) {
		return c.getName();
	}

	// returns package and class name
	public static String getFullClassPath(Class<?> c) {
		return c.getName().replace(".", "/");
	}

	// returns the package without the classname, empty string if
	// there is no package
	public static String getPackageName(Class<?> c) {
		String fullyQualifiedName = c.getName();
		int lastDot = fullyQualifiedName.lastIndexOf('.');
		if (lastDot == -1) {
			return "";
		}
		return fullyQualifiedName.substring(0, lastDot);
	}

	public static void set(Object object, String attributetype,
			String fieldName, String value) {
		try {
			Class<?>[] partypes = null;
			Object[] arg = null;

			if (attributetype.toLowerCase().equals("long")) {
				partypes = new Class[] { Long.class };
			} else if (attributetype.toLowerCase().equals("bigdecimal")) {
				partypes = new Class[] { BigDecimal.class };
			} else {
				partypes = new Class[] { String.class };
			}
			Method meth = object.getClass().getMethod(
					"set" + change2JavaAttribute(fieldName, true), partypes);

			if (attributetype.toLowerCase().equals("long")) {
				arg = new Object[] { new Long(value) };
			} else if (attributetype.toLowerCase().equals("bigdecimal")) {
				arg = new Object[] { new BigDecimal(value) };
			} else {
				arg = new Object[] { value };
			}

			meth.invoke(object, arg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String change2JavaAttribute(String columnName,
			boolean firstUpper) {
		columnName = columnName.toLowerCase();

		StringTokenizer stk = new StringTokenizer(columnName, "_");
		String result = (String) stk.nextElement();

		while (stk.hasMoreElements()) {
			String element = (String) stk.nextElement();
			result += element.substring(0, 1).toUpperCase()
					+ element.substring(1);
		}
		if (firstUpper) {
			result = result.substring(0, 1).toUpperCase() + result.substring(1);
		}
		return result;
	}

	public static <T> T createObject(Class<T> c) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		try {
			return (T) createObject(c.getName());
		} finally {

		}
	}

	public static Object createObject(String className)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		Class<?> classDefinition = null;
		Object object = null;
		try {
			classDefinition = Class.forName(className);
			object = classDefinition.newInstance();

			return (Object) object;
		} finally {
			classDefinition = null;
			object = null;
		}
	}

	private static void checkClassVersion(String filename) throws IOException {
		DataInputStream in = new DataInputStream(new FileInputStream(filename));

		int magic = in.readInt();
		if (magic != 0xcafebabe) {
			System.out.println(filename + " is not a valid class!");
		}
		int minor = in.readUnsignedShort();
		int major = in.readUnsignedShort();
		System.out.println(filename + ": " + major + " . " + minor);
		in.close();
	}
    
}

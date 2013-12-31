package com.summitthai.sdd.sys.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * * Copyright (c) 2002-2005 Summit Computer Co., Ltd.
 * 109 Surawong Road, Bangruk, Bangkok, 10500, Thailand.
 * All Rights Reserved.
 * @version 1.0
 */

public class NumberUtils {

    /**
     * แปลงค่า String เป็น int
     * @param input
     * @return ถ้าเป็น null หรือไม่ใช้ตัวเลข จะคืนค่า 0
     */
    public static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * แปลงค่า String เป็น double
     * @param input
     * @return ถ้าเป็น null หรือไม่ใช้ตัวเลข จะคืนค่า 0.0
     */
    public static double parseDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (Exception e) {
            return 0.0;
        }
    }

    /**
     * แปลงค่า String เป็น double
     * @param input
     * @return if is null or not a number return 0.0
     */
    public static float parseFloat(String input) {
        try {
            return Float.parseFloat(input);
        } catch (Exception e) {
            return 0.0f;
        }
    }

    /**
     * แปลงค่า String เป็น long
     * @param input
     * @return ถ้าเป็น null หรือไม่ใช้ตัวเลข จะคืนค่า 0.0
     */
    public static long parseLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (Exception e) {
            return 0;
        }
    }

    public static String display(Long value) {
        DecimalFormat df = new DecimalFormat("#,##0");
        if (value == null) {
            value = 0L;
        }
        return df.format(value);
    }

    public static String display(BigDecimal value) {
        DecimalFormat df = new DecimalFormat("#,##0.00#");
        if (value == null) {
            value = BigDecimal.ZERO;
        }
        return df.format(value);
    }

    public static String display(BigDecimal value, String formatScale) {
        DecimalFormat df = new DecimalFormat("#,##0." + formatScale);
        if (value == null) {
            value = BigDecimal.ZERO;
        }
        return df.format(value);
    }

    public static BigDecimal add(BigDecimal value1, BigDecimal value2) {
        BigDecimal newValue1 = BigDecimal.ZERO;
        BigDecimal newValue2 = BigDecimal.ZERO;
        if (value1 != null) {
            newValue1 = value1;
        }
        if (value2 != null) {
            newValue2 = value2;
        }
        return newValue1.add(newValue2);
    }

    public static BigDecimal subtract(BigDecimal value1, BigDecimal value2) {
        BigDecimal newValue1 = BigDecimal.ZERO;
        BigDecimal newValue2 = BigDecimal.ZERO;
        if (value1 != null) {
            newValue1 = value1;
        }
        if (value2 != null) {
            newValue2 = value2;
        }
        return newValue1.subtract(newValue2);
    }

    public static BigDecimal multiply(BigDecimal value1, BigDecimal value2) {
        BigDecimal newValue1 = BigDecimal.ZERO;
        BigDecimal newValue2 = BigDecimal.ZERO;
        if (value1 != null) {
            newValue1 = value1;
        }
        if (value2 != null) {
            newValue2 = value2;
        }
        return newValue1.multiply(newValue2);
    }

    public static BigDecimal divide(BigDecimal value1, BigDecimal value2) {
        BigDecimal newValue1 = BigDecimal.ZERO;
        BigDecimal newValue2 = BigDecimal.ONE;
        if (value1 != null) {
            newValue1 = value1;
        }
        if ( (value2 != null) && (!value2.equals(BigDecimal.ZERO)) ) {
            newValue2 = value2;
        }
        return newValue1.divide(newValue2, RoundingMode.HALF_UP);
    }

    public static BigDecimal divide(BigDecimal value1, BigDecimal value2 , int roundingMode) {
        BigDecimal newValue1 = BigDecimal.ZERO;
        BigDecimal newValue2 = BigDecimal.ONE;
        if (value1 != null) {
            newValue1 = value1;
        }
        if ( (value2 != null) && (!value2.equals(BigDecimal.ZERO)) ) {
            newValue2 = value2;
        }
        return newValue1.divide(newValue2 , roundingMode);
    }

    public static BigDecimal divideReturnInt(BigDecimal value1, BigDecimal value2) {
        return divide(value1, value2, 0, BigDecimal.ROUND_DOWN);
    }
    
    public static BigDecimal divide(BigDecimal value1, BigDecimal value2, int digits, int modeOption) {
        BigDecimal newValue1 = BigDecimal.ZERO;
        BigDecimal newValue2 = BigDecimal.ONE;
        if (value1 != null) {
            newValue1 = value1;
        }
        if ( (value2 != null) && (!value2.equals(BigDecimal.ZERO)) ) {
            newValue2 = value2;
        }
        return newValue1.divide(newValue2, digits, modeOption);
    }

    public static BigDecimal abs(BigDecimal value1) {
        BigDecimal newValue1 = BigDecimal.ZERO;
        if (value1 != null) {
            newValue1 = value1;
        }
        return newValue1.abs();
    }

    /**
     * value.setScale(digits, BigDecimal.ROUND_HALF_UP);
     * @param value
     * @param digits (จำนวนจุดทศนิยมที่ต้องการให้แสดง)
     * @return BigDecimal
     */
    public static BigDecimal roundHalfUp(BigDecimal value, int digits) {
        if (value == null) {
            return value;
        }
        return value.setScale(digits, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * value.setScale(digits, BigDecimal.ROUND_HALF_UP);
     * @param value
     * @param digits (จำนวนจุดทศนิยมที่ต้องการให้แสดง)
     * @return BigDecimal
     */
    public static BigDecimal roundHalfUp(BigDecimal value) {
        return roundHalfUp(value, 2);
    }

    /**
     * 
     * @param value
     * @param digits (จำนวนจุดทศนิยมที่ต้องการให้แสดง)
     * @param modeOption ( BigDecimal.ROUND_HALF_UP , BigDecimal.ROUND_HALF_DOWN ... )
     * @return BigDecimal
     */
    public static BigDecimal round(BigDecimal value, int digits, int modeOption) {
        if (value == null) {
            return value;
        }
        return value.setScale(digits, modeOption);
    }

    /**
     * is null return zero
     * @param value BigDecimal
     * @return BigDecimal
     */
    public static BigDecimal nvl(BigDecimal value) {
        if (value == null) {
            return BigDecimal.ZERO;
        }
        return value;
    }

    /**
     * is null return zero
     * @param value Integer
     * @return Integer
     */
    public static Integer nvl(Integer value) {
        if (value == null) {
        	new Integer(0);
        }
        return value;
    }

    /**
     * is null return zero
     * @param value Long
     * @return Long
     */
    public static Long nvl(Long value) {
        if (value == null) {
            return new Long(0L);
        }
        return value;
    }

    /**
     * @param String value
     * @return true | false
     */
    public static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static String toString(BigDecimal value) {
    	String data = "";
        if (value != null) {
            data = value.toString();
        }
        return data;
    }

    public static String toString(Double value) {
    	String data = "";
        if (value != null) {
            data = value.toString();
        }
        return data;
    }

    public static String toString(Integer value) {
    	String data = "";
        if (value != null) {
            data = value.toString();
        }
        return data;
    }

    public static String toString(Long value) {
    	String data = "";
        if (value != null) {
            data = value.toString();
        }
        return data;
    }

    public static Long toLong(String value) {
        Long data = new Long(0);
        if (!StringUtils.isNullOrEmpty(value)) {
            data = Long.valueOf(value);
        }
        return data;
    }

    public static Long toLong(BigDecimal value) {
        Long data = new Long(0);
        if (value != null) {
            data = value.longValue();
        }
        return data;
    }

    public static Long toLong(Integer value) {
        Long data = new Long(0);
        if (value != null) {
            data = Long.valueOf(value);
        }
        return data;
    }

    public static Long toLong(int value) {
        Long data = new Long(0);
        data = Long.valueOf(value);
        return data;
    }

    public static BigDecimal toBigDecimal(String value) {
    	BigDecimal data = BigDecimal.ZERO;
        if (!StringUtils.isNullOrEmpty(value)) {
            data = new BigDecimal(value.replace(",", ""));
        }
        return data;
    }

    public static BigDecimal toBigDecimal(Double value) {
        BigDecimal data = BigDecimal.ZERO;
        if (value != null) {
            data = new BigDecimal(value);
            data = roundHalfUp(data);
        }
        return data;
    }

    public static BigDecimal toBigDecimal(Long value) {
        BigDecimal data = BigDecimal.ZERO;
        if (value != null) {
            data = new BigDecimal(value);
        }
        return data;
    }

    public static BigDecimal toBigDecimal(int value) {
        BigDecimal data = BigDecimal.ZERO;
        if (value != 0) {
            data = new BigDecimal(value);
        }
        return data;
    }

    public static double toDoubleValue(Double value) {
        double data = 0.00;
        if (value != null) {
            data = value.doubleValue();
        }
        return data;
    }

    public static double toDoubleValue(Float value) {
        double data = 0.00;
        if (value != null) {
            data = value.doubleValue();
        }
        return data;
    }

    public static Double toDouble(String value) {
        Double data = new Double(0);
        if (!StringUtils.isNullOrEmpty(value)) {
            data = Double.valueOf(value);
        }
        return data;
    }

    public static Double toDouble(Float value) {
        Double data = new Double(0.00);
        if (value != null) {
            data = Double.valueOf(value);
        }
        return data;
    }

    public static Float toFloat(String value) {
        Float data = new Float(0);
        if (!StringUtils.isNullOrEmpty(value)) {
            data = Float.valueOf(value);
        }
        return data;
    }

    public static Float toFloat(Double value) {
        Float data = new Float(0);
        if (value != null) {
            data = new Float(value);
        }
        return data;
    }

    public static Integer toInteger(String value) {
        Integer data = new Integer(0);
        if (!StringUtils.isNullOrEmpty(value)) {
            data = Integer.valueOf(value);
        }
        return data;
    }

    public static int toIntValue(Integer value) {
        int data = 0;
        if (value != null) {
            data = value.intValue();
        }
        return data;
    }

    public static int toIntValue(Long value) {
        int data = 0;
        if (value != null) {
            data = value.intValue();
        }
        return data;
    }
    
    public static int toIntValue(BigDecimal value) {
        int data = 0;
        if (value != null) {
            data = value.intValue();
        }
        return data;
    }
    
    public static boolean isEqual(BigDecimal value1, BigDecimal value2) {
        BigDecimal newValue1 = BigDecimal.ZERO;
        BigDecimal newValue2 = BigDecimal.ZERO;
        if (value1 != null) {
            newValue1 = value1;
        }
        if (value2 != null) {
            newValue2 = value2;
        }
    	return (newValue1.compareTo(newValue2) == 0);
    }

    public static boolean isLess(BigDecimal value1, BigDecimal value2) {
        BigDecimal newValue1 = BigDecimal.ZERO;
        BigDecimal newValue2 = BigDecimal.ZERO;
        if (value1 != null) {
            newValue1 = value1;
        }
        if (value2 != null) {
            newValue2 = value2;
        }
    	return (newValue1.compareTo(newValue2) == -1);
    }
    
    public static boolean isLessOrEqual(BigDecimal value1, BigDecimal value2) {
        BigDecimal newValue1 = BigDecimal.ZERO;
        BigDecimal newValue2 = BigDecimal.ZERO;
        if (value1 != null) {
            newValue1 = value1;
        }
        if (value2 != null) {
            newValue2 = value2;
        }
    	return (newValue1.compareTo(newValue2) < 1);
    }
    
    public static boolean isGreater(BigDecimal value1, BigDecimal value2) {
        BigDecimal newValue1 = BigDecimal.ZERO;
        BigDecimal newValue2 = BigDecimal.ZERO;
        if (value1 != null) {
            newValue1 = value1;
        }
        if (value2 != null) {
            newValue2 = value2;
        }
    	return (newValue1.compareTo(newValue2) == 1);
    }
    
    public static boolean isGreaterOrEqual(BigDecimal value1, BigDecimal value2) {
        BigDecimal newValue1 = BigDecimal.ZERO;
        BigDecimal newValue2 = BigDecimal.ZERO;
        if (value1 != null) {
            newValue1 = value1;
        }
        if (value2 != null) {
            newValue2 = value2;
        }
    	return (newValue1.compareTo(newValue2) >= 0);
    }

}


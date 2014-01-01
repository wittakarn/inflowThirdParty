package com.summitthai.sdd.sys.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.StringTokenizer;

/**
 * * Copyright (c) 2014 Wittakarn Keeratichayakorn. All Rights Reserved.
 *
 * @version 1.0
 */
public class StringUtils {

    /**
     *
     * @param str is a array of string, which provide for concat by waiving null or empty string.
     * @return string.
     */
    public static String concatString(String[] str) {
        String content = "";
        for (String s : str) {
            if (!StringUtils.isNullOrEmpty(s)) {
                content += s;
            }
        }
        return content;
    }

    /**
     *
     * @param target คำที่ใช้ค้นในกลุ่มคำ
     * @param source กลุ่มคำทั้งหมดที่มี
     * @return ตำแหน่งที่พบคำโดยจะเริ่มจากตำแหน่งที่ 0 ถ้า -1 คือ ไม่พบ
     */
    public static int indexOf(String target, String[] source) {
        int loop = 0;
        int index = 0;
        try {
            index = -1;
            for (String value : source) {
                if (target.equals(value)) {
                    index = loop;
                    break;
                }
                loop++;
            }

            return index;
        } finally {

        }
    }

    /**
     * เติม mask ให้กับ input <BR>
     * String input[] = {"AA","BB","C"}; <BR>
     * String out[] = StringUtils.maskStringArray(input,"|"); <BR>
     * out.length => 3 <BR>
     * out[0] => "|AA|" <BR>
     * out[1] => "|BB|" <BR>
     * out[2] => "|C|"
     *
     * @param group
     * @param mask
     * @return String[]
     */
    public static String[] maskStringArray(String[] group, String mask) {
        return maskStringArray(group, mask, mask);
    }

    /**
     * เติม left,right ให้กับ input <BR>
     * String input[] = {"AA","BB","C"}; <BR>
     * String out[] = StringUtils.maskStringArray(input,"|","||"); <BR>
     * out.length => 3 <BR>
     * out[0] => "|AA||" <BR>
     * out[1] => "|BB||" <BR>
     * out[2] => "|C||"
     *
     * @param input
     * @param left
     * @param right
     * @return String[]
     */
    public static String[] maskStringArray(String[] input, String left,
            String right) {
        for (int i = 0; i < input.length; i++) {
            input[i] = left + input[i] + right;
        }
        return input;
    }

    /**
     * String out = StringUtils.midTrim("A DFDF DF"); <BR>
     * out => "A DFDF DF"
     *
     * @param input
     * @return String
     */
    public static String midTrim(String input) {
        try {
            input = input.trim();
            int occur = 0;
            while (occur != -1) {
                occur = input.indexOf("  ");
                if (occur > -1) {
                    input
                            = input.substring(0, occur) + input.substring(occur + 1);
                }
            }
            return input;
        } catch (Exception e) {
            return input;
        }
    }

    /**
     * แปลง String[] ให้เป็น String <BR>
     * Ex <BR>
     * String input[] = {"S","u","m","m","i","t"}; <BR>
     * String out = StringUtils.mergeStringArray(input); <BR>
     * out => "Summit"
     *
     * @param input
     * @return String
     */
    public static String mergeStringArray(String[] input) {
        String merged = "";
        for (int i = 0; i < input.length; i++) {
            merged += input[i];
        }
        return merged;
    }

    /**
     * แปลงตัวเลข double เป็น String ใช้ในกรณีตัวเลขมีค่าเป็น n.nnXEnn <BR>
     * Ex <BR>
     * double d = 12254564654654654654654654464.22646464; <BR>
     * เวลาแสดงค่าออกหน้าจอจะกลายเป็น 1.2254564654654654E28 <BR>
     * String out = StringUtils.doubleToString(d); <BR>
     * out => "12254564654654654000000000000.00"
     *
     * @param value
     * @param maximum
     * @param minimum
     * @return String
     */
    public static String doubleToString(double value, int maximum,
            int minimum) {
        NumberFormat nbf;
        nbf = NumberFormat.getNumberInstance();
        nbf.setMaximumFractionDigits(maximum);
        nbf.setMinimumFractionDigits(minimum);
        nbf.setGroupingUsed(false);
        return nbf.format(value);
    }

    /**
     * ทำการ replace input โดยค้นหา คำที่เหมือนกับ target ใน input แล้วเปลี่ยน
     * เป็น replace <BR>
     * Ex <BR>
     * String out = StringUtils.replace("Summmit","mmm","mm"); <BR>
     * out => "Summit"
     *
     * @param input
     * @param target
     * @param replace
     * @return String
     */
    public static String replace(String input, String target, String replace) {
        boolean found, end;
        String temp, out;
        int lenTarget, lenInput, idx;
        lenInput = input.length();
        lenTarget = target.length();

        if (lenInput < lenTarget) {
            return input;
        }

        idx = 0;
        out = "";
        end = false;

        while (!end) {
            if ((idx + lenTarget) >= lenInput) {
                temp = input.substring(idx);
                end = true;
            } else {
                temp = input.substring(idx, idx + lenTarget);
            }
            found = temp.equals(target);
            if (found) {
                out += replace;
                if ((idx + lenTarget) < lenInput) {
                    idx += lenTarget - 1;
                }
            } else {
                if (!end) {
                    out += input.substring(idx, idx + 1);
                } else {
                    out += input.substring(idx);
                }
            }
            idx++;
        }
        return out;
    }

    /**
     * ตัดคำใน input ตาม target <BR>
     * Ex <BR>
     * String input = "SumUmit"; <BR>
     * String out = StringUtils.cut("U"); <BR>
     * out => "Summit"
     *
     * @param input
     * @param target
     * @return String
     */
    public static String cut(String input, String target) {
        return replace(input, target, "");
    }

    /**
     * ตัดคำที่อยู่ระหว่าง start,end <BR>
     * Ex <BR>
     * String s = "ERI00099: Archive Error [6 2017 Medium `P2-97-021B' is not
     * local at: 192.100.5.125][OFFLINE]"; <BR>
     * char[] c = "`'".toCharArray(); <BR>
     * String out = StringUtils.subString(s,c[0],c[1]); <BR>
     * out ==> P2-97-021B
     *
     * @param input
     * @param start
     * @param end
     * @return String ที่ตัดคำที่อยู่ระหว่าง start ถึง end
     */
    public static String subString(String input, char start, char end) {
        int intStart = input.indexOf(String.valueOf(start));
        if (intStart < 0) {
            return input;
        }
        intStart++;
        String ret = input.substring(intStart);
        int intEnd = ret.indexOf(String.valueOf(end));
        if (intEnd < 0) {
            return input;
        }
        return ret.substring(0, intEnd);
    }

    /**
     * เพิ่ม spad นำหน้า input ให้ครบตามจำนวน numpad <BR>
     * Ex <BR>
     * String out = StringUtils.padLeft("1","0",3); <BR>
     * out => "001";
     *
     * @param input
     * @param spad
     * @param numpad
     * @return String
     */
    public static String padLeft(String input, String spad, int numpad) {
        String out = genStringForPad(input, spad, numpad);
        return out + input;
    }

    /**
     * เพิ่ม spad ตามหลัง input ให้ครบตามจำนวน numpad <BR>
     * Ex <BR>
     * String out = StringUtils.padLeft("1","0",3); <BR>
     * out => "100";
     *
     * @param input
     * @param spad
     * @param numpad
     * @return String
     */
    public static String padRight(String input, String spad, int numpad) {
        String out = genStringForPad(input, spad, numpad);
        return input + out;
    }

    /**
     * สร้าง spad ให้ตาม numpad โดย input + spad ยาวเท่ากับ numpad <BR>
     * Ex <BR>
     * String out = StringUtils.genStringForPad("1","0",3); <BR>
     * out => "00"
     *
     * @param input
     * @param spad
     * @param numpad
     * @return String
     */
    public static String genStringForPad(String input, String spad,
            int numpad) {
        int leninput, lenspad, length;
        leninput = input.length();
        lenspad = spad.length();
        String out = "";
        if (((leninput + lenspad) > numpad) || (leninput > numpad)
                || (lenspad < 1)) {
            return out;
        }
        if (lenspad > 1) {
            if (((numpad - leninput) % lenspad) != 0) {
                return out;
            }
        }
        length = (numpad - leninput) / lenspad;
        for (int i = 1; i <= length; i++) {
            out += spad;
        }
        return out;
    }

    public static String trim(String input) {
        if (input == null) {
            return "";
        }
        if (input.equalsIgnoreCase("null")) {
            return "";
        }
        return input.trim();
    }

    public static String UnicodeToMS874(String _in) {
        StringBuffer strTemp = new StringBuffer(_in);
        int code;
        for (int i = 0; i < _in.length(); i++) {
            code = (int) strTemp.charAt(i);
            if ((0xE01 <= code) && (code <= 0xE5B)) {
                strTemp.setCharAt(i, (char) (code - 0xD60));
            }
        }
        return strTemp.toString();
    }

    public static String MS874ToUnicode(String _in) {
        StringBuffer strTemp = new StringBuffer(_in);
        int code;
        for (int i = 0; i < _in.length(); i++) {
            code = (int) strTemp.charAt(i);
            if ((0xA1 <= code) && (code <= 0xFB)) {
                strTemp.setCharAt(i, (char) (code + 0xD60));
            }
        }
        return strTemp.toString();
    }

    /**
     * @param input
     * @param DEFAULT_ENCODING (UTF-8,TIS-620...)
     * @return String
     * @throws IOException
     */
    public static String convertInputStreamToString(InputStream input,
            String DEFAULT_ENCODING) throws IOException {
        byte[] b = new byte[1024];
        ByteArrayOutputStream data = new ByteArrayOutputStream();
        int n;
        while ((n = input.read(b, 0, 1024)) != -1) {
            data.write(b, 0, n);
        }
        return new String(data.toByteArray(), DEFAULT_ENCODING);
    }

    /**
     * @param value
     * @return boolean
     */
    public static boolean isNullOrEmpty(String value) {
        if (value != null) {
            if (value.toLowerCase().equals("null")) {
                return true;
            }
        }
        return (value == null || value.length() == 0);
    }

    /**
     * เพิ่ม spad นำหน้า input ให้ครบตามจำนวน numpad <BR>
     * Ex <BR>
     * String out = StringUtils.padLeft(1,"0",3); <BR>
     * out => "001";
     *
     * @param input
     * @param spad
     * @param numpad
     * @return String
     */
    public static String padLeft(int input, String spad, int numpad) {
        String out = genStringForPad(String.valueOf(input), spad, numpad);
        return out + input;
    }

    /**
     * เพิ่ม spad ตามหลัง input ให้ครบตามจำนวน numpad <BR>
     * Ex <BR>
     * String out = StringUtils.padLeft(1,"0",3); <BR>
     * out => "100";
     *
     * @param input
     * @param spad
     * @param numpad
     * @return String
     */
    public static String padRight(int input, String spad, int numpad) {
        String out = genStringForPad(String.valueOf(input), spad, numpad);
        return input + out;
    }

    /**
     * @param str
     * @return String
     */
    public static String trimLeftRight(String str) {
        if (!StringUtils.isNullOrEmpty(str)) {
            while (str.substring(0, 1).equals(" ")) {
                str = str.substring(1);
            }
            while (str.substring(str.length() - 1, str.length()).equals(" ")) {
                str = str.substring(0, str.length() - 1);
            }
        }
        return str;
    }

    /**
     * ใช้ตัด delimit หน้า-หลัง ของ String ที่ส่งเข้ามา
     *
     * @param str String ที่ส่งเข้ามาตัด
     * @param delimit คำที่ต้องการตัด
     * @return ส่งค่ากลับเป็น String
     */
    public static String trimLeftRight(String str, String delimit) {
        if (!StringUtils.isNullOrEmpty(str)) {
            while (str.substring(0, 1).equals(delimit)) {
                str = str.substring(1);
            }
            while (str.substring(str.length() - 1,
                    str.length()).equals(delimit)) {
                str = str.substring(0, str.length() - 1);
            }
        }
        return str;
    }

    /**
     * เช็ค Object ที่ส่งเข้ามา ถ้าไม่เป็น null จะแปลงเป็น String แล้วส่งกลับ
     *
     * @param Object ที่ส่งเข้ามา
     * @param defalse ค่าที่ต้องการให้ส่งกลับกรณีที่ Object ที่ส่งมาเป็น null
     * @return ส่งค่ากลับเป็น String
     */
    public static String convertObjectToString(Object obj, String defalse) {
        if (obj != null) {
            return String.valueOf(obj);
        } else {
            return defalse;
        }
    }

    public static String concatString(String oldString, String newStirng, String delim) {
        StringTokenizer newStk = new StringTokenizer(newStirng, delim);
        while (newStk.hasMoreElements()) {
            String newPrv = (String) newStk.nextElement();
            oldString += delim + newPrv;
        }
        if (oldString.length() > 0) {
            if (oldString.substring(0, 1).equals(delim)) {
                oldString = oldString.substring(1);
            }
        }
        return oldString;
    }

    /**
     * เช็ค Object ที่ส่งเข้ามา ถ้าเป็น null จะส่งค่า "" กลับ
     *
     * @param Object ที่ส่งเข้ามา
     * @return ส่งค่ากลับเป็น String
     */
    public static String replaceNullToEmpty(String inputString) {
        if (inputString == null) {
            return "";
        }
        return inputString;
    }

    public static String replaceNullToEmpty(Object inputObject) {
        String returnStr = null;
        if (inputObject == null) {
            return "";
        } else {
            returnStr = inputObject.toString();
        }
        return returnStr;
    }

    /**
     * เปรียบเทียบข้อความ เก่า กับ ใหม่ โดยตัดช่องว่างทั้งหมดออก
     *
     * @param oldString
     * @param newStirng
     * @return boolean (ถ้าเท่ากันเป็น true , ไม่เท่าเป็น false)
     */
    public static boolean isEquals(String oldString, String newStirng) {
        String oldText = null;
        String newText = null;
        boolean isEqual = true;
        try {
            if (oldString == null) {
                oldString = "";
            }
            if (newStirng == null) {
                newStirng = "";
            }
            oldText = oldString.replaceAll(" ", "");
            newText = newStirng.replaceAll(" ", "");
            if (!oldText.equals(newText)) {
                isEqual = false;
            }
            return isEqual;
        } finally {
            oldText = null;
            newText = null;
        }
    }

    public static String mergeString(String oldString, String newStirng, String delim) {
        StringTokenizer newStk = new StringTokenizer(newStirng, delim);

        while (newStk.hasMoreElements()) {
            String newPrv = (String) newStk.nextElement();
            if (oldString.indexOf(newPrv) == -1) {
                oldString += delim + newPrv;
            }
        }
        if (oldString.length() > 0) {
            if (oldString.substring(0, 1).equals(delim)) {
                oldString = oldString.substring(1);
            }
        }
        return oldString;
    }

    /**
     * Convert filed to Name of Columb Exam. referenceValue1Text ==>
     * REFERENCE_VALUE1_TEXT *
     */
    public static String convertFieldToUpperCase(String fieldName, String className) {
        char[] subFieldName = fieldName.toCharArray();
        char[] subClassName = className.toCharArray();
        String concatField = String.valueOf(subFieldName[3]);
        String concatClass = String.valueOf(subClassName[0]);

        for (int i = 1; i < subClassName.length; i++) {
            if (Character.isUpperCase(subClassName[i])) {
                concatClass += "_" + String.valueOf(subClassName[i]).toUpperCase();
            } else {
                concatClass += String.valueOf(subClassName[i]).toUpperCase();
            }
        }

        for (int i = 4; i < subFieldName.length; i++) {
            if (Character.isUpperCase(subFieldName[i])) {
                concatField += "_" + String.valueOf(subFieldName[i]).toUpperCase();
            } else {
                concatField += String.valueOf(subFieldName[i]).toUpperCase();
            }
        }

        return concatClass.concat((".").concat(concatField));
    }

    /**
     * Convert the characters to ASCII value
     *
     * @param character character
     * @return ASCII value
     */
    public static int CharToASCII(final char character) {
        return (int) character;
    }

    /**
     * Convert the ASCII value to character
     *
     * @param ascii ascii value
     * @return character value
     */
    public static char ASCIIToChar(final int ascii) {
        return (char) ascii;
    }

}

package com.summitthai.sdd.sys.util;

import java.util.Vector;
import java.util.Enumeration;

/**
 * * Copyright (c) 2002-2005 Summit Computer Co., Ltd.
 * 109 Surawong Road, Bangruk, Bangkok, 10500, Thailand.
 * All Rights Reserved.
 * @version 1.0
 */

public class TokenizerUtils {
	
	private int Size=0;
	private Enumeration ELEMENT;
	private Vector VectorToken;
	/**
     *
     * @param input = String ที่ต้องการตัด
     * @param delim = String ที่ใช้คั่น
     */
	public TokenizerUtils(String input, String delim) {
		this.VectorToken = new Vector();
		this.stringTokenizer(input, delim);
	}
    /**
     *
     * @return int จำนวนที่แบ่งออกมาได้
     */
	public int countTokens() {
		return this.Size;
	}
    /**
     *
     * @return boolean true หมายถึง ยังสามารถ nextElement ได้
     */
	public boolean hasMoreElements() {
		if (this.ELEMENT == null)
			return false;
		return this.ELEMENT.hasMoreElements();
	}
    /**
     *
     * @return Object ให้ค่าถัดไป
     */
	public Object nextElement() {
		if (this.ELEMENT == null)
			return null;
		return this.ELEMENT.nextElement();
	}
	/**
	 * 
	 * @return Vector
	 */
	public Vector toVector() {
		return this.VectorToken;
	}
    /**
     * เคลียร์ค่าทั้งหมด
     */
	public void reset() {
		this.ELEMENT = this.VectorToken.elements();
	}	
	private void stringTokenizer(String strData, String strSep) {
		int sIndex=0, eIndex=0, intSize, intDSize;
		String strValue;
		intSize = strSep.length();
		intDSize = strData.length();
		while ((eIndex = strData.indexOf(strSep,sIndex)) != -1) {
			strValue = strData.substring(sIndex, eIndex);
			this.VectorToken.addElement(strValue);
			sIndex = eIndex + intSize;
	    }
	    if (sIndex < intDSize){
	    	strValue = strData.substring(sIndex, intDSize);
	    	this.VectorToken.addElement(strValue);
	    }
	    this.Size = this.VectorToken.size();
	    this.ELEMENT = this.VectorToken.elements();
	}
}
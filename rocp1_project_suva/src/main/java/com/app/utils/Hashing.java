package com.app.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class Hashing {

	public static String getHash(String p) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("MD5");
		 md.update(p.getBytes());
		 byte[] bytes = md.digest();
		 StringBuilder sb = new StringBuilder();
		 for(int i=0; i< bytes.length ;i++) {
			 sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		 }
		 p=sb.toString();
		
		return p;
	}

}

package com.iava.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MessageDigestTest {

	public static void main(String args[]) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("MD5");
		//MessageDigest md = MessageDigest.getInstance("SHA-1");
		System.out.println(md.getProvider().getName()+":"+md.getProvider().getInfo());
		
		md.update(new byte[]{1,2,3,4,5});
		byte []mdd = md.digest();
		
		System.out.println(Arrays.toString(mdd));
	}
}

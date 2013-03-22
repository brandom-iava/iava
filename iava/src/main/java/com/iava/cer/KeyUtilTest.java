package com.iava.cer;

import java.security.PrivateKey;
import java.security.PublicKey;

public class KeyUtilTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//正确
		String path = "F:\\personal\\wps快盘\\我的资料\\security安全\\openssl\\test\\privkey.pem";
		//错误
		String path1 = "F:\\personal\\wps快盘\\我的资料\\security安全\\openssl\\test\\ca.pfx";
		//正确
		String path2 = "F:\\tydic\\wss\\workspace\\iava\\iava\\config\\test\\alipay.crt";
		//错误
		String path3= "F:\\tydic\\wss\\workspace\\iava\\iava\\config\\cer\\privkey.key";
		
		PrivateKey key = KeyUtil.getPrivateKey(path3,"12345678");
		PublicKey pkey = KeyUtil.getPublicKey(path2);
		key.getAlgorithm();
		System.out.println(key.toString());
		System.out.println(pkey);
	}

}

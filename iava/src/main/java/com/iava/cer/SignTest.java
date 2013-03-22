package com.iava.cer;

public class SignTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String keyStorePath = "F:\\personal\\study\\security安全\\java\\wubp.keystore";
		String certPath = "F:\\personal\\study\\security安全\\java\\wubp.crt";
		String signData = "hello world";
		
		String singStr = SecurityUtil.sign(keyStorePath, "123456", "wubp", signData);
		System.out.println(singStr);
		
		SecurityUtil.veriSig(signData, singStr, certPath);
	}

}

package com.iava.security.provider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;

public class GetProviderInfo {

	public static void main(String args[]) throws NoSuchAlgorithmException{
		Provider []p = Security.getProviders();
		for(Provider pro: p){
			System.out.println(pro.getName() + ":" + pro.getInfo());
		}
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		System.out.println(md.getProvider().getName()+":"+md.getProvider().getInfo());
		
		md.update(new byte[]{1,2,3,4,5});
		byte []mdd = md.digest();
		System.out.println(mdd);
	}
		

}

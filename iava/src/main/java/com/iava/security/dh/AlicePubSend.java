package com.iava.security.dh;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyAgreement;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;

public class AlicePubSend {

	private static final String BOB_PUB_KEY_FILE = "F:\\personal\\wps快盘\\我的资料\\workspace\\iava\\iava\\BobPubKey";
	
	private static final String CIPHER_DATA = "F:\\personal\\wps快盘\\我的资料\\workspace\\iava\\iava\\cipherFile";
	
	public static void main(String args[]) throws IOException, NoSuchAlgorithmException, 
	InvalidKeySpecException, InvalidAlgorithmParameterException, InvalidKeyException, 
	NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		
		AlicePubSend aps = new AlicePubSend();
		
		//aps.generateAlicePubKey();
		aps.decryptData();
	
}
	private void generateAlicePubKey()throws IOException, NoSuchAlgorithmException, 
		InvalidKeySpecException, InvalidAlgorithmParameterException, InvalidKeyException, 
		NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		FileInputStream pfis = new FileInputStream(BOB_PUB_KEY_FILE);
		byte []encKey = new byte[pfis.available()];
		pfis.read(encKey);
		pfis.close();
		
		X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(encKey);
		KeyFactory kf = KeyFactory.getInstance("DH");
		PublicKey bobPubKey = kf.generatePublic(pubKeySpec);
		
		DHParameterSpec paramSpec = ((DHPublicKey)bobPubKey).getParams();
		
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("DH");

		kpg.initialize(paramSpec);
		
		KeyPair kp = kpg.generateKeyPair();
		
		byte []pubKeyEnc = kp.getPublic().getEncoded();
		
		FileOutputStream fos = new FileOutputStream("alicePublicKeyFile");
		fos.write(pubKeyEnc);
		fos.close();
		
	}
	
	
	private void decryptData()throws IOException, NoSuchAlgorithmException, 
	InvalidKeySpecException, InvalidAlgorithmParameterException, InvalidKeyException, 
	NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		FileInputStream pfis = new FileInputStream(BOB_PUB_KEY_FILE);
		byte []encKey = new byte[pfis.available()];
		pfis.read(encKey);
		pfis.close();
		
		X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(encKey);
		KeyFactory kf = KeyFactory.getInstance("DH");
		PublicKey bobPubKey = kf.generatePublic(pubKeySpec);
		
		DHParameterSpec paramSpec = ((DHPublicKey)bobPubKey).getParams();
		
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("DH");
		
		kpg.initialize(paramSpec);
		
		KeyPair kp = kpg.generateKeyPair();
		
		byte []pubKeyEnc = kp.getPublic().getEncoded();
		
		FileOutputStream fos = new FileOutputStream("alicePublicKeyFile");
		fos.write(pubKeyEnc);
		fos.close();
		
		boolean read = false;
		while(!read){
			try{
				FileInputStream cfis = new FileInputStream(CIPHER_DATA);
				cfis.close();
				read = true;
			}catch(IOException e)
			{
				System.out.println(e);
				try {
					Thread.sleep(2 * 1000);
				} catch (InterruptedException e1) {
				}
			}
		}
		KeyAgreement ka = KeyAgreement.getInstance("DH");
		ka.init(kp.getPrivate());
		
		ka.doPhase(bobPubKey, true);
		
		SecretKey secKey = ka.generateSecret("DES");
		
		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		
		
		cipher.init(Cipher.DECRYPT_MODE, secKey);
		
		FileInputStream cfis = new FileInputStream(CIPHER_DATA);
		
		byte []cipherData = new byte[cfis.available()];
		cfis.read(cipherData);
		cfis.close();
		
		byte []data = cipher.doFinal(cipherData);
				
		FileOutputStream dfos = new FileOutputStream("dataFile");
		dfos.write(data);
		dfos.close();
	}
}

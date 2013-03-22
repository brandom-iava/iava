package com.iava.security.dh;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyAgreement;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.DHParameterSpec;

public class BobSendSecrete {

	private static final String ALICE_PUB_KEY_FILE = "F:\\personal\\wps快盘\\我的资料\\workspace\\iava\\iava\\alicePublicKeyFile";

	private void generaterPubKeyFile() throws NoSuchAlgorithmException,
			InvalidParameterSpecException, InvalidAlgorithmParameterException,
			IOException {
		AlgorithmParameterGenerator gen = AlgorithmParameterGenerator
				.getInstance("DH");
		gen.init(512);
		AlgorithmParameters parameters = gen.generateParameters();
		DHParameterSpec paramSpec = (DHParameterSpec) parameters
				.getParameterSpec(DHParameterSpec.class);

		KeyPairGenerator kpg = KeyPairGenerator.getInstance("DH");
		kpg.initialize(paramSpec);

		KeyPair kp = kpg.generateKeyPair();

		byte[] pubKeyEnc = kp.getPublic().getEncoded();

		FileOutputStream fos = new FileOutputStream("BobPubKey");
		fos.write(pubKeyEnc);
		fos.close();
	}
	
	/**
	 * @param args
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidParameterSpecException 
	 * @throws InvalidAlgorithmParameterException 
	 * @throws IOException 
	 * @throws InvalidKeyException 
	 * @throws InvalidKeySpecException 
	 * @throws NoSuchPaddingException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidParameterSpecException,
	InvalidAlgorithmParameterException, IOException, InvalidKeyException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		BobSendSecrete bss = new BobSendSecrete();
		
		bss.encrypeData();
	}

	private void encrypeData() throws NoSuchAlgorithmException, InvalidParameterSpecException,
	InvalidAlgorithmParameterException, IOException, InvalidKeyException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		// TODO Auto-generated method stub
 
		AlgorithmParameterGenerator gen = AlgorithmParameterGenerator
				.getInstance("DH");
		gen.init(512);
		AlgorithmParameters parameters = gen.generateParameters();
		DHParameterSpec paramSpec = (DHParameterSpec) parameters
				.getParameterSpec(DHParameterSpec.class);

		KeyPairGenerator kpg = KeyPairGenerator.getInstance("DH");
		kpg.initialize(paramSpec);

		KeyPair kp = kpg.generateKeyPair();

		byte[] pubKeyEnc = kp.getPublic().getEncoded();

		FileOutputStream fos = new FileOutputStream("BobPubKey");
		fos.write(pubKeyEnc);
		fos.close();

		boolean read = false;
		while(!read){
			try{
				FileInputStream pfis = new FileInputStream(ALICE_PUB_KEY_FILE);
				pfis.close();
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
		
		kpg.initialize(paramSpec);

		
		KeyAgreement ka = KeyAgreement.getInstance("DH");
		ka.init(kp.getPrivate());
		
		//get alice public key 
		FileInputStream pfis = new FileInputStream(ALICE_PUB_KEY_FILE);
		byte []encKey = new byte[pfis.available()];
		pfis.read(encKey);
		pfis.close();
		
		X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(encKey);
		KeyFactory kf = KeyFactory.getInstance("DH");
		PublicKey alicePubKey = kf.generatePublic(pubKeySpec);
		
		//generate the secrete key
		ka.doPhase(alicePubKey, true);
		
		SecretKey secretKey = ka.generateSecret("DES");
		
		//generate and initialize the Ciper Object
		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		
		String inputString = "hello world";
		byte []data = inputString.getBytes();
		byte []cipherData = cipher.doFinal(data);
			
		System.out.println(new String(cipherData));
		FileOutputStream cipherFile = new FileOutputStream("cipherFile");
		cipherFile.write(cipherData);
		cipherFile.close();
	}
}

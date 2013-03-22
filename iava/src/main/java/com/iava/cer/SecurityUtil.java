package com.iava.cer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import org.apache.log4j.Logger;

import com.iava.utils.HexUtils;

public class SecurityUtil {

	private static final Logger logger = Logger.getLogger(SecurityUtil.class);
	/**
	 * 进行签名
	 * @param keyStorePath
	 * @param storePwd
	 * @param storeAlias
	 * @param signData
	 * @return
	 */
	public static String sign(String keyStorePath, String storePwd, String storeAlias, String signData){
		char[] kpass;
		int i;
		FileInputStream ksfis=null;
		BufferedInputStream ksbufin=null;
		KeyStore ks = null;
		try {
			ks = KeyStore.getInstance("JKS");
		} catch (KeyStoreException e) {
			logger.error("create keystore instance error",e);
			return null;
		}
		
		try {
			ksfis = new FileInputStream(keyStorePath);
		} catch (FileNotFoundException e) {
			logger.error("keystirePath isn't exists!", e);
			return null;
		}
		
		ksbufin = new BufferedInputStream(ksfis);
		kpass = new char[storePwd.length()];
		for (i = 0; i < storePwd.length(); i++){
			kpass[i] = storePwd.charAt(i);
		}
		
		try {
			//加载证书
			ks.load(ksbufin, kpass);
		} catch (NoSuchAlgorithmException e) {
			logger.error("加载证书失败！",e);
			return null;
		} catch (CertificateException e) {
			logger.error("加载证书失败！",e);
			return null;
		} catch (IOException e) {
			logger.error("加载证书失败！",e);
			return null;
		}
		
		PrivateKey privKey = null;
		try {
			privKey = (PrivateKey) ks.getKey(storeAlias, kpass);
		} catch (UnrecoverableKeyException e) {
			logger.error("取得密钥失败！",e);
			return null;
		} catch (KeyStoreException e) {
			logger.error("取得密钥失败！",e);
			return null;
		} catch (NoSuchAlgorithmException e) {
			logger.error("取得密钥失败！",e);
			return null;
		}
		
		try{
			Signature rsa = Signature.getInstance("SHA1withRSA");
			rsa.initSign(privKey);
			rsa.update(signData.getBytes());
			byte[] sig = rsa.sign();
			
			return HexUtils.toHexString(sig);
		}catch(GeneralSecurityException e){
			logger.error("签名失败！", e);
			return null;
		}
	}

	
	/**
	 * @param updateData
	 *            明文数据
	 * @param sigedText
	 *            签名后数据
	 * @param CertPath
	 *            证书路径（公钥保存文件）
	 */
	public static void veriSig(byte[] updateData, byte[] sigedText,
			String certPath) {
		try {
			CertificateFactory certificatefactory = CertificateFactory
					.getInstance("X.509");
			FileInputStream fin = new FileInputStream(certPath);
			X509Certificate certificate = (X509Certificate) certificatefactory
					.generateCertificate(fin);
			PublicKey pub = certificate.getPublicKey();
			Signature dsa = Signature.getInstance("SHA1withRSA");
			dsa.initVerify(pub);
			dsa.update(updateData);
			boolean verifies = dsa.verify(sigedText);
			logger.info("verified " + verifies);
			if (verifies) {
				logger.info("Verify is done!");
			} else {
				logger.info("verify is not successful");
			}
		} catch (Exception e) {
			logger.error("veriSig error:", e);
		}
	}
	
	/**
	 * 验证签名
	 * @param updateData
	 *            明文数据
	 * @param sigedText
	 *            签名后数据
	 * @param CertPath
	 *            证书路径（公钥保存文件）
	 */
	public static void veriSig(String updateData, String sigedData,
			String certPath) {
		 veriSig(updateData.getBytes(),HexUtils.fromHexString(sigedData),certPath);
	}
}

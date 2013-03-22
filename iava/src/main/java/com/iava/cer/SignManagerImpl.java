/**
 * SignManagerImpl.java.
 */
package com.iava.cer;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;



/**
 * 签名管理类.
 * 
 * @author yang.ly
 * @version $Id: SignManagerImpl.java, v 0.1 2011-6-14 下午07:28:52 yang.ly Exp $
 */
public class SignManagerImpl implements SignManager {
    private KeyReader keyReaderDemo;

    /**
     * 非对称密钥校验签名
     * 
     * @param key
     * @param content
     * @param signature
     * @param algorithmsName
     * @param algorithms
     * @return
     */
    private boolean keyPairCheck(String key, String content, String signature,
                                String algorithmsName, String algorithms) {
        PublicKey pubKey = null;
        try {
            pubKey = keyReaderDemo.readPublicKey(key, true, algorithmsName);

        } catch (InvalidKeySpecException e) {
        }
        return keyPairCheck(pubKey, content, signature, algorithms);

    }

    /**
     * 签名校验.
     * 
     * @param pubKey
     * @param content
     * @param signature
     * @param algorithms
     * @return true表示成功，false表示失败
     */
    public boolean keyPairCheck(PublicKey pubKey, String content, String signature,
                                String algorithms) {
        try {
            byte[] signed = Base64.decodeBase64(signature.getBytes(DEFAULT_CHARSET));
            Signature signCheck = Signature.getInstance(algorithms);
            signCheck.initVerify(pubKey);
            signCheck.update(content.getBytes(DEFAULT_CHARSET));
            return signCheck.verify(signed);
        } catch (InvalidKeyException e) {
        } catch (UnsupportedEncodingException e) {
        } catch (NoSuchAlgorithmException e) {
        } catch (SignatureException e) {
        }
        return false;
    }

    /**
     * 非对称密钥签名
     * 
     * @param content
     * @param keyStr
     * @param algorithmsName
     * @param algorithms
     * @return 字符串
     */
    public String keyPairSign(String content, String keyStr, String algorithmsName,
                              String algorithms) {

        PrivateKey priKey = null;
        try {
            priKey = keyReaderDemo.readPrivateKey(keyStr, true, algorithmsName);

        } catch (InvalidKeySpecException e) {
        }
        return keyPairSign(content, priKey, algorithms);
    }

    /**
     * 签名.
     * 
     * @param content
     * @param priKey
     * @param algorithms
     * @return 签名后的字符串
     */
    public String keyPairSign(String content, PrivateKey priKey, String algorithms) {

        try {
            Signature signature = Signature.getInstance(algorithms);
            signature.initSign(priKey);
            signature.update(content.getBytes(DEFAULT_CHARSET));
            return new String(Base64.encodeBase64(signature.sign(), false), DEFAULT_CHARSET);
        } catch (InvalidKeyException e) {
        } catch (NoSuchAlgorithmException e) {
        } catch (SignatureException e) {
        } catch (UnsupportedEncodingException e) {
        }

        return null;
    }

    /**
     * md5签名.
     * 
     * @param content
     * @param keyStr
     * @return 签名后的字符串
     */
    public String md5Sign(String content, String keyStr) {
        try {
            return DigestUtils.md5Hex((content + keyStr).getBytes(DEFAULT_CHARSET));
        } catch (UnsupportedEncodingException e) {
        }
        return null;
    }

    /**
     * @see com.alipay.standard.manager.SignManager#sign(java.lang.String, java.lang.String, java.security.PrivateKey)
     */
    public String sign(String content, String signType, PrivateKey priKey) {
        if (signType.equals(RSA_ALGORITHM_NAME)) {
            return keyPairSign(content, priKey, RSA_SIGN_ALGORITHMS);
        } else if (signType.equals(DSA_ALGORITHM_NAME)) {
            return keyPairSign(content, priKey, DSA_SIGN_ALGORITHMS);

        }
        return null;
    }

    /**
     * @see com.alipay.standard.manager.SignManager#sign(java.lang.String, java.lang.String, java.lang.String)
     */
    public String sign(String content, String signType, String key) {
        if (signType.equals(RSA_ALGORITHM_NAME)) {
            return keyPairSign(content, key, RSA_ALGORITHM_NAME, RSA_SIGN_ALGORITHMS);
        } else if (signType.equals(MD5_ALGORITHM_NAME)) {
            md5Sign(content, key);
        } else if (signType.equals(DSA_ALGORITHM_NAME)) {
            return keyPairSign(content, key, DSA_ALGORITHM_NAME, DSA_SIGN_ALGORITHMS);

        }
        return null;
    }

    /**
     * @see com.alipay.standard.manager.SignManager#check(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public boolean check(String signature, String content, String signType, String key) {
        if (signType.equals(RSA_ALGORITHM_NAME)) {
            return keyPairCheck(key, content, signature, RSA_ALGORITHM_NAME, RSA_SIGN_ALGORITHMS);
        } else if (signType.equals(MD5_ALGORITHM_NAME)) {
            return signature.equals(md5Sign(content, key));
        } else if (signType.equals(DSA_ALGORITHM_NAME)) {
            return keyPairCheck(key, content, signature, DSA_ALGORITHM_NAME, DSA_SIGN_ALGORITHMS);

        }
        return false;
    }

    /**
     * @see com.alipay.standard.manager.SignManager#check(java.lang.String, java.lang.String, java.lang.String, java.security.PublicKey)
     */
    public boolean check(String signature, String content, String signType, PublicKey pubKey) {
        if (signType.equals(RSA_ALGORITHM_NAME)) {
            return keyPairCheck(pubKey, content, signature, RSA_SIGN_ALGORITHMS);
        } else if (signType.equals(DSA_ALGORITHM_NAME)) {
            return keyPairCheck(pubKey, content, signature, DSA_SIGN_ALGORITHMS);

        }
        return false;
    }

    /**
     * setting.
     * 
     * @param keyReaderDemo
     */
    public void setKeyReaderDemo(KeyReader keyReaderDemo) {
        this.keyReaderDemo = keyReaderDemo;
    }
}

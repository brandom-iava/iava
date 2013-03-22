package com.iava.cer;

import java.security.PrivateKey;
import java.security.PublicKey;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 密钥工具类.
 * 
 * @author yang.ly
 * @version $Id: KeyUtil.java, v 0.1 2011-6-5 下午05:12:16 yang.ly Exp $
 */
public class KeyUtil {

    /**
     * logger.
     */
    private static final Log  logger = LogFactory.getLog(KeyUtil.class);


    /**
     * 
     * 得到支付宝的公钥.
     * 
     * <p>
     * 支付宝提供给合作伙伴的公钥
     * </p>
     * 
     * @return 公钥
     * @throws Exception
     */
    public static PublicKey getAlipayPubKey(String fileName) {
        KeyReader keyReader = new KeyReader();
        PublicKey alipayPublicKey=null;
        try {
            alipayPublicKey = (PublicKey) keyReader.fromCerStoredFile(fileName);
            if (logger.isInfoEnabled()) {
                logger.info("1:PublicKey => 加密："
                            + new String(Base64.encodeBase64(alipayPublicKey.getEncoded())));
            }
        } catch (Exception e) {
            logger.error("在获取支付宝公钥时，出错！", e);
        }
        return alipayPublicKey;
    }

    /**
     * 
     * 得到自己的私钥.
     * 
     * <p>
     * 使用私钥对报文进行签名
     * </p>
     * 
     * @return 私钥
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String fileName, String privateKeyPwd) {
        KeyReader keyReader = new KeyReader();
        PrivateKey privateKey = null;
        try {
            privateKey = keyReader.readPrivateKeyfromPKCS12StoredFile(fileName,privateKeyPwd);
            if (logger.isInfoEnabled()) {
                logger.info("ca   privateKey => "
                            + new String(Base64.encodeBase64(privateKey.getEncoded())));
            }
        } catch (Exception e) {
            logger.error("在获取自己的私钥时，出错！", e);
        }
        return privateKey;
    }

    /**
     * 
     * 解析文件得到公钥.
     * 
     * @param filename
     *            密钥文件
     * @return 公钥
     */
    public static PublicKey getPublicKey(String filename) {
        KeyReader keyReader = new KeyReader();
        PublicKey pubKey = null;
        try {
            pubKey = (PublicKey) keyReader.fromCerStoredFile(filename);
            if (logger.isInfoEnabled()) {
                logger.info("1:PublicKey => 加密："
                            + new String(Base64.encodeBase64(pubKey.getEncoded())));
            }
        } catch (Exception e) {
            logger.error("在获取支付宝公钥时，出错！", e);
        }
        return pubKey;
    }

}

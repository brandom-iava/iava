package com.iava.cer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Enumeration;

import sun.security.x509.AlgorithmId;
import sun.security.x509.CertificateAlgorithmId;
import sun.security.x509.CertificateIssuerName;
import sun.security.x509.CertificateSerialNumber;
import sun.security.x509.CertificateValidity;
import sun.security.x509.X500Name;
import sun.security.x509.X509CertImpl;
import sun.security.x509.X509CertInfo;
public class KeySignTest {

	/**
	 * 读取证书
	 * @param csrPath
	 * @throws CertificateException
	 * @throws FileNotFoundException
	 */
	public void readCerti(String csrPath) throws CertificateException, FileNotFoundException{
		 CertificateFactory cf=CertificateFactory.getInstance("X.509");
		    FileInputStream in=new FileInputStream(csrPath);
		    Certificate c=cf.generateCertificate(in);
		    System.out.println(c);
	}
	
	/**
	 * 从密钥库中读取证书
	 * @param storePath
	 * @param storePwd
	 * @param alias
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateException
	 * @throws IOException
	 */
	public void readCertiFromKeyStore(String storePath,String storePwd,String alias) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException{
	    FileInputStream in=new FileInputStream(storePath);
	    KeyStore ks=KeyStore.getInstance("JKS");
	    ks.load(in,storePwd.toCharArray());
	    java.security.cert.Certificate c=ks.getCertificate(alias);//alias为条目的
	    
	    System.out.println(c);
	    
	   /* System.out.println("输出证书信息:\n"+c.toString());
	    System.out.println("版本号:"+c..getVersion());
	    System.out.println("序列号:"+t.getSerialNumber().toString(16));
	    System.out.println("主体名："+t.getSubjectDN());
	    System.out.println("签发者："+t.getIssuerDN());
	    System.out.println("有效期："+t.getNotBefore());
	    System.out.println("签名算法："+t.getSigAlgName());
	    byte [] sig=c.getSignature();//签名值 
	    PublicKey pk=t.getPublicKey();
	    byte [] pkenc=pk.getEncoded();  
	    System.out.println("公钥");
	    for(int i=0;i<pkenc.length;i++)System.out.print(pkenc[i]+",");*/
	}
	
	
	/**
	 * 列出密钥库里所有的条目
	 * @param storePath
	 * @param storePwd
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateException
	 * @throws IOException
	 */
	public void listAllStoreItem(String storePath,String storePwd) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException{
		    FileInputStream in=new FileInputStream(storePath);
		    KeyStore ks=KeyStore.getInstance("JKS");
		    ks.load(in,storePwd.toCharArray());
		    Enumeration e=ks.aliases();
		    while(e.hasMoreElements()){
		    	 java.security.cert.Certificate c=ks.getCertificate((String)e.nextElement());
		    }
		   
	}
	
	/**
	 * 修改密钥库口令
	 * @param storePath
	 * @param storePwd
	 * @throws KeyStoreException 
	 * @throws IOException 
	 * @throws CertificateException 
	 * @throws NoSuchAlgorithmException 
	 */
	public void updateStorePwd(String storePath,String storeOldPwd,String storeNewPwd) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException{
		    FileInputStream in=new FileInputStream(storePath);
		    KeyStore ks=KeyStore.getInstance("JKS");
		    ks.load(in,storeOldPwd.toCharArray());
		    in.close();
		    FileOutputStream output=new FileOutputStream(storePath);
		    ks.store(output,storeNewPwd.toCharArray());
		    output.close();
	}
	
	/**
	 * 修改密钥库条目
	 * 第一个参数指定所添加条目的别名，假如使用已存在别名将覆盖已存在条目，使用新别名将增加一个新条目，第二个参数为条目的私钥，第三个为设置的新口令，第四个为该私钥的公钥的证书链
	 * @param storePath
	 * @param alias
	 * @param storePwd
	 * @param newStorePwd
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateException
	 * @throws IOException
	 * @throws UnrecoverableKeyException
	 */
	public void updateStoreItem(String storePath,String alias,String storePwd,String newStorePwd) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, UnrecoverableKeyException{
		 FileInputStream in=new FileInputStream(storePath);
		    KeyStore ks=KeyStore.getInstance("JKS");
		    ks.load(in,storePwd.toCharArray());
		    Certificate []cchain=ks.getCertificateChain(alias);//获取别名对应条目的证书链
		    PrivateKey pk=(PrivateKey)ks.getKey(alias,storePwd.toCharArray());//获取别名对应条目的私钥
		    ks.setKeyEntry(alias,pk,newStorePwd.toCharArray(),cchain);//向密钥库中添加条目
		    
		    FileOutputStream output=new FileOutputStream("newStorePath");
		    ks.store(output,newStorePwd.toCharArray());//将keystore对象内容写入新文件
	}
	
	/**
	 * 检验条目是否在密钥库中
	 * @param storePath
	 * @param storePwd
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws CertificateException
	 * @throws IOException
	 */
	public void containAliasInStore(String storePath,String storePwd) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException{
		 FileInputStream in=new FileInputStream(storePath);
		    KeyStore ks=KeyStore.getInstance("JKS");
		    ks.load(in,storePwd.toCharArray());
		    ks.containsAlias("sage");//检验条目是否在密钥库中，存在返回true
		    ks.deleteEntry("sage");//删除别名对应的条目
		    FileOutputStream output=new FileOutputStream(storePath);
		    ks.store(output,storePwd.toCharArray());//将keystore对象内容写入文件,条目删除成功
	}
	
	/**
	 * 签发证书
	 * @throws KeyStoreException 
	 * @throws IOException 
	 * @throws CertificateException 
	 * @throws NoSuchAlgorithmException 
	 * @throws UnrecoverableKeyException 
	 * @throws SignatureException 
	 * @throws NoSuchProviderException 
	 * @throws InvalidKeyException 
	 */
	public void signCerti(String storePath,String storePwd) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, UnrecoverableKeyException, InvalidKeyException, NoSuchProviderException, SignatureException{
		//（1）从密钥库中读取CA的证书
		FileInputStream in=new FileInputStream(storePath);
	    KeyStore ks=KeyStore.getInstance("JKS");
	    ks.load(in,storePwd.toCharArray());
	    java.security.cert.Certificate c1=ks.getCertificate("caroot");
	    
	    //（2）从密钥库中读取CA的私钥
	    PrivateKey caprk=(PrivateKey)ks.getKey("alias","cakeypass".toCharArray());
	    
	    //（3）从CA的证书中提取签发者的信息
	    byte[] encod1=c1.getEncoded();    //提取CA证书的编码
	    X509CertImpl cimp1=new X509CertImpl(encod1); // 用该编码创建X509CertImpl类型对象
	    X509CertInfo cinfo1=(X509CertInfo)cimp1.get(X509CertImpl.NAME+"."+X509CertImpl.INFO); // 获取X509CertInfo对象
	    X500Name issuer=(X500Name)cinfo1.get(X509CertInfo.SUBJECT+"."+CertificateIssuerName.DN_NAME); //获取X509Name类型的签发者信息
	    
	    //（4）获取待签发的证书
	    CertificateFactory cf=CertificateFactory.getInstance("X.509");
	    FileInputStream in2=new FileInputStream("user.csr");
	    java.security.cert.Certificate c2=cf.generateCertificate(in);
	    //（5）从待签发的证书中提取证书信息
	    byte [] encod2=c2.getEncoded();
	    X509CertImpl cimp2=new X509CertImpl(encod2); // 用该编码创建X509CertImpl类型对象
	    X509CertInfo cinfo2=(X509CertInfo)cimp2.get(X509CertImpl.NAME+"."+X509CertImpl.INFO);  //获取X509CertInfo对象
	    
	    //（6）设置新证书有效期
	    Date begindate=new Date(); //获取当前时间
	    Date enddate=new Date(begindate.getTime()+3000*24*60*60*1000L); //有效期为3000天
	    CertificateValidity cv=new CertificateValidity(begindate,enddate); //创建对象
	    cinfo2.set(X509CertInfo.VALIDITY,cv); // 设置有效期
	    //（7）设置新证书序列号
	    int sn=(int)(begindate.getTime()/1000);    //以当前时间为序列号
	    CertificateSerialNumber csn=new CertificateSerialNumber(sn);
	    cinfo2.set(X509CertInfo.SERIAL_NUMBER,csn);
	    //（8）设置新证书签发者
	    cinfo2.set(X509CertInfo.ISSUER+"."+CertificateIssuerName.DN_NAME,issuer);//应用第三步的结果
	    
	    //（9）设置新证书签名算法信息
	    AlgorithmId algorithm=new AlgorithmId(AlgorithmId.md5WithRSAEncryption_oid);
	    cinfo2.set(CertificateAlgorithmId.NAME+"."+CertificateAlgorithmId.ALGORITHM,algorithm);
	    //（10）创建证书并使用CA的私钥对其签名
	    X509CertImpl newcert=new X509CertImpl(cinfo2);
	    newcert.sign(caprk,"MD5WithRSA"); //使用CA私钥对其签名
	    //（11）将新证书写入密钥库
	    ks.setCertificateEntry("lf_signed",newcert);
	    FileOutputStream out=new FileOutputStream("newstore");
	    ks.store(out,"newpass".toCharArray());  //这里是写入了新的密钥库，也可以使用第七条来增加条目
	}
	
	public void verifyCerti(String crtPath) throws CertificateException, IOException {
		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		FileInputStream in1 = new FileInputStream(crtPath);
		java.security.cert.Certificate c1 = cf.generateCertificate(in1);
		X509Certificate t = (X509Certificate) c1;
		in1.close();
		// （b）获取日期
		Date TimeNow = new Date();
		// （c）检验有效性
		try {
			t.checkValidity(TimeNow);
			System.out.println("OK");
		} catch (CertificateExpiredException e) { // 过期
			System.out.println("Expired");
			System.out.println(e.getMessage());
		} catch (CertificateNotYetValidException e) { // 尚未生效
			System.out.println("Too early");
			System.out.println(e.getMessage());
		}
		// （2）验证证书签名的有效性
		// （a）获取CA证书
		CertificateFactory cf1 = CertificateFactory.getInstance("X.509");
		FileInputStream in2 = new FileInputStream("caroot.crt");
		java.security.cert.Certificate cac = cf.generateCertificate(in2);
		in2.close();
		// （c）获取CA的公钥
		PublicKey pbk = cac.getPublicKey();
		// （b）获取待检验的证书（上步已经获取了，就是C1）
		// （c）检验证书
		boolean pass = false;
		try {
			c1.verify(pbk);
			pass = true;
		} catch (Exception e) {
			pass = false;
			System.out.println(e);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

}

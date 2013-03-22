
安装Win32OpenSSL-0_9_8g.exe
然后在安装目录的/bin目录下，进入CMD

实行的命令如下：
1.
openssl genrsa -out ca1.key 1024

2.
openssl genrsa -out ca1.key -des3 1024

3.
openssl req -new -x509 -days 3650 -key ca1.key -out ca1.crt

4.
openssl pkcs12 -export -in ca1.crt -inkey ca1.key -out ca1.pfx

然后在安装目录下可以看到两个文件：
 公钥（ca1.crt） 和 私钥（ca1.pfx）
 
 
 
 cer后缀的证书文件有两种编码-->DER二进制编码或者BASE64编码(也就是.pem) 

p7b一般是证书链，里面包括1到多个证书 
pfx是指以pkcs#12格式存储的证书和相应私钥。 

在Security编程中，有几种典型的密码交换信息文件格式: 
DER-encoded certificate: .cer, .crt 
PEM-encoded message: .pem 
PKCS#12 Personal Information Exchange: .pfx, .p12 
PKCS#10 Certification Request: .p10 
PKCS#7 cert request response: .p7r 
PKCS#7 binary message: .p7b 

.cer/.crt是用于存放证书，它是2进制形式存放的，不含私钥。 
.pem跟crt/cer的区别是它以Ascii来表示。 
pfx/p12用于存放个人证书/私钥，他通常包含保护密码，2进制方式 
p10是证书请求 
p7r是CA对证书请求的回复，只用于导入 
p7b以树状展示证书链(certificate chain)，同时也支持单个证书，不含私钥。 

其中，我介绍如何从p12/pfx文件中提取密钥对及其长度: 
1，首先，读取pfx/p12文件（需要提供保护密码） 
2，通过别名(Alias,注意，所有证书中的信息项都是通过Alias来提取的)提取你想要分析的证书链 
3，再将其转换为一个以X509证书结构体 
4，提取里面的项，如果那你的证书项放在第一位（单一证书），直接读取 x509Certs[0]（见下面的代码）这个X509Certificate对象 
5，X509Certificate对象有很多方法，tain198127网友希望读取RSA密钥（公私钥）及其长度（见http://www.matrix.org.cn/thread.shtml?topicId=43786&forumId=55&#reply），那真是太Easy了， 
            X509Certificate keyPairCert = x509Certs[0]; 
            int iKeySize = X509CertUtil.getCertificateKeyLength(keyPairCert); 
            System.out.println("证书密钥算法="+keyPairCert.getPublicKey().getAlgorithm()); 
            System.out.println("证书密钥长度="+iKeySize); 
提取了他所需要的信息。 



X.509定义了两种证书：公钥证书和属性证书   
  PKCS#7和PKCS#12使用的都是公钥证书   
  PKCS＃7的SignedData的一种退化形式可以分发公钥证书和CRL   
  一个SignedData可以包含多张公钥证书   
  PKCS＃12可以包含公钥证书及其私钥，也可包含整个证书链   



简介 
Java自带的keytool工具是个密钥和证书管理工具。它使用户能够管理自己的公钥/私钥对及相关证书，用于（通过数字签名）自我认证（用户向别的用户/服务认证自己）或数据完整性以及认证服务。它还允许用户储存他们的通信对等者的公钥（以证书形式）。 

keytool 将密钥和证书储存在一个所谓的密钥仓库（keystore）中。缺省的密钥仓库实现将密钥仓库实现为一个文件。它用口令来保护私钥。 

Java KeyStore的类型 
JKS和JCEKS是Java密钥库(KeyStore)的两种比较常见类型(我所知道的共有5种，JKS, JCEKS, PKCS12, BKS，UBER)。 

JKS的Provider是SUN，在每个版本的JDK中都有，JCEKS的Provider是SUNJCE，1.4后我们都能够直接使用它。 

JCEKS在安全级别上要比JKS强，使用的Provider是JCEKS(推荐)，尤其在保护KeyStore中的私钥上（使用TripleDes）。 

PKCS#12是公钥加密标准，它规定了可包含所有私钥、公钥和证书。其以二进制格式存储，也称为 PFX 文件，在windows中可以直接导入到密钥区，注意，PKCS#12的密钥库保护密码同时也用于保护Key。 

BKS 来自BouncyCastle Provider，它使用的也是TripleDES来保护密钥库中的Key，它能够防止证书库被不小心修改（Keystore的keyentry改掉1个 bit都会产生错误），BKS能够跟JKS互操作，读者可以用Keytool去TryTry。 

UBER比较特别，当密码是通过命令行提供的时候，它只能跟keytool交互。整个keystore是通过PBE/SHA1/Twofish加密，因此keystore能够防止被误改、察看以及校验。以前，Sun JDK(提供者为SUN)允许你在不提供密码的情况下直接加载一个Keystore，类似cacerts，UBER不允许这种情况。 

  
证书导入 
Der/Cer证书导入： 

要从某个文件中导入某个证书，使用keytool工具的-import命令： 

keytool -import -file mycert.der -keystore mykeystore.jks 

如果在 -keystore 选项中指定了一个并不存在的密钥仓库，则该密钥仓库将被创建。 

如果不指定 -keystore 选项，则缺省密钥仓库将是宿主目录中名为 .keystore 的文件。如果该文件并不存在，则它将被创建。 

创建密钥仓库时会要求输入访问口令，以后需要使用此口令来访问。可使用-list命令来查看密钥仓库里的内容： 

keytool -list -rfc -keystore mykeystore.jks 




P12格式证书导入： 

keytool无法直接导入PKCS12文件。 

第一种方法是使用IE将pfx证书导入，再导出为cert格式文件。使用上面介绍的方法将其导入到密钥仓库中。这样的话仓库里面只包含了证书信息，没有私钥内容。 


第二种方法是将pfx文件导入到IE浏览器中，再导出为pfx文件。 
       新生成的pfx不能被导入到keystore中，报错：keytool错误： java.lang.Exception: 所输入的不是一个 X.509 认证。新生成的pfx文件可以被当作keystore使用。但会报个错误as unknown attr1.3.6.1.4.1.311.17.1,查了下资料,说IE导出的就会这样,使用Netscape就不会有这个错误. 

第三种方法是将pfx文件当作一个keystore使用。但是通过微软的证书管理控制台生成的pfx文件不能直接使用。keytool不认此格式，报keytool错误： java.io.IOException: failed to decrypt safe contents entry。需要通过OpenSSL转换一下： 

1）openssl pkcs12 -in mycerts.pfx -out mycerts.pem 

2）openssl pkcs12 -export -in mycerts.pem -out mykeystore.p12 

通过keytool的-list命令可检查下密钥仓库中的内容： 

keytool -rfc -list -keystore mykeystore.p12 -storetype pkcs12 

这里需要指明仓库类型为pkcs12，因为缺省的类型为jks。这样此密钥仓库就即包含证书信息也包含私钥信息。 
P7B格式证书导入： 
keytool无法直接导入p7b文件。 
需要将证书链RootServer.p7b（包含根证书）导出为根rootca.cer和子rootcaserver.cer 。 
将这两个证书导入到可信任的密钥仓库中。 
keytool -import -alias rootca -trustcacerts -file rootca.cer -keystore testkeytrust.jks 
遇到是否信任该证书提示时，输入y 
keytool -import -alias rootcaserver -trustcacerts -file rootcaserver.cer -keystore testkeytrust.jks 


总结: 

1)P12格式的证书是不能使用keytool工具导入到keystore中的 

2)The Sun's PKCS12 Keystore对从IE和其他的windows程序生成的pfx格式的证书支持不太好. 

3)P7B证书链不能直接导入到keystore，需要将里面的证书导出成cer格式，再分别导入到keystore。


证书格式：
目前数字证书的格式普遍采用的是X.509V3国际标准，内容包括证书序列号、证书持有者名称、证书颁发者名称、证书有效期、公钥、证书颁发者的数字签名等.
依据《电子认证服务管理办法》《中华人民共和国电子签名法》，目前国内有30家机构获得相关资质，具体资质可以查询工业信息化部网站。
数字证书文件格式（cer和pfx）的区别:
作为文件形式存在的证书一般有这几种格式：
1.带有私钥的证书 由Public Key Cryptography Standards #12，PKCS#12标准定义，包含了公钥和私钥的二进制格式的证书形式，以pfx作为证书文件后缀名。
2.二进制编码的证书 证书中没有私钥，DER 编码二进制格式的证书文件，以cer作为证书文件后缀名。 3.Base64编码的证书 证书中没有私钥，BASE64 编码格式的证书文件，也是以cer作为证书文件后缀名。
由定义可以看出，只有pfx格式的数字证书是包含有私钥的，cer格式的数字证书里面只有公钥没有私钥。
在pfx证书的导入过程中有一项是“标志此密钥是可导出的。这将您在稍候备份或传输密钥”。一般是不选中的，如果选中，别人就有机会备份你的密钥了。如果是不选中，其实密钥也导入了，只是不能再次被导出。这就保证了密钥的安全。
如果导入过程中没有选中这一项，做证书备份时“导出私钥”这一项是灰色的，不能选。只能导出cer格式的公钥。如果导入时选中该项，则在导出时“导出私钥”这一项就是可选的。
如果要导出私钥（pfx),是需要输入密码的，这个密码就是对私钥再次加密，这样就保证了私钥的安全，别人即使拿到了你的证书备份（pfx),不知道加密私钥的密码，也是无法导入证书的。相反，如果只是导入导出cer格式的证书，是不会提示你输入密码的。因为公钥一般来说是对外公开的，不用加密。

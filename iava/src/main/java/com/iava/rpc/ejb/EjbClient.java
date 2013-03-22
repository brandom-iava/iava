package com.iava.rpc.ejb;

import java.util.Properties;

import javax.naming.InitialContext;

public class EjbClient {

	public static void main(String args[]){
		//经由JNDI命明和目录服务获取EJB
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.provider.url", "localhost:1099");
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming");
		try {
		    InitialContext ctx = new InitialContext(props);
		    AnimalBeanLocal proxy;
		    proxy = (AnimalBeanLocal) ctx.lookup("AnimalBean/remote");
		    System.out.println(proxy.getMonkeyName());
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
}

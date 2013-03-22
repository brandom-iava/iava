package com.iava.rpc.ejb;

import javax.xml.ws.Endpoint;

import com.iava.rpc.rmi.AnimalServiceImp;
import com.iava.rpc.rmi.IAnimalService;

public class EjbServer {
	public static void main(String args[]){
		IAnimalService serviceInstance = new AnimalServiceImp();
		final String address = "http://localhost:9000/animalService"; //服务名称
		Endpoint.publish(address, serviceInstance); //绑定并发布服务
	}
}

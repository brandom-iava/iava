package com.iava.opensource.zookeeper;

import java.util.List;

import org.I0Itec.zkclient.ZkClient;

public class ClusterServer {

	public static void join(String appServer, String zkServer){
		ZkClient zkClient = new ZkClient(zkServer);  
		if(!zkClient.exists(Constant.ROOT)){
			zkClient.createPersistent(Constant.ROOT);
		}else{
			zkClient.createEphemeral(Constant.ROOT + Constant.PATH_SPLIT + appServer);
		}
		
	}
}

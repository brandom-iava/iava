package com.iava.opensource.zookeeper;

import org.I0Itec.zkclient.ZkClient;

public class ClusterServer {

	public static void join(String appServer, String zkServer){
		ZkClient zkClient = new ZkClient(zkServer);  
		if(!zkClient.exists(Constant.ROOT)){
			zkClient.createPersistent(Constant.ROOT);
			zkClient.createEphemeral(Constant.ROOT + Constant.PATH_SPLIT + appServer);
		}else{
			zkClient.createEphemeral(Constant.ROOT + Constant.PATH_SPLIT + appServer);
		}
		
	}
}

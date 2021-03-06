package com.iava.opensource.zookeeper;

import java.util.List;

import org.I0Itec.zkclient.ZkClient;

public class RoundRobinLoadBalance implements LoadBlance {

	@Override
	public String select(String zkServer) {
		ZkClient zkClient = new ZkClient(zkServer);
		List<String> serverList = zkClient.getChildren(Constant.ROOT);
		int round = 0;
		if (!zkClient.exists(Constant.ROUND)) {
			zkClient.createPersistent(Constant.ROUND);
			zkClient.writeData(Constant.ROUND, 0);
		} else {
			round = (Integer) zkClient.readData(Constant.ROUND);
			zkClient.writeData(Constant.ROUND, ++round);
		}
		zkClient.close();
		if (serverList != null && serverList.size() > 0) {
			return serverList.get(round % serverList.size());
		} else {
			return null;
		}

	}

}

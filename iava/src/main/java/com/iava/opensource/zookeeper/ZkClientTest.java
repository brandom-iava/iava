package com.iava.opensource.zookeeper;

import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkStateListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.Watcher.Event.KeeperState;

public class ZkClientTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ZkClient client = new ZkClient("localhost:2181");
		client.subscribeStateChanges(new IZkStateListener() {
			public void handleStateChanged(KeeperState state) throws Exception {
				if (state == KeeperState.Disconnected) {
					stateChanged();
				} else if (state == KeeperState.SyncConnected) {
					stateChanged();
				}
			}
			public void handleNewSession() throws Exception {
				stateChanged();
			}
		});
		client.subscribeChildChanges("/dubbo/test", new IZkChildListener() {
			
			public void handleChildChange(String parentPath, List<String> currentChilds)
					throws Exception {
				System.out.println(parentPath);
				System.out.println(currentChilds);
				
			}
		});
		
		client.createEphemeral("/dubbo/test/data3");
		Thread.sleep(60000 * 2);
	}
	
	
	static void stateChanged(){
		
	}

}

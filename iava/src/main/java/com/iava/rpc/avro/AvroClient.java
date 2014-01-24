package com.iava.rpc.avro;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.avro.ipc.NettyTransceiver;
import org.apache.avro.ipc.specific.SpecificRequestor;
import org.apache.avro.util.Utf8;

public class AvroClient {

	public static void main(String args[]) throws IOException  {
		  NettyTransceiver client = new NettyTransceiver(new InetSocketAddress(65111));
	        // client code - attach to the server and send a message
	        Mail proxy = (Mail) SpecificRequestor.getClient(Mail.class, client);
	        System.out.println("Client built, got proxy");

	        // fill in the Message record and send it
	        Message message = new Message();
	        message.setTo(new Utf8("test"));
	        message.setFrom(new Utf8("test2"));
	        message.setBody(new Utf8("hello"));
	        System.out.println("Calling proxy.send with message:  " + message.toString());
	        System.out.println("Result: " + proxy.send(message));

	        // cleanup
	        client.close();
	}
	
}

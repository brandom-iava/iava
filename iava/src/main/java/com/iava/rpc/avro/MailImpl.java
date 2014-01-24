package com.iava.rpc.avro;

import org.apache.avro.AvroRemoteException;

public class MailImpl implements Mail{

	@Override
	public CharSequence send(Message message) throws AvroRemoteException {
		 System.out.println("Sending message");
         return ("Sending message to " + message.getTo().toString()
                 + " from " + message.getFrom().toString()
                 + " with body " + message.getBody().toString());
	}

}

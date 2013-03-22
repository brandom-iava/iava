package com.iava.nio;

import java.nio.ByteBuffer;

public class ByteBufferTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ByteBuffer bb = ByteBuffer.allocate(8);
		bb.putInt(1);
		bb.putInt(2);
		bb.flip();
		
		System.out.println(bb.getInt());
	}

}

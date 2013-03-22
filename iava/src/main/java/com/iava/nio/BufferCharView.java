package com.iava.nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.IntBuffer;

public class BufferCharView {

	public static void main(String[] argv) throws Exception {
		ByteBuffer byteBuffer = ByteBuffer.allocate(7).order(
				ByteOrder.BIG_ENDIAN);
		CharBuffer charBuffer = byteBuffer.asCharBuffer(); // Load the
															// ByteBuffer with
															// some bytes
		IntBuffer intBuffer = byteBuffer.asIntBuffer();
		byteBuffer.put(0, (byte) 0);
		byteBuffer.put(1, (byte) 'H');
		byteBuffer.put(2, (byte) 0);
		byteBuffer.put(3, (byte) 'i');
		byteBuffer.put(4, (byte) 0);
		byteBuffer.put(5, (byte) '!');
		byteBuffer.put(6, (byte) 0);
		charBuffer.put(1, 'W');
		println(byteBuffer);
		println(charBuffer);
		println(intBuffer);
	}

	private static void println(Buffer buffer) {
		System.out.println("pos=" + buffer.position() + ", limit="
				+ buffer.limit() + ", capacity=" + buffer.capacity() + ": '"
				+ buffer.toString() + "'");
	}
}

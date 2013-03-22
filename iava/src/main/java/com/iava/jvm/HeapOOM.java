package com.iava.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args£º-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author yf2-wubp
 *
 */
public class HeapOOM {
	static class OOMObject {
	}

	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<OOMObject>();

		while (true) {
			list.add(new OOMObject());
		}
	}
}

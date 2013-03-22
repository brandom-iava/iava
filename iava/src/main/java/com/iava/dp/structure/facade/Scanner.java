package com.iava.dp.structure.facade;

import java.io.InputStream;

public abstract class Scanner {

	private InputStream istream = null;
	
	public Scanner(InputStream stream)
	{
		
	}
	
	abstract String Scan();
}

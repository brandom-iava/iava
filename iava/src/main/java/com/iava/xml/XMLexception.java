/*
 * Copyright 2003 Paul Marrington - All rights reserved - http://marringtons.com
 * Use is subject to license terms at http://marringtons.com/Java/Library/artistic.license.html
 * You may freely use this code as long as this header remains intact.
 *
 * Updates:
 * 	15-Jun-2004 created
 */
package com.iava.xml;

/**
 * Throw this exception if you need one tagged for XML errors
 * @author Paul Marrington
 */
public class XMLexception extends Exception
	{
		/**
     * <code>serialVersionUID</code> as required for serialisable classes.
     */
    private static final long serialVersionUID = 3762250838038557753L;

		/**
		 * Default constructor - consider using one with a message
		 */
		public XMLexception() { super(); }

		/**
		 * Exception with a cause message
		 * @param message to describe the problem.
		 */
		public XMLexception(String message) { super(message); }

		/**
		 * A nested exception.
		 * @param cause exception that is wrapped in this exception
		 */
		public XMLexception(Throwable cause) { super(cause); }

		/**
		 * A nested exception with more written comments.
		 * @param message to describe the problem.
		 * @param cause exception that is wrapped in this exception
		 */
		public XMLexception(String message, Throwable cause) { super(message, cause); }

	}

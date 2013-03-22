package com.iava.dp.behavioral.template.demo1;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;


public class MyApplication extends Application {
    // implement Factory Method
    public  Document createDocument() {
        return  DocumentFactory.getInstance().createDocument();
    }
 
    // implement Template Method
    public  boolean canOpenDocument(String name) {
        // implemented code here
    	return true;
    }
 
    public void aboutToOpenDocument(Document doc) {
        // implemented code here
    }
}

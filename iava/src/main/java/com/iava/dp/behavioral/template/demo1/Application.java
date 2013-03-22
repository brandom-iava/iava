package com.iava.dp.behavioral.template.demo1;

import org.dom4j.Document;

public abstract class Application {
    // .....
 
    public void openDocument(String name) {
        // Template Method
        if(!canOpenDocument(name)) { // unable to open file
            // show error message, throw exception
            return;
        }
 
        Document doc = createDocument(); // Factory Method
 
        if(doc != null) {
        	/*doc.addDocument(doc); 
            // Template Method
            aboutToOpenDocument(doc);
             doc.open();
             doc.doRead();*/
        }
    }
 
    public abstract Document createDocument(); // Factory Method
 
    // Template Method
    public abstract boolean canOpenDocument(String name);
    public abstract void aboutToOpenDocument(Document doc);
}


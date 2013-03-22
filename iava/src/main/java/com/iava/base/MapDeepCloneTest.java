package com.iava.base;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MapDeepCloneTest {

	class customHashMap extends HashMap{
	       Logger lgo = Logger.getLogger("CRMLOG");
        public customHashMap(){
            super();
        }
        public customHashMap(int initialCapacity){
            super(initialCapacity);
        }
        public Object clone(){
            Map target = new HashMap();
            for(Iterator keyIt = this.keySet().iterator();keyIt.hasNext();){
            	lgo.debug("teststet");
                Object key = keyIt.next();
                target.put(key,this.get(key));
            }
            return target;
        }
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	PropertyConfigurator.configure("log4j.properties");
        Logger logger  =  Logger.getLogger(MapDeepCloneTest.class );
        Logger fLogger = Logger.getLogger("crm_log");
        fLogger.debug("fsfsdfsdf");
         
        customHashMap source  = (new MapDeepCloneTest()).new customHashMap();
        source.put("key1","value1");
        source.put("key2","value2");
       
        for(Iterator keyItr = source.keySet().iterator();keyItr.hasNext();){
            Object key = keyItr.next();
            System.out.println(key + " : "+source.get(key));
        }
       
        System.out.println("----------------- 1 ----------------");
        logger.debug("----------------- 1 ----------------");
       
        Map target = (Map)source.clone();
        target.put("key1","modify value1");
       
        System.out.println("----------------- 2 the souce map print----------------");
        for(Iterator keyItr = source.keySet().iterator();keyItr.hasNext();){
            Object key = keyItr.next();
            System.out.println(key + " : "+source.get(key));
        }
       
        System.out.println("----------------- 3 the target map print----------------");
        for(Iterator keyItr = target.keySet().iterator();keyItr.hasNext();){
            Object key = keyItr.next();
            System.out.println(key + " : "+target.get(key));
        }
       
       
       
    }
}

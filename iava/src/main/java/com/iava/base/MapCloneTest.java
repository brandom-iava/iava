package com.iava.base;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
* @author wangwu
*
*/
public class MapCloneTest {

   /**
    * @param args
    */
   public static void main(String[] args) {
       

       HashMap source = new HashMap();
       source.put("key1","value1");
       source.put("key2","value2");
      
       for(Iterator keyItr = source.keySet().iterator();keyItr.hasNext();){
           Object key = keyItr.next();
           System.out.println(key + " : "+source.get(key));
       }
      
       System.out.println("----------------- 1 ----------------");
      
       Map targetMap = (HashMap)source.clone();
      
       for(Iterator keyItr = targetMap.keySet().iterator();keyItr.hasNext();){
           Object key = keyItr.next();
           System.out.println(key + " : "+source.get(key));
       }
      
       System.out.println("---------------- 2 ----------------");
      
       Object aa = targetMap.put("key1","modify key1");
       System.out.println("aa = "+aa);
      
       for(Iterator keyItr = source.keySet().iterator();keyItr.hasNext();){
           Object key = keyItr.next();
           System.out.println(key + " : "+source.get(key));
       }
   }

}

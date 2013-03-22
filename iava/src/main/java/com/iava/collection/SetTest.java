package com.iava.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class SetTest {

	private static List list = Collections.synchronizedList(new ArrayList());
	
	/**
	 * @param args
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("1");
		set.add("2");
		set.add("3");
		set.add("4");
		set.add("4");
		System.out.println(set);
		
		
		Set set1 = new HashSet();
		set1.add(new Person("001","张三",23));
		set1.add(new Person("002","李四",25));
		set1.add(new Person("003","王五",14));
		set1.add(new Person("004","李四",43));
		set1.add(new Person("004","李四",43));
		
		
		System.out.println("Hashset : "+set1);
		
		Set sortSet = new TreeSet();
		sortSet.add(new Person("001","张三",23));
		sortSet.add(new Person("002","李四",25));
		sortSet.add(new Person("003","王五",14));
		sortSet.add(new Person("004","李四",43));
		sortSet.add(new Person("004","李四",43));
		System.out.println("Treeset : "+sortSet);
		
		Set sortSet1 = new TreeSet(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				if(o1.age == o2.age){
					return 0;
				}else if(o1.age > o2.age){
					return -1;
				}else{
					return 1;
				}
			}
		});
		
		sortSet1.add(new Person("001","张三",23));
		sortSet1.add(new Person("002","李四",25));
		sortSet1.add(new Person("003","王五",14));
		sortSet1.add(new Person("004","李四",43));
		sortSet1.add(new Person("004","李四",43));
		System.out.println("Treeset : " + sortSet1);
		Map map = new HashMap();
		map.put("111", "张三");
		map.put("222", "张三");
		map.put("121", "张三");
		
		Map lMap = new LinkedHashMap();
		lMap.put("111", "张三");
		lMap.put("222", "张三");
		lMap.put("121", "张三");
		lMap.put("222", "张三");
		
		System.out.println("Treeset : " + lMap);
		
		Map treeMap = new TreeMap();
		
		
	}

}

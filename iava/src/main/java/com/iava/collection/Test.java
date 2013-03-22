package com.iava.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Test {

	public static void main(String args[]){
		List l = new ArrayList();
		l.add(null);
		l.add(null);
		System.out.print(l.size());
		System.out.print(l);
		
		Set set = new HashSet();
		set.add(null);
		set.add(null);
		System.out.println(set.size());
		
		Map map = new HashMap();
		map.put("hello", null);
		System.out.println(map.size());
		System.out.println(map);
		
		Set<Person> set1 = new TreeSet<Person>(/*new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getId().compareTo(o2.getId());
			}
		}*/);
		set1.add(new Person("1","wubp",29));
		set1.add(new Person("2","wanggh",29));
		set1.add(new Person("4","wanggh",29));
		set1.add(new Person("3","wanggh",29));
		System.out.println(set1);
		
		HashSet<Person> hs = new HashSet<Person>();
		hs.add(new Person("1","wubp",29));
		hs.add(new Person("3","wanggh",29));
		hs.add(new Person("2","wujy",29));
		hs.add(new Person("3","wanggy",29));
		System.out.println("HashSet : "+hs);
	}
}

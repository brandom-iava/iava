package com.iava.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class FastjsonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map map = new HashMap();
		Map rot = new HashMap();
		map.put("InputRoot", rot);
		Map cont = new HashMap();
		
		rot.put("ControlInfo", cont);
		cont.put("TransactionID", "111");
		cont.put("ServiceCode", "w222");
		
		Map param = new HashMap();
		rot.put("Params", param);
		
		param.put("BapLatnId", "551");
		Map data = new HashMap();
		param.put("Data", data);
		data.put("serviceNbr", "7634923");
		List<Map> list = new ArrayList<Map>();
		Map lMap1 = new HashMap();
		Map lMap2 = new HashMap();
		lMap1.put("test2", "111");
		lMap2.put("test3", "111");
		list.add(lMap1);
		list.add(lMap2);
		data.put("offrelst", list);
		System.out.println(JSON.toJSON(map));
		
		
		Map billMap = new HashMap();
		billMap.put("SvcName", "NOPAYQRY");
		billMap.put("LatnId", "551");
		billMap.put("Params", lMap1);
		System.out.println(JSON.toJSON(billMap));
		
	}

}

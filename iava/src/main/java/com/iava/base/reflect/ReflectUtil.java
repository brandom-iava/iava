package com.iava.base.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 反射机制工具类
 * 
 * @author Administrator
 * 
 */
public class ReflectUtil {

	private static Logger logger = LoggerFactory.getLogger(ReflectUtil.class);

	/**
	 * 通过反射机制将穿过来的VO对象转换成insert sql语句。
	 * 
	 * @param vo
	 * @return
	 */
	public static String createInsertSqlByVo(Vo vo) {

		logger.info("createInsertSqlByVo {}", vo.toString());

		StringBuilder prefix = new StringBuilder();
		StringBuilder values = new StringBuilder();
		Class<?> voClass = vo.getClass();
		Object obj = null;

		try {
			obj = voClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		Field[] fields = voClass.getDeclaredFields();
		if (fields.length == 0) {
			logger.warn("createInsertSqlByVo because lack of field {}", vo.toString());
			return prefix.toString();
		}

		prefix.append("INSERT INTO s_student(");
		values.append(" VALUES(");
		// 提取每个字段
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			boolean isStringType = false;
			if (f.getType() == java.lang.String.class || f.getType() == java.lang.Character.class) {
				isStringType = true;
			}
			// 获取字段名
			String fieldName = f.getName();
			// 通过字段名获取对应的get方法getXxxx()
			String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			Object params[] = { fieldName, getMethodName, f.getType() };
			logger.info("field is {}, and its get function is {}(), field type is {}", params);
			Object getValue = null;
			try {
				// 通过get方法名和参数列表获取get方法，由于get方法没有参数，所有为new Class[]{}
				Method getMethod = voClass.getMethod(getMethodName, new Class[] {});
				getValue = getMethod.invoke(vo, new Object[] {});
				logger.info("{}()={}", getMethodName, getValue);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

			// 不是最后一个字段
			if (i != fields.length - 1) {
				prefix.append(fieldName + ", ");
				if (isStringType) {
					values.append("'" + getValue + "', ");
				} else {
					values.append(getValue + ", ");
				}
			} else {// 最后一个字段
				prefix.append(fieldName + ")");
				if (isStringType) {
					values.append("'" + getValue + "')");
				} else {
					values.append(getValue + ")");
				}
			}
		}
		prefix = prefix.append(values);
		logger.info("createInsertSqlByVo is {}", prefix.toString());

		return prefix.toString();
	}

	public static void main(String args[]) {

		StudentReflectVo vo = new StudentReflectVo();
		vo.setS_id(1);
		vo.setS_name("reflect");
		vo.setS_sex("1");
		vo.setS_age(20);
		vo.setS_telephone("18664306011");
		vo.setS_address("湖南省长沙市雨花区中南林业科技大学");
		vo.setS_qq("123456789");
		StudentReflectVo vo1 = new StudentReflectVo(1, "test", "1", 22, "13999999999", "xxxxxx", "123456789");
		System.out.println(ReflectUtil.createInsertSqlByVo(vo1));

		// TestVo t = new TestVo();
		// t.setId(100);
		// t.setName("Test");
		// ReflectUtil.createInsertSqlByVo(t);
	}
}
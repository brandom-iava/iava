package com.iava.base.reflect;


@SuppressWarnings("serial")
public class StudentReflectVo implements Vo {

	public StudentReflectVo() {
	}

	public StudentReflectVo(int s_id, String s_name, String s_sex, int s_age, String s_address, String s_telephone, String s_qq) {
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_sex = s_sex;
		this.s_age = s_age;
		this.s_address = s_address;
		this.s_telephone = s_telephone;
		this.s_qq = s_qq;
	}

	private int s_id;

	private String s_name;

	private String s_sex;

	private int s_age;

	private String s_address;

	private String s_telephone;

	private String s_qq;

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_sex() {
		return s_sex;
	}

	public void setS_sex(String s_sex) {
		this.s_sex = s_sex;
	}

	public int getS_age() {
		return s_age;
	}

	public void setS_age(int s_age) {
		this.s_age = s_age;
	}

	public String getS_address() {
		return s_address;
	}

	public void setS_address(String s_address) {
		this.s_address = s_address;
	}

	public String getS_telephone() {
		return s_telephone;
	}

	public void setS_telephone(String s_telephone) {
		this.s_telephone = s_telephone;
	}

	public String getS_qq() {
		return s_qq;
	}

	public void setS_qq(String s_qq) {
		this.s_qq = s_qq;
	}


}
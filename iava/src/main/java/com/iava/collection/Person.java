package com.iava.collection;

public class Person implements Comparable<Person>{

	public String id;
	
	public String username;
	public int age;
	
	public Person(String id, String username,int age) {
		super();
		this.id = id;
		this.username = username;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", username=" + username + ", age=" + age
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int compareTo(Person o) {
		if(this.age == o.age){
			return 0;
		}else if(this.age > o.age){
			return 1;
		}else{
			return -1;
		}
	}
}

package com.itcast.bean;

public class PersonFactory {
	
	public static Person Verify(String id){
		Person person=null;
		if (id.equals("T")) {
			person=new Teacher();
		}else if (id.equals("S")) {
			person=new Student();
		}
		return person;
	}
}

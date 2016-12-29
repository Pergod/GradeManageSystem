package com.itcast.bean;

public class Student extends Person{
	
	private int id;
	private String name;
	private double grade;
	private String sex;

	public Student(int id, String name, double grade, String sex) {
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.sex = sex;
	}
	
	public Student() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
}

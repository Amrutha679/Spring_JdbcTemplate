package com.jdbc;

public class Student {

	private int id;
	private String name;
	private int marks;
	
	public Student() {}
	
	public Student(int id,int marks,String name) {
		this.id = id;
		this.name= name;
		this.marks = marks;
	}
	public Student(int id) {
		this.id = id;
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
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
}

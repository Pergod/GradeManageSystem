package com.itcast.data;

import com.itcast.bean.Student;

public interface OperateDao {
	
	public void add(Student student);
	public Student find(String id);
	public Boolean update(Student student);
	public Boolean delete(String id);
}

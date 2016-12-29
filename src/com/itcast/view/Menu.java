package com.itcast.view;

import java.util.Scanner;

import com.itcast.bean.Person;
import com.itcast.bean.PersonFactory;
import com.itcast.bean.Student;
import com.itcast.bean.Teacher;
import com.itcast.data.OperateDaoImp;

public class Menu {

	public static void main(String[] args) {
		System.out.println("****************学生成绩系统****************");
		System.out.print("请输入身份 ( T 代表老师，S代表学生):");
		Scanner in=new Scanner(System.in);
		String id=in.nextLine();
		Person info=PersonFactory.Verify(id);
		if (info instanceof Teacher) {
			System.out.println("欢迎老师");
		}else if (info instanceof Student) {
			System.out.println("学生你好");
		}else {
			System.out.println("无法识别");
		}
		System.out.print("请输入命令行( A代表添加,F 代表查找,U 代表更新,D 代表删除):");
		String cmd=in.nextLine();
		Dowork(cmd);
	}

	private static void Dowork(String cmd) {
		OperateDaoImp operate=new OperateDaoImp();
		Scanner in =new Scanner(System.in);
		Student student=null;
		if (cmd.equals("A")) {
			System.out.println("******** 请输入添加学生的信息 ********");
			System.out.print("请输入添加学生的id:");
			int id=in.nextInt();
			System.out.print("请输入添加学生的姓名:");
			String name=in.next();
			System.out.print("请输入添加学生的性别:");
			String sex=in.next();
			System.out.print("请输入添加学生的成绩:");
			double grade=in.nextDouble();
			student=new Student(id, name, grade, sex);
			operate.add(student);
			System.out.println("添加成功!");
		}else if(cmd.equals("F")){
			System.out.print("请输入查询学生的id:");
			String id=in.next();
			student=operate.find(id);
			if (student!=null) {
				System.out.println(student.getId());
				System.out.println(student.getName());
				System.out.println(student.getSex());
				System.out.println(student.getGrade());
			}
		}else if(cmd.equals("U")){
			System.out.println("请输入需要更新学生的id:");
			String id=in.next();
			student=operate.find(id);
			System.out.print("请输入需要更新学生的姓名:");
			String name=in.next();
			student.setName(name);
			System.out.print("请输入需要更新学生的性别:");
			String sex=in.next();
			student.setSex(sex);
			System.out.print("请输入需要更新学生的成绩:");
			double grade=in.nextDouble();
			student.setGrade(grade);
			Boolean flag=operate.update(student);
			if (flag) {
				System.out.println("更新成功!");
			}else {
				System.out.println("更新失败!");
			}
		}else if(cmd.equals("D")){
			System.out.println("请输入要删除学生的id:");
			String id=in.next();
			Boolean flag=operate.delete(id);
			if (flag) {
				System.out.println("删除成功!");
			}else {
				System.out.println("删除失败!用户不存在");
			}
			
		}else {
			System.out.println("不支持此命令");
		}
	}

}

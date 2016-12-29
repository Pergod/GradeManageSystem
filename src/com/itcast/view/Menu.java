package com.itcast.view;

import java.util.Scanner;

import com.itcast.bean.Person;
import com.itcast.bean.PersonFactory;
import com.itcast.bean.Student;
import com.itcast.bean.Teacher;
import com.itcast.data.OperateDaoImp;

public class Menu {

	public static void main(String[] args) {
		System.out.println("****************ѧ���ɼ�ϵͳ****************");
		System.out.print("��������� ( T ������ʦ��S����ѧ��):");
		Scanner in=new Scanner(System.in);
		String id=in.nextLine();
		Person info=PersonFactory.Verify(id);
		if (info instanceof Teacher) {
			System.out.println("��ӭ��ʦ");
		}else if (info instanceof Student) {
			System.out.println("ѧ�����");
		}else {
			System.out.println("�޷�ʶ��");
		}
		System.out.print("������������( A�������,F �������,U �������,D ����ɾ��):");
		String cmd=in.nextLine();
		Dowork(cmd);
	}

	private static void Dowork(String cmd) {
		OperateDaoImp operate=new OperateDaoImp();
		Scanner in =new Scanner(System.in);
		Student student=null;
		if (cmd.equals("A")) {
			System.out.println("******** ���������ѧ������Ϣ ********");
			System.out.print("���������ѧ����id:");
			int id=in.nextInt();
			System.out.print("���������ѧ��������:");
			String name=in.next();
			System.out.print("���������ѧ�����Ա�:");
			String sex=in.next();
			System.out.print("���������ѧ���ĳɼ�:");
			double grade=in.nextDouble();
			student=new Student(id, name, grade, sex);
			operate.add(student);
			System.out.println("��ӳɹ�!");
		}else if(cmd.equals("F")){
			System.out.print("�������ѯѧ����id:");
			String id=in.next();
			student=operate.find(id);
			if (student!=null) {
				System.out.println(student.getId());
				System.out.println(student.getName());
				System.out.println(student.getSex());
				System.out.println(student.getGrade());
			}
		}else if(cmd.equals("U")){
			System.out.println("��������Ҫ����ѧ����id:");
			String id=in.next();
			student=operate.find(id);
			System.out.print("��������Ҫ����ѧ��������:");
			String name=in.next();
			student.setName(name);
			System.out.print("��������Ҫ����ѧ�����Ա�:");
			String sex=in.next();
			student.setSex(sex);
			System.out.print("��������Ҫ����ѧ���ĳɼ�:");
			double grade=in.nextDouble();
			student.setGrade(grade);
			Boolean flag=operate.update(student);
			if (flag) {
				System.out.println("���³ɹ�!");
			}else {
				System.out.println("����ʧ��!");
			}
		}else if(cmd.equals("D")){
			System.out.println("������Ҫɾ��ѧ����id:");
			String id=in.next();
			Boolean flag=operate.delete(id);
			if (flag) {
				System.out.println("ɾ���ɹ�!");
			}else {
				System.out.println("ɾ��ʧ��!�û�������");
			}
			
		}else {
			System.out.println("��֧�ִ�����");
		}
	}

}

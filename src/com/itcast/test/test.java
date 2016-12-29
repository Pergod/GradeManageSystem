package com.itcast.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.itcast.XMLUtils.XMLUtils;
import com.itcast.bean.Student;
import com.itcast.data.OperateDaoImp;

public class test {
	
	@Test
	public void testAdd() {
		Student student=new Student(23, "江", 89, "男");
		OperateDaoImp dao=new OperateDaoImp();
		dao.add(student);
	}

	@Test
	public void testFind(){
		OperateDaoImp dao=new OperateDaoImp();
		Student student=dao.find("a");
		if (student!=null) {
			System.out.println(student.getId());
			System.out.println(student.getName());
			System.out.println(student.getSex());
			System.out.println(student.getGrade());
		}
	}
	
	@Test
	public void testUpdate(){
		OperateDaoImp dao=new OperateDaoImp();
	}
	
	@Test
	public void testDelete(){
		OperateDaoImp dao=new OperateDaoImp();
		Boolean flag=dao.delete("2");
		if (flag) {
			System.out.println("删除成功!");
		}else {
			System.out.println("删除失败!用户不存在");
		}
	}
	
	@Test
	public void paraseXML() throws FileNotFoundException, ParserConfigurationException, SAXException, IOException{
		Document document=XMLUtils.getDocument();
		Element student=(Element) document.getElementsByTagName("student").item(0);
		System.out.println(student.getAttribute("id"));
		System.out.println(student.getNodeName());
		System.out.println(student.getTextContent());
	}
}

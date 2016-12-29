package com.itcast.data;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.itcast.XMLUtils.XMLUtils;
import com.itcast.bean.Student;

public class OperateDaoImp implements OperateDao{

	/*
	 * 添加
	 */
	@Override
	public void add(Student student) {
		
		try {
			Document document=XMLUtils.getDocument();
			
			Element Stu_TAG=document.createElement("student");
			Element Name_TAG=document.createElement("name");
			Element Grade_TAG=document.createElement("grade");
			Element Sex_TAG=document.createElement("sex");
			
			Stu_TAG.setAttribute("id", student.getId()+"");
			Name_TAG.setTextContent(student.getName());
			Sex_TAG.setTextContent(student.getSex());
			Grade_TAG.setTextContent(""+student.getGrade()+"");
			
			/*
			 * 添加标签关系
			 */
			Stu_TAG.appendChild(Name_TAG);
			Stu_TAG.appendChild(Sex_TAG);
			Stu_TAG.appendChild(Grade_TAG);
			Element exam=(Element) document.getElementsByTagName("Exam").item(0).appendChild(Stu_TAG);
			
			/*
			 * 写出到XML文件中
			 */
			XMLUtils.WriteToXml(document);
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 更新
	 */
	@Override
	public Boolean update(Student student) {
		Document document;
		try {
			document = XMLUtils.getDocument();
			Element exam=(Element) document.getElementsByTagName("Exam").item(0);
			NodeList students_TAG=exam.getElementsByTagName("student");
			for(int i=0;i<students_TAG.getLength();i++){
				Element student_TAG=(Element) students_TAG.item(i);
				if ((student.getId()+"").equals(student_TAG.getAttribute("id"))) {
					student_TAG.getElementsByTagName("name").item(0).setTextContent(student.getName());
					student_TAG.getElementsByTagName("sex").item(0).setTextContent(student.getSex());
					student_TAG.getElementsByTagName("grade").item(0).setTextContent(student.getGrade()+"");
					XMLUtils.WriteToXml(document);
					return true;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * 删除
	 */
	@Override
	public Boolean delete(String id) {
		try {
			Document document=XMLUtils.getDocument();
			Student student=find(id);
			NodeList students=document.getElementsByTagName("student");
			for(int i=0;i<students.getLength();i++){
				Element stu_TAG=(Element) students.item(i);
				if (id.equals(stu_TAG.getAttribute("id"))) {
					stu_TAG.getParentNode().removeChild(stu_TAG);
					XMLUtils.WriteToXml(document);
					return true;
				}
			}
			
		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * 查找
	 */
	@Override
	public Student find(String id) {
		try {
			Document document=XMLUtils.getDocument();
			NodeList students=document.getElementsByTagName("student");
			for(int i=0;i<students.getLength();i++){
				Element student_TAG=(Element) students.item(i);
				if ((""+id).equals(student_TAG.getAttribute("id"))) {
					String name=student_TAG.getElementsByTagName("name").item(0).getTextContent();
					String sex=student_TAG.getElementsByTagName("sex").item(0).getTextContent();
					String grade=student_TAG.getElementsByTagName("grade").item(0).getTextContent();
					Student student =new Student(Integer.valueOf(id), name, Double.valueOf(grade), sex);
					return student;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}

package com.itcast.XMLUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.itcast.constVar.Const;

public class XMLUtils {
	
	/*
	 * 获取Document对象
	 */
	public static Document getDocument() 
			throws ParserConfigurationException, FileNotFoundException, SAXException, IOException {
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		Document document=builder.parse(new FileInputStream(new File(Const.FILE_PATH)));
		return document;
	}
	
	/*
	 * 写出到XML文件中
	 */
	public static void WriteToXml(Document document) 
			throws FileNotFoundException, TransformerException, ParserConfigurationException, SAXException, IOException {
		TransformerFactory factory=TransformerFactory.newInstance();
		Transformer transformer=factory.newTransformer();
		transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream(new File(Const.FILE_PATH))));
	}
}

package org.javachina.xml.parser;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class BasicSaxParser {
	public static void main(String[] args) throws JDOMException, IOException {
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build("./src/basic.xml");
		Element root  =  doc.getRootElement();
		
		List<Element> students = root.getChildren("student");
		
		for (Element student : students) {
			String name = student.getChildText("name");
			if(name.equals("张三")){
				
				root.removeContent(student);
			}
		}
		XMLOutputter output = new XMLOutputter();
		
		output.output(doc, new FileOutputStream("./src/basic.xml"));
	}
}

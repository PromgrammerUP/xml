package org.javachina.xml.parser;

import java.io.IOException;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class StrutsParser {
	public static void main(String[] args) throws JDOMException, IOException {
		SAXBuilder builder = new SAXBuilder();
		
		Document doc = builder.build("./src/struts-config.xml");
		
		Element root = doc.getRootElement();
		
		//取得所有子元素
//		List<Element> allChildren = root.getChildren();
//		
//		for (Element child : allChildren) {
//			String name = child.getName();
//			System.out.println(name);
//		}
		//得到formbeans元素
		
		Element formBeans = root.getChild("form-beans");
		List<Element> formBeansElement = formBeans.getChildren();
		
		//循环：取得每个formbean
		for (Element element : formBeansElement) {
			//取得元素名
			String formBeanName  = element.getName();
			System.out.println("formbean名:"+formBeanName);
			
			//1.取得元素的所有属性
//			List<Attribute> formBeanAttributes = element.getAttributes();
//			for (Attribute attribute : formBeanAttributes) {
//				String name = attribute.getName();
//				String value = attribute.getValue();
//				System.out.println(name+":"+value);
//			}
			
			//2.根据指定属性名取得属性对象
//			Attribute nameAttriubte = element.getAttribute("name");
//			String name = nameAttriubte.getValue();
//			Attribute typeAttribute = element.getAttribute("type");
//			String type = typeAttribute.getValue();
//			System.out.println(name+":"+type);
//			
			//3.根据指定属性名取得属性的值
			
			String name = element.getAttributeValue("name");
			String type = element.getAttributeValue("type");
			System.out.println(name+":"+type);
		}
	}
}

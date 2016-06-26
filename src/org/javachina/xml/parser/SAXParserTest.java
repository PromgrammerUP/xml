package org.javachina.xml.parser;

import java.awt.geom.Ellipse2D;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

public class SAXParserTest {
	
	public void parserBasicXML(String path) throws JDOMException, IOException{
		System.out.println("解析开始……");
		//创建一个SAX解析器
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(path);
		//取得根元素
		Element root = doc.getRootElement();
		
		//取得所有子元素
		List students = root.getChildren("student");
		for(int i=0;i<students.size();i++){
			Element student = (Element)students.get(i);
			//取得student中的name节点
			Element studentName = student.getChild("name");
			//取得name节点中的文本
			String name = studentName.getText();
			System.out.println(name);
			Element studentAge = student.getChild("age");
			String age = studentAge.getText();
			System.out.println(age);
			
			Element studentSex = student.getChild("sex");
			String sex = studentSex.getText();
			System.out.println(sex);
			
			Element subjects = student.getChild("subjects"); 
			List subject = subjects.getChildren("subject");
			for(int j=0; j<subject.size();j++){
				Element subjectStudent = (Element)subject.get(j);
				Element subjectName = subjectStudent.getChild("name");
				String subname = subjectName.getText();
				System.out.println(subname);
				Element subjectScore = subjectStudent.getChild("score");
				String subScore = subjectScore.getText();
				System.out.println(subScore);
			}
			System.out.println("................");
		}
	}

	public void parserBasic2(String path) throws JDOMException, IOException{
		//创建解析器
				SAXBuilder builder = new SAXBuilder();
				
				//文件载入到内存
				Document doc = builder.build(path);
				
				//得到根元素
				Element root = doc.getRootElement();
				
				//得到所有学生
				List<Element> students = root.getChildren("student");
				
				//循环
				for (Element element : students) {
					String name = element.getChildText("name");
					String age = element.getChildText("age");
					String sex = element.getChildText("sex");
					System.out.println(name+":"+age+":"+sex);
					
					//取得所有科目元素
					Element subjects = element.getChild("subjects");
					//取得每一个科目
					List<Element> subject = subjects.getChildren("subject");
					//遍历每一个科目
					for (Element sub : subject) {
						String subjectName = sub.getChildText("name");
						String score = sub.getChildText("score");
						System.out.println("科目名称："+subjectName+"---------成绩："+score);
					}
				}
	}
	public static void main(String[] args) throws JDOMException, IOException {
		//载入xml解析器 ：SAX解析器
		SAXBuilder builder = new SAXBuilder();
		
		//取得document文件
		Document doc = builder.build("./src/person.xml");
		
		//取得根元素
		Element root = doc.getRootElement();
		
		//取得所有种族
		List<Element> races = root.getChildren("race");
		
		for (Element race : races) {
//			List<Attribute> attribute = race.getAttributes();
//			for (Attribute attri : attribute) {
//				String attriName = attri.getName();
//				String attriValue = attri.getValue();
//				System.out.println(attriName+":"+attriValue);
//			}
			//根据属性名取得属性值
			String skin = race.getAttributeValue("skin");
			System.out.println(skin);
			
			//取得所有人
			List<Element> persons = race.getChildren("person");
			
			//遍历所有人
			for (Element person : persons) {
				String id = person.getChildText("id");
				String name = person.getChildText("name");
				String age = person.getChildText("age");
				String sex = person.getChildText("sex");
				System.out.println(id+":"+name+":"+age+":"+sex);
				
				Element favers = person.getChild("favers");
				List<Element> faverList = favers.getChildren();
				for (Element faver : faverList) {
					String fa = faver.getText();
					System.out.println("爱好"+fa);
				}
				System.out.println("***********人口分界************");
			}
			System.out.println("-----------种族分界----------------");
		}
		OutputStream os = null;
		XMLOutputter output = new XMLOutputter();
		try {
			 os = new FileOutputStream("F:/a.xml");
			 output.output(doc, os);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(os!=null){
				os.close();
			}
		}
	}
	

	
}

package FileHandling;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class HandleXMLFile {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		/*To handle xml files, we have seperate built in library in java called java DOM(Document object model) parser
		 In xml terminology, parent node called as root node and inside root node, child nodes(opening and closing of one employee node) will be there. 
		 Inside child nodes, every line called as tags. Every tags contains data */
		
		//DocumentBuilderFactory, Documentbuilder, Document - These classes helps to convert or parse xml into document
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		Document doc=builder.parse(".\\Data\\employee.xml");
		
		//Extract root node
		Element root=doc.getDocumentElement();
		
		//Extract all child nodes
		NodeList nodeList=root.getChildNodes();
		
		//Get each child node(Opening and closing of employee node) from nodelist
		for(int i=0;i<nodeList.getLength();i++) {
			Node childNode=nodeList.item(i);
			if(childNode.getNodeType()==Node.ELEMENT_NODE) {
				//Cast every child node into element
				Element element=(Element)childNode;
				String tagName=element.getTagName();  //O/P: employee
				String text=element.getTextContent(); //O/P: 101 John Canedy engineer 80000
				System.out.println(tagName+" is and text for this tagname is "+text);
			}
			
		}
		
	}

}

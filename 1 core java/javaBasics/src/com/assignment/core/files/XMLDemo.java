package com.assignment.core.files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLDemo {
	static Logger log = LogManager.getLogger(XMLDemo.class.getName());

    public static void main(String[] args) {
		log.info("---------------------------------------------------------");
    	String filePath = "books.xml";
    	
//    	Create File
        try {
//          Create a DocumentBuilder and a new Document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

//          Create root element: bookstore
            Element rootElement = doc.createElement("bookstore");
            doc.appendChild(rootElement);

//          Create book elements
            Element book1 = doc.createElement("book");
            rootElement.appendChild(book1);
            book1.setAttribute("category", "COOKING");
            Element title1 = doc.createElement("title");
            title1.setAttribute("lang", "en");
            title1.appendChild(doc.createTextNode("Everyday Italian"));
            book1.appendChild(title1);
            Element author1 = doc.createElement("author");
            author1.appendChild(doc.createTextNode("Giada De Laurentiis"));
            book1.appendChild(author1);
            Element year1 = doc.createElement("year");
            year1.appendChild(doc.createTextNode("2005"));
            book1.appendChild(year1);
            Element price1 = doc.createElement("price");
            price1.appendChild(doc.createTextNode("30.00"));
            book1.appendChild(price1);

            Element book2 = doc.createElement("book");
            rootElement.appendChild(book2);
            book2.setAttribute("category", "CHILDREN");
            Element title2 = doc.createElement("title");
            title2.setAttribute("lang", "en");
            title2.appendChild(doc.createTextNode("Harry Potter"));
            book2.appendChild(title2);
            Element author2 = doc.createElement("author");
            author2.appendChild(doc.createTextNode("J K. Rowling"));
            book2.appendChild(author2);
            Element year2 = doc.createElement("year");
            year2.appendChild(doc.createTextNode("2005"));
            book2.appendChild(year2);
            Element price2 = doc.createElement("price");
            price2.appendChild(doc.createTextNode("29.99"));
            book2.appendChild(price2);

//          Create File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

            log.info("XML File Created Successfully.");

        } catch (ParserConfigurationException | TransformerException e) {
            log.error(e.getMessage());
        }
        
//        Update File
        try {
    		log.info("Updating the XML File Created.");
//          Get XML file data
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

//          Iterate over XML book elements to find 'Everyday Italian'
            NodeList bookList = doc.getElementsByTagName("book");
            for (int i = 0; i < bookList.getLength(); i++) {
                Element book = (Element) bookList.item(i);
                String title = book.getElementsByTagName("title").item(0).getTextContent();
//              Update the year attribute and set lang attribute to title element
                if ("Everyday Italian".equals(title)) {
                    Element year = (Element) book.getElementsByTagName("year").item(0);
                    year.setTextContent("2020");

                    Element titleElement = (Element) book.getElementsByTagName("title").item(0);
                    titleElement.setAttribute("lang", "it");
                }
            }

//          Save (Write) changes to XML Document to the file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        
//      Read XML File
        try {
    		log.info("Reading the XML File Created.");
//          Load the XML file
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

//          Root element
            log.info("Root element: " + doc.getDocumentElement().getNodeName());
            log.info("");

//          Iterate over all book elements
            NodeList bookList = doc.getElementsByTagName("book");
            for (int i = 0; i < bookList.getLength(); i++) {
                Node bookNode = bookList.item(i);
                if (bookNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element bookElement = (Element) bookNode;
                    log.info("Book " + (i + 1) + ":");
                    log.info("Category: " + bookElement.getAttribute("category"));
                    Element titleElement = (Element) bookElement.getElementsByTagName("title").item(0);
                    String lang = titleElement.getAttribute("lang");
                    log.info("Title: " + titleElement.getTextContent());
                    log.info("Language: " + lang);
                    log.info("Author: " + bookElement.getElementsByTagName("author").item(0).getTextContent());
                    log.info("Year: " + bookElement.getElementsByTagName("year").item(0).getTextContent());
                    log.info("Price: " + bookElement.getElementsByTagName("price").item(0).getTextContent());
                    log.info("");
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}

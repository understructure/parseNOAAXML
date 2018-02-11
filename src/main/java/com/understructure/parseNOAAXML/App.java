package com.understructure.parseNOAAXML;

import com.understructure.parseNOAAXML.Event;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

//import com.rometools.rome.feed.synd.SyndFeed;
//import com.rometools.rome.io.SyndFeedInput;
//import com.rometools.rome.io.XmlReader;
//import java.io.*;
//import java.util.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import org.jdom2.*;
//import org.jdom2.input.SAXBuilder;

/**
 * https://rometools.github.io/rome/RssAndAtOMUtilitiEsROMEV0.5AndAboveTutorialsAndArticles/RssAndAtOMUtilitiEsROMEV0.5TutorialUsingROMEToReadASyndicationFeed.html
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParserConfigurationException, SAXException, IOException
    {
    		String url = "https://alerts.weather.gov/cap/va.php?x=0";
    		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = (Document) dBuilder.parse(url);
        doc.getDocumentElement().normalize();
    		//Element classElement = document.getRootElement();
    		//NodeList nodeList = doc.getElementsByTagName("id");
        NodeList nodeList = doc.getElementsByTagName("entry");
        ArrayList<Event> arrayEvents = new ArrayList<Event>();
        
    		for (int i = 0; i < nodeList.getLength(); i++) {
    			Event event = new Event();
    			Node node = nodeList.item(i);
    			// System.out.println("Current node: " + node.getNodeName().toString());
    			NodeList kids = node.getChildNodes();
    			for(int k = 0; k < kids.getLength(); k++) {
    				Node n2 = kids.item(k);
    				String nodeName = n2.getNodeName().toString();
    				// System.out.println(nodeName);
    				String eventKey = event.checkMap(nodeName);
    				if (eventKey != null && !eventKey.isEmpty()) {
    					String eventValue = n2.getTextContent().toString();
    					// System.out.println("Node name is " + nodeName + " - event key is " + eventKey);
    					System.out.println(eventKey + " : " + eventValue);
    					// System.out.println(n2.getNodeValue().toString());
    					event.setValue(eventKey, eventValue);
    				}
    			}
    			arrayEvents.add(event);
    			System.out.println("-------------------------------------------------");
    		}
    		
    		System.out.println("Array of " + arrayEvents.size() + " events looks like this: " + arrayEvents.toString());
    		//System.out.println(classElement.toString());
    		
    		try {
				URL o_url = new URL(url);
				System.out.println( "Hello " + o_url.toString());
				
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
    }
}

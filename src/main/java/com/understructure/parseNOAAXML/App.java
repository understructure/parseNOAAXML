package com.understructure.parseNOAAXML;

import com.understructure.parseNOAAXML.Event;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	private static void doMainProgram(NodeList nodeList, Logger logger) {
        if (nodeList.getLength() == 1 && nodeList.item(0).getTextContent().contains("There are no active watches, warnings or advisories")) {
    		System.out.println("Nothing to report, aborting");
    } else {
        System.out.println("Found a total of " + nodeList.getLength() + " events");
        ArrayList<Event> arrayEvents = new ArrayList<Event>();
    		for (int i = 0; i < nodeList.getLength(); i++) {
    			Event event = new Event();
    			Node node = nodeList.item(i);
    			// System.out.println("Current node: " + node.getNodeName().toString());
    			NodeList kids = node.getChildNodes();
   
    			
    			for(int k = 0; k < kids.getLength(); k++) {
    				Node n2 = kids.item(k);
    				String nodeName = n2.getNodeName().toString();
    				String eventKey = event.checkMap(nodeName);
    				if (eventKey != null && !eventKey.isEmpty()) {
    					String eventValue = n2.getTextContent().toString();
					System.out.println(eventKey + " : " + eventValue);
					event.setValue(eventKey, eventValue);
					//event.setValue(eventKey, eventValue);
    				}
    			}
    			arrayEvents.add(event);
    			System.out.println("-------------------------------------------------");
    		}
    		
    		System.out.println("Array contains a total of " + arrayEvents.size() + " events");
    		//System.out.println(classElement.toString());
    		logger.log(Level.INFO, "Weather Alert Load Complete");
      }
	}
	
    public static void main( String[] args ) throws ParserConfigurationException, SAXException, IOException
    {
     
        
        
        
		try {
			// this will be a parameter eventually?
			String url = "https://alerts.weather.gov/cap/va.php?x=0";
			URL o_url = new URL(url);
			System.out.println( "Hello " + o_url.toString());
			
	    		Logger logger = Logger.getLogger(App.class.getName());
	    		logger.log(Level.INFO, "Starting Weather Alert Load");
	    		
	    	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = (Document) dBuilder.parse(url);
	        doc.getDocumentElement().normalize();

	        NodeList nodeList = doc.getElementsByTagName("entry");
	        doMainProgram(nodeList, logger);
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}

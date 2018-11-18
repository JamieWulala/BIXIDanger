package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import java.util.*;



import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.xml.sax.SAXException;



public class Main {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated constructor stub
		String hotspotFilename = "./data_sets/cluster_means.txt";
		String routesFilename = "./data_sets/routes_final.txt";
		String[] userFilename = {"./data_sets/users/jamie.txt","./data_sets/users/lisa.txt","./data_sets/users/thomas.txt","./data_sets/users/saad.txt"};
		String[] userName = {"jamie","lisa","thomas","saad"};
		Manager manager = new Manager();
		
		
		try {
			//add hotspot
				System.out.println("reading collision spots data.....");
				readHotspotFile(hotspotFilename, manager);
				progressBar(2*4);
				
				//add routes!
				System.out.println("reading all bike routes data.....");
				readRouteFile(routesFilename, manager);
				progressBar(4*4);
			//add users
			for (int i = 0; i < 4; i++) {
				System.out.println("reading user: "+userName[i]+" route data.....");
				progressBar(1);
				readUserFile(userFilename[i], manager, userName[i]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("calculating user's danger profiles.....");
		progressBar(1);
		for(User u1 :manager.getUsers()) {
			System.out.println("Name: "+u1.getName()+" ----> DangerIndex: "+manager.showUserIndex(u1));
		}System.out.println();
		System.out.print("User: thomas is the terrorist!");
		
		
	}	
	public static void progressBar (long speed) {
		System.out.println("");
		System.out.print("|");
		speed *= 10; 
		for(int i = 0; i < 50 ; i++) {
			
				System.out.print("-");
			
			try {
				TimeUnit.MILLISECONDS.sleep(speed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("|100%");
		System.out.println("");
		
		
	}	
	public static Route findRoutebyName (String name, Manager manager) { //return null if didn't find one
		for(Route r: manager.getRoutes()) {
			
			if(r.getName().equals(name)) {
				return r;
			}
		}
		return null;
	}
	
	public static void readUserFile (String filename, Manager manager, String name) throws IOException {
		FileInputStream fstream = new FileInputStream(filename);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		
		User u = new User(name);
		
		while ((strLine = br.readLine()) != null)   {
			 //find the route by name
			 //if find -> duplicate the route and add to user
			 //if not -> proceed to next one
			
			  if(findRoutebyName(strLine, manager)!= null) {
				  // System.out.println("here");
				  Route newroute = findRoutebyName(strLine, manager);
				  u.addRoute(newroute);
			  }
		}
		manager.addUser(u);
		
		br.close();
	} 
	
	public static Hotspot createHotspot (String str) {
		String s1 = str.substring( 0, str.indexOf(","));
		str = str.substring(str.indexOf(",")+1, str.length());   
		String s2 = str.substring( 0, str.indexOf(","));
		
		String s3 = str.substring(str.indexOf(",")+1);
		
		//System.out.println("s1: "+s1+" s2: "+s2+" s3: "+s3);
		
		double longtitude = Double.parseDouble(s1);
		double latitude = Double.parseDouble(s2);
		double weight = Double.parseDouble(s3);
		Hotspot hs = new Hotspot(longtitude, latitude, weight);
		return hs;
	}
	
	public static Route createRoute (String str) {
		// ex: 0987to1222 [[1232132,1232213],[123213,123213],[21322132,213432]]
		Route route = new Route(new User("unknown"));
	
		route.setName(str.substring(0,10));
		int curIndex = 12;
		//System.out.println(route.getName()+" ");
		while (str.length()> 2) {
			str = str.substring(curIndex);
			//System.out.println(" current subtring: "+str+" End");
			curIndex = str.indexOf(",");
			double X = Double.parseDouble(str.substring(1,str.indexOf(",")));
			str = str.substring(curIndex+2);
			//System.out.println(" current subtring: "+str+" End");
			curIndex = (str.indexOf("]"));
			double Y = Double.parseDouble(str.substring(0,str.indexOf("]")));
			str = str.substring(curIndex+2);
			//System.out.println(X+" "+Y);
			Position p = new Position(X, Y);
			route.addPosition(p);
			curIndex = 1;
		}
		
		return route;
		
	}
	
	public static void readRouteFile (String filename, Manager manager) throws IOException {
		FileInputStream fstream = new FileInputStream(filename);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		
		while ((strLine = br.readLine()) != null)   {
			  // Print the content on the console
			  Route r = createRoute(strLine);
			  manager.addRoute(r);
		}
		
		br.close();
	}
	
	public static void readHotspotFile (String filename, Manager manager) throws IOException {
		FileInputStream fstream = new FileInputStream(filename);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		
		while ((strLine = br.readLine()) != null)   {
			  // Print the content on the console
			  Hotspot hs = createHotspot(strLine);
			  manager.addHotspot(hs);
		}
		
		br.close();
	}
	
	public static boolean writeXML(Manager manger, String fileName) throws IOException {
		Document doc = new Document();
		
		Element root = new Element("Manager");
		doc.setRootElement(root);
		
		
		Element route = new Element("route");
		
		for (User u: manger.getUsers()) {
			Element user = new Element("user");
			user.addContent(new Element("name").setText(""+u.getName()));
			doc.getRootElement().addContent(user);
		}
		
		for (Hotspot h: manger.getHotspots()) {
			Element hotspot = new Element("hotspot");
			hotspot.addContent(new Element("longtitude").setText(""+h.getLongtitude()));
			hotspot.addContent(new Element("latitude").setText(""+h.getLatitude()));
			hotspot.addContent(new Element("weight").setText(""+h.getWeight()));
			doc.getRootElement().addContent(hotspot);
		}
		//System.out.print("haha");
		XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
		xmlOutputter.output(doc, new FileOutputStream(fileName+".xml"));
		
		return true;
	}
	
	public static Manager readXML (String fileName) throws Exception {
		Manager m = new Manager();
		final String path = "./"+fileName+".xml";		
		//System.out.println("File path: " + path);
		
		SAXBuilder builder = new SAXBuilder();
		
		Document readDoc = builder.build(new File(path));
		Element root = readDoc.getRootElement();
		List<Element> users = root.getChildren("user");
		List<Element> hotspots = root.getChildren("hotspot");
		for(Element e : users) {
			User user = new User(e.getChildText("name"));
			m.addUser(user);
			
		}
		for(Element e : hotspots) {
			//System.out.println("Longtitude: " + e.getChildText("longtitude"));
			double longtitude = Double.valueOf(e.getChildText("longtitude"));
			double latitude =  Double.valueOf(e.getChildText("latitude"));
			double weight =  Double.valueOf(e.getChildText("weight"));
			Hotspot h = new Hotspot(longtitude, latitude, weight);
			m.addHotspot(h);
		}
		
		return m;
	}
}

package FileHandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class HandlingPropertyFile {
     
	public static void writeIntoPropertyFile() throws IOException {
		Properties pro=new Properties();
		pro.setProperty("key1","val1");
		pro.setProperty("key2","val2");
		pro.setProperty("key3","val3");
		pro.setProperty("key4","val4");
		String val=System.getProperty("user.dir")+"\\PropertiesFile\\Test.properties";
		FileOutputStream out=new FileOutputStream(val);
		pro.store(out, "Property file added"); //This comment will get added in property file
		out.close();
	}
	
	public static void readPropertyFile() throws IOException {
		Properties pro=new Properties();
		String val=System.getProperty("user.dir")+"\\PropertiesFile\\Test.properties";
		FileInputStream out=new FileInputStream(val);
		pro.load(out);
		System.out.println(pro.get("val3"));
		out.close();
		
		//capture all properties - Approach 1
		Set<String> keys=pro.stringPropertyNames();
		System.out.println(keys); //O/P: [key1, key2, key3, key4]
		
		//Read all the properties and their values
		for(String key:pro.stringPropertyNames()) {
			System.out.println(key+" "+pro.getProperty(key));
		}
		
		//capture all properties - Approach 2
		Set<Object> allKeys=pro.keySet();
		System.out.println(allKeys); //O/P: [key1, key2, key3, key4]
		
		Iterator i = allKeys.iterator();
		while(i.hasNext()) {
			System.out.print(i.next()+" "); //O/P: key1 key2 key3 key4
		}
		System.out.println();
		
		//capture all the values
		Collection<Object> values=pro.values();
		System.out.println(values); //O/p: [val1, val2, val3, val4]
	}
	
	
	public static void main(String[] args) throws IOException {
		writeIntoPropertyFile();
		readPropertyFile();
	}

}

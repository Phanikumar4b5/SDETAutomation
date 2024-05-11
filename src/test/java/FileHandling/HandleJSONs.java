package FileHandling;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class HandleJSONs {
	
	
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException, ParseException {
		//Approach 1 - using Jackson library - Read the JSON data from the file and map to Person class
		System.out.println("Read data from JSON using Jackson library");
		ObjectMapper objectmapper=new ObjectMapper();
		File file=new File(".\\Data\\employee.json");
		Person jsonData=objectmapper.readValue(file, Person.class);
		//Access Data
		System.out.println(jsonData); //Make sure you are overriding toString method in both address and person classes then only you will get output like O/P: John kennedy [TL Delhi abc, TL Vijayawada xxx]
		System.out.println(jsonData.getFirstName()); //John
		System.out.println(jsonData.getLastName()); //kennedy
		System.out.println(jsonData.getAddress().get(0).getCity()); //Delhi
		for(Address add1:jsonData.getAddress()) {
			System.out.println(add1.getCity()+" "+add1.getState()+" "+add1.getStreet()); //O/P: Delhi TL abc, Vijayawada TL xxx
		}
		
		//Approach 2 - Using gson library
		System.out.println();
		System.out.println("Read data from JSON using GSON library");
		FileReader reader=new FileReader(".\\Data\\employee.json");
		Gson gson=new Gson();
		Person gsonData=gson.fromJson(reader, Person.class);
		//Access Data
		System.out.println(gsonData); //Make sure you are overriding toString method in both address and person classes then only you will get output like O/P: John kennedy [TL Delhi abc, TL Vijayawada xxx]
		System.out.println(gsonData.getFirstName()); //John
		System.out.println(gsonData.getLastName()); //kennedy
		System.out.println(gsonData.getAddress().get(0).getCity()); //Delhi
		for(Address add1:gsonData.getAddress()) {
			System.out.println(add1.getCity()+" "+add1.getState()+" "+add1.getStreet()); //O/P: Delhi TL abc, Vijayawada TL xxx
		}
		
		//Approach 3 - Using JSON-Simple library
		System.out.println();
		System.out.println("Read data from JSON using JSON-Simple library");
		FileReader reader1=new FileReader(".\\Data\\employee.json");
		JSONParser parser=new JSONParser();
		//Parse method will convert JSON file to Java object
		Object obj=parser.parse(reader1);
		//Convert java object into JSON object by tycasting java object into JSON object
		JSONObject jsonObj=(JSONObject)obj;
		String fname=(String) jsonObj.get("firstName"); //get method returns obj. So we are typecasting obj to string
		String lname=(String) jsonObj.get("lastName");
		System.out.println(fname+" "+lname);
		//Address is an array which contains 2 objects. So get the count of array and get each object value.
		//For handling address we need to use JSON Array and for JSON objects inside array need to use JSONObject
		JSONArray addressArray=(JSONArray)jsonObj.get("address");
		for(int i=0;i<addressArray.size();i++) {
			JSONObject address=(JSONObject) addressArray.get(i);
			System.out.println("Street "+address.get("street"));
			System.out.println("City "+address.get("city"));
			System.out.println("State "+address.get("state"));
		}
	}

}

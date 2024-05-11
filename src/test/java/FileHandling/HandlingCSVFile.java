package FileHandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

import com.opencsv.CSVReader;

public class HandlingCSVFile {

	public static void writeIntoCSVFile() throws IOException {
		FileWriter writer=new FileWriter(System.getProperty("user.dir")+"\\Data\\example.csv");
		
		//Approach 1
		writer.write("Name,age,email \n");
		writer.write("phani1,25,phani@gmail.com \n");
		writer.write("phani2,26,phani1@gmail.com \n");
		writer.write("phani3,27,phani2@gmail.com \n");
		writer.close();
		System.out.println("Wrote data into csv file using write method");
		
		//Approach 2
		FileWriter writer2=new FileWriter(System.getProperty("user.dir")+"\\Data\\example1.csv");
		writer2.append("Name,age,email \n");
		writer2.append("phani1,25,phani@gmail.com \n");
		writer2.append("phani2,26,phani1@gmail.com \n");
		writer2.append("phani3,27,phani2@gmail.com \n");
		writer2.close();
		System.out.println("Wrote data into csv file using append method");
	}
	
	public static void readFile() throws IOException {
		// Approach 1 - Scanner class
		File file=new File(System.getProperty("user.dir")+"\\Data\\example1.csv");
		Scanner sc=new Scanner(file);
		sc.useDelimiter(","); //CSV files all the data seperated with comma. If it is seperated by any other special characters use those inside delimeter
		while(sc.hasNext()) {
			System.out.print(sc.next()+"\t");
		}
		sc.close();
		
		// Approach 2 - Using java split method
		FileReader reader=new FileReader((System.getProperty("user.dir")+"\\Data\\example1.csv"));
		//To read data line by line we need to use bufferedreader
		BufferedReader buffer=new BufferedReader(reader);
		String line;
		int rowCount=0;
		while((line=buffer.readLine())!=null) {
			String[] lines=line.split(",");
			rowCount++;
			for(String word:lines) {
				System.out.print(word+"\t");
			}
			System.out.println();
		}
		buffer.close();
		reader.close();
		
		// Approach 3 - Using CSVReader class
		FileReader reader1=new FileReader((System.getProperty("user.dir")+"\\Data\\example.csv"));
		CSVReader csv=new CSVReader(reader1);
		Iterator<String[]> it=csv.iterator(); 
		int colCount=it.next().length;
		Object[][] obj=new Object[rowCount][colCount];
		int j=0;
		//If you want to remove below 2 lines, then reduce 1 number from rowcount and colcount in for loop condition otherwise it will fail in inside for loop with null error
		//The below 2 lines will start from 1st row which is heading section
		csv=new CSVReader(new FileReader((System.getProperty("user.dir")+"\\Data\\example.csv")));
		it=csv.iterator(); 
		for(int i=0;i<rowCount && j<colCount;i++) {
			String[] row=it.next();
			for(String val:row) {
				obj[i][j]=val;
				System.out.print(obj[i][j]+"\t");
				j++;
			}
			j=0;
			System.out.println();
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		writeIntoCSVFile();
		readFile();

	}

}

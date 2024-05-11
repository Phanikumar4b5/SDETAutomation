package FileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileActions {

	// CreateNewFile - WIll create file if there is no file exists with the same name in the folder
	public static void createFile(String filePath) {
		File myObj = new File(filePath);
		try {
			if (myObj.createNewFile()) {
				System.out.println(
						"File created " + myObj.getName() + " get parent name of this file " + myObj.getParent());
				// O/P: File created myfile.txt get parent name of this file
				// D:\Study_Documents\folder
			} else {
				System.out.println("File already exists");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeFile(String filePath) {
		// We can write in files using fileOutputStream, Stringwrite, fileWriter etc
		try {
			FileWriter mywrite = new FileWriter(filePath);
			mywrite.write("Write in file");
			mywrite.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void readFile(String filePath) {
		// Approach 1
		try {
			FileReader reader = new FileReader(filePath);
			int i;
			while ((i = reader.read()) != -1) {
				System.out.print((char) i);
			}
			reader.close();  //Close the file otherwise actions like rename, delete won't happen because file is in opened state
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Approach 2
		try {
			FileReader reader = new FileReader(filePath);
			Scanner myObj = new Scanner(reader);
			while(myObj.hasNextLine()) {
				String data=myObj.nextLine();
				System.out.print(data);
			}
			myObj.close(); //Close the file otherwise actions like rename, delete won't happen because file is in opened state
			System.out.println();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	// RenameFile - WIll rename file only if there is no file exists with the same name in the folder
	public static void renameFile(String oldPath, String newFilePath) {
		File oldFile=new File(oldPath);
		File newFile=new File(newFilePath);
		if(oldFile.renameTo(newFile)) {
			System.out.println("File has been renamed");
		}
		else {
			System.out.println("File cannot be renamed");
		}
	}
	
	public static void deleteFile(String filePath) {
		File myObj=new File(filePath);
		if(myObj.delete()) {
			System.out.println("Deleted the file "+myObj.getName());
		}
		else {
			System.out.println("Failed to delete the file");
		}
	}

	public static void main(String[] args) {
		createFile("D:\\Study_Documents\\folder\\myfile2.txt");
		writeFile("D:\\Study_Documents\\folder\\myfile2.txt");
		readFile("D:\\Study_Documents\\folder\\myfile2.txt");
		renameFile("D:\\Study_Documents\\folder\\myfile2.txt", "D:\\Study_Documents\\folder\\myfile1.txt");
		deleteFile("D:\\Study_Documents\\folder\\myfile1.txt");
	}

}

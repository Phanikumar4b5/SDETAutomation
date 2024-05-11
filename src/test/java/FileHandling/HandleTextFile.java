package FileHandling;

import java.io.File;

public class HandleTextFile {
	
	//Create Folder - Will pass path where we want to create folder. If already exists, execution goes to else block
	public static void createFolder(String folderPath) {
		File folder=new File(folderPath);
		//boolean val=(folder.exists())?folder.delete():folder.mkdir();
		if(!folder.exists()) {
			folder.mkdir();
			System.out.println("folder created");
		}else {
			System.out.println("Folder already exists");
		}
	}
	
	public static void renameFolder(String oldPath, String newPath) {
		File oldFolder=new File(oldPath);
		File newFolder=new File(newPath);
		if(oldFolder.exists()) {
			oldFolder.renameTo(newFolder);
			System.out.println(oldPath+" renamed to "+newPath);
		}
	}
	
	//This code will exeucte if the folder is empty. If it contains files it won't execute
	public static void deleteFolder(String folderPath) {
		File folder=new File(folderPath);
		if(folder.exists()) {
			folder.delete();
			System.out.println("folder deleted"); 
		}else {
			System.out.println("Folder already deleted");
		}
	}
	
	//This code delete all the files available in the main folder and then delete the main folder
	public static void deleteFilesThenFolder(String folderPath) {
		File folder=new File(folderPath);
		if(folder.exists()) {
			System.out.println("Total files in "+folder.listFiles().length); 
			for(File a:folder.listFiles()) {
				a.delete();
			}
			//folder.delete();
			System.out.println("Total files in "+folder.listFiles().length); 
		}else {
			System.out.println("Folder already deleted");
		}
	}
	
	public static void main(String[] args) {
		//createFolder("D:\\Study_Documents\\Fol"); //Fol folder is not available in resumes folder. First time it will create in if block, 2nd time else block will execute
		renameFolder("D:\\Study_Documents\\fol","D:\\Study_Documents\\folder");
		deleteFilesThenFolder("D:\\Study_Documents\\folder");
		deleteFolder("D:\\Study_Documents\\folder");
		//int a=10,b=20;
		//int c=(a>b)?a:b;
	}

}

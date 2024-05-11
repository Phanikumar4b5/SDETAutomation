package FileHandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyFile {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		File file=new File("C:\\Users\\Phani Kumar\\Downloads\\Vishnubhotla S K C SPhani Kumar_ApplicationForm.pdf");
		File optFile =new File("C:\\Users\\Phani Kumar\\Downloads\\NewDocument.pdf");
		FileInputStream inputStream=null;
		FileOutputStream outputStream = null;
		inputStream=new FileInputStream(file);
		System.out.println(inputStream.available());
		outputStream=new FileOutputStream(optFile);
		int i=0;
		while((i=inputStream.read())!=-1) {
			outputStream.write(i);
		}
		outputStream.close();
		inputStream.close();
		
		
	}

}

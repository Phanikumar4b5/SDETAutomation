package FileHandling;

import java.io.File;
import java.io.IOException;

//import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;

public class HandlePDF {
	public static void readDataFromPDFFile() throws IOException {
		File file = new File(".\\Data\\Get_Started_With_Smallpdf.pdf");

		// load PDF file
		PDDocument doc=PDDocument.load(file); //This load method available only in 2.x pdf library
		//PDDocument doc = Loader.loadPDF(file); // This load method available from in 3.x pdf library
		PDFTextStripper pdfExtract = new PDFTextStripper();
		String text = pdfExtract.getText(doc);
		doc.close();
		System.out.println(text);
	}
	
	public static void writeDataInPDFFile() throws IOException {
		//Create a new PDF document
		PDDocument doc=new PDDocument();
		//Create a new page
		PDPage page=new PDPage(PDRectangle.A4);
		//Create content stream - With this we can create content in pdf file
		doc.addPage(page);
		PDPageContentStream contentStream=new PDPageContentStream(doc,page);
		//Font & Size
		contentStream.setFont(PDType1Font.COURIER,14); //2.x
		//contentStream.setFont(new PDType1Font(standard14Fonts.FontName.COURIER),14); //From 3.x
		contentStream.beginText();
		//From where you wnat to write text like from starting or from middle
		contentStream.newLineAtOffset(50, 700);
		//Write text
		contentStream.showText("Write into PDF file");
		contentStream.endText();
		contentStream.close();
		doc.save(".\\Data\\newexample.pdf");
		doc.close();
		System.out.println("PDF file created successfully");
	}

	public static void main(String[] args) throws IOException {
		readDataFromPDFFile();
		writeDataInPDFFile();
	}

}

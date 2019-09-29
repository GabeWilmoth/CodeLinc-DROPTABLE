/*
 * PDFGeneration.java
 * 
 * Gabriel Wilmoth
 * 
 */

package PDFHandler;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;

import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.BreakClear;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.LineSpacingRule;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TextAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.VerticalAlign;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class PDFGeneration {
	
	/*public static Object resumeBuilder() {
		
		return "";
	}*/

	public static void main(String[] args) throws FileNotFoundException, IOException {
		XWPFDocument doc = new XWPFDocument();

			XWPFParagraph p1 = doc.createParagraph();
			p1.setAlignment(ParagraphAlignment.CENTER);

			p1.setVerticalAlignment(TextAlignment.TOP);

			XWPFRun r1 = p1.createRun();
			r1.setBold(true);
			r1.setFontSize(24);
			r1.setText("John Doe");
			r1.setBold(true);
			r1.setFontFamily("Times New Roman");						
			
			XWPFRun run2 = p1.createRun();
			run2.addBreak();
			run2.setFontSize(12);
			run2.setText("Phone #" + "|");
			run2.setText("Address" + "|");
			run2.setText("gawilmot@unch.edu");
			run2.setFontFamily("Times New Roman");
			p1.setBorderBottom(Borders.BASIC_BLACK_DASHES);

			XWPFParagraph p2 = doc.createParagraph();
			p2.setAlignment(ParagraphAlignment.CENTER);
			
			XWPFRun r2 = p2.createRun();			
			r2.setText("Experience");
			r2.setFontSize(20);
			r2.setFontFamily("Times New Roman");
			p2.setBorderBottom(Borders.BASIC_BLACK_DASHES);

			XWPFParagraph par3 = doc.createParagraph();
			par3.setAlignment(ParagraphAlignment.LEFT);
			
			XWPFRun r3 = par3.createRun();
			r3.setText("Company/Branch");;
			r3.setFontSize(12);
			r3.setText("             							             ");
			r3.setText("Year Span");
			r3.addBreak();
			r3.setText("Job Title");			
			
			String [] fruits = {"Apple", "Banana", "mango", "guava", "pear", "mellon" };
	        // for each item a paragraph is created and the Style and NumId is set
	        for (int i = 0; i < fruits.length; i++) {
	          
	            XWPFParagraph p = doc.createParagraph();	            
	            p.setStyle("ListParagraph");
	            // 2 prints bullet as of this code and 1 would print numbers
	            p.setNumID(BigInteger.valueOf(2));
	            // good to see the XML structure
	            System.out.println(p.getCTP());
	        	  XWPFRun r = p.createRun();
	        	  r.setText(fruits[i]);
	        }       

	        XWPFParagraph par4 = doc.createParagraph();
	        par4.setAlignment(ParagraphAlignment.CENTER);
	        XWPFRun r4 = par4.createRun();
	        
	        r4.setText("Education");
	        r4.setFontSize(20);
			r4.setFontFamily("Times New Roman");
			par4.setBorderBottom(Borders.BASIC_BLACK_DASHES);
	        
			XWPFParagraph par5 = doc.createParagraph();
	        par5.setAlignment(ParagraphAlignment.LEFT);
	        XWPFRun r5 = par5.createRun();
	        
	        r5.setText("School");
			r5.setFontSize(12);
			r5.setText("             								                            ");
			r5.setText("Grad Year");
			r5.addBreak();
			r5.setText("Degree");
			
			XWPFParagraph par6 = doc.createParagraph();
	        par6.setAlignment(ParagraphAlignment.CENTER);
	        XWPFRun r6 = par6.createRun();
	        
	        r6.setText("Skills");
	        r6.setFontSize(20);
			r6.setFontFamily("Times New Roman");
			par6.setBorderBottom(Borders.BASIC_BLACK_DASHES);
	        
	        String [] fruits2 = {"Apple", "Banana", "mango", "guava", "pear", "mellon" };
	        // for each item a paragraph is created and the Style and NumId is set
	        for (int i = 0; i < fruits2.length; i++) {
	          
	            XWPFParagraph par7 = doc.createParagraph();	   
	            par7.setAlignment(ParagraphAlignment.LEFT);		        
	            par7.setStyle("ListParagraph");
	            // 2 prints bullet as of this code and 1 would print numbers
	            par7.setNumID(BigInteger.valueOf(2));
	            // good to see the XML structure
	            System.out.println(par7.getCTP());
	            
	        	  XWPFRun r7 = par7.createRun();
	        	  r7.setText(fruits2[i]);
	        }     
			try (FileOutputStream out = new FileOutputStream("simple1.docx")) {
				doc.write(out);
			}
		}
	}
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
			//r1.setTextPosition(100);
			
			
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
			
			
			XWPFRun run2 = p1.createRun();
			run2.addBreak();
			run2.setFontSize(12);
			run2.setText("dfkjasdfbakjsfbnajkfbjksdbjklsa dfhasdklfnasdklfn hafklnam vkanvam lhfalknfs");
			run2.setFontFamily("Times New Roman");

			XWPFParagraph p2 = doc.createParagraph();
			p2.setAlignment(ParagraphAlignment.RIGHT);

			XWPFRun r2 = p2.createRun();
			r2.setText("jumped over the lazy dog");
			r2.setStrike(true);
			r2.setFontSize(20);

			XWPFRun r3 = p2.createRun();
			r3.setText("and went away");
			r3.setStrike(true);
			r3.setFontSize(20);
			r3.setSubscript(VerticalAlign.SUPERSCRIPT);

			XWPFParagraph p3 = doc.createParagraph();
			p3.setWordWrap(true);
			p3.setPageBreak(true);

			// p3.setAlignment(ParagraphAlignment.DISTRIBUTE);
			p3.setAlignment(ParagraphAlignment.BOTH);
			// p3.setSpacingBetween(15, LineSpacingRule.EXACT);

			p3.setIndentationFirstLine(600);

			XWPFRun r4 = p3.createRun();
			r4.setTextPosition(20);
			r4.setText("To be, or not to be: that is the question: " + "Whether 'tis nobler in the mind to suffer "
					+ "The slings and arrows of outrageous fortune, " + "Or to take arms against a sea of troubles, "
					+ "And by opposing end them? To die: to sleep; ");
			r4.addBreak(BreakType.PAGE);
			r4.setText("No more; and by a sleep to say we end " + "The heart-ache and the thousand natural shocks "
					+ "That flesh is heir to, 'tis a consummation " + "Devoutly to be wish'd. To die, to sleep; "
					+ "To sleep: perchance to dream: ay, there's the rub; " + ".......");
			r4.setItalic(true);
			// This would imply that this break shall be treated as a simple line break, and
			// break the line after that word:

			XWPFRun r5 = p3.createRun();
			r5.setTextPosition(-10);
			r5.setText("For in that sleep of death what dreams may come");
			r5.addCarriageReturn();
			r5.setText("When we have shuffled off this mortal coil, " + "Must give us pause: there's the respect "
					+ "That makes calamity of so long life;");
			r5.addBreak();
			r5.setText("For who would bear the whips and scorns of time, "
					+ "The oppressor's wrong, the proud man's contumely,");

			r5.addBreak(BreakClear.ALL);
			r5.setText("The pangs of despised love, the law's delay, " + "The insolence of office and the spurns "
					+ ".......");

			try (FileOutputStream out = new FileOutputStream("simple1.docx")) {
				doc.write(out);
			}
		}
	}
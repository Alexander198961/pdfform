package com.mycompany.mavenproject1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alex
 */
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfFormField;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PushbuttonField;
import com.itextpdf.text.pdf.TextField;
import com.itextpdf.text.pdf.PdfAnnotation;
import com.itextpdf.text.pdf.PdfAppearance;
import com.itextpdf.text.pdf.PdfContentByte;
//import com.itextpdf.text.pdf.PdfFormField; 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

 
//import part2.chapter08.Subscribe;
 

public class SubmitForm {
       public static final String SRC = "results/ui3.pdf";
    public static final String DEST = "results/acroforms/field.pdf";
     public static void main(String[] args) throws IOException, DocumentException
     {   File dir= new File("resources/pdfs");
         dir.mkdir();
         File dir1= new File("resources/acroforms");
         dir1.mkdir();
         File file = new File(DEST);
        file.getParentFile().mkdirs();
       System.out.println("HELOO");
        new SubmitForm().manipulatePdf(SRC,DEST);
       
    }
     public void createpdf(String src, String dest) throws DocumentException, IOException {
      PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        PdfFormField pushbutton = PdfFormField.createPushButton(stamper.getWriter());
        pushbutton.setFieldName("PushMe");
        PdfContentByte cb = stamper.getWriter().getDirectContent();
        PdfAppearance normal = cb.createAppearance(100, 50);
        normal.setColorFill(new GrayColor(0.7f));
        normal.rectangle(5, 5, 90, 40);
        normal.fill();
        PdfAppearance rollover = cb.createAppearance(100, 50);
        rollover.setColorFill(new GrayColor(0.7f));
        rollover.rectangle(5, 5, 90, 40);
        rollover.fill();
        PdfAppearance down = cb.createAppearance(100, 50);
        down.setColorFill(new GrayColor(0.7f));
        down.rectangle(5, 5, 90, 40);
        down.fill();       
        pushbutton.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, normal);
        pushbutton.setAppearance(PdfAnnotation.APPEARANCE_ROLLOVER, rollover);
        pushbutton.setAppearance(PdfAnnotation.APPEARANCE_DOWN, down);
        pushbutton.setWidget(new Rectangle(100, 700, 200, 750), PdfAnnotation.HIGHLIGHT_PUSH);
        
            
     }
     
  public void manipulatePdf(String src, String dest) throws DocumentException, IOException {
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        PushbuttonField button = new PushbuttonField(
            stamper.getWriter(), new Rectangle(36, 700, 72, 730), "get");
        //TextField area = new TextField(
          //  stamper.getWriter(), new Rectangle(36, 788, 559, 806), "test12");
        //area.setBackgroundColor(BaseColor.DARK_GRAY);
        //area.setOptions(TextField.VISIBLE);
        
        button.setText("GET");
        button.setBackgroundColor(new GrayColor(0.7f));
        button.setVisibility(PushbuttonField.VISIBLE_BUT_DOES_NOT_PRINT);
        PdfFormField submit = button.getField();
        //stamper.
        AcroFields fields = reader.getAcroFields();

     Set<String> fldNames = fields.getFields().keySet();

for (String fldName : fldNames) {
  System.out.println( fldName + ": " + fields.getField( fldName ) );
}
        submit.setAction(PdfAction.createSubmitForm(
            "http://127.0.0.1/index.php", null,
            PdfAction.SUBMIT_HTML_FORMAT));
        stamper.addAnnotation(submit, 1);
        stamper.close();
    }
}

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
import com.itextpdf.text.List;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfAppearance;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfFormField;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PushbuttonField;



//import com.itextpdf.text.pdf.PdfFormField; 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;



 
//import part2.chapter08.Subscribe;
 

public class SubmitForm {
    
       public static final String SRC = "results/ui3.pdf";
       //public static final String RESOURCE = "results/js/insert.js";
       //public static final String Upload_info_button = "results/js/upload.js";
       public static final String submit_button_script = "results/js/submit.js";
       public static final String checkbox = "results/js/checkbox.js";
       public static final String upload_info = "results/js/parse_url.js";
     public static final String DEST = "results/acroforms/pull5.pdf";
     public static void main(String[] args) throws IOException, DocumentException
     {   File dir= new File("resources/pdfs");
         dir.mkdir();
         File dir1= new File("resources/acroforms");
         dir1.mkdir();
         File file = new File(DEST);
        file.getParentFile().mkdirs();
       
        new SubmitForm().extractFromPdf(SRC,DEST);
       //new SubmitForm().createPdf(DEST);
    }
  
 
  
  public void extractFromPdf(String src, String dest) throws DocumentException, IOException {
     

      

      
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
      
        
        PushbuttonField button = new PushbuttonField(
            stamper.getWriter(), new Rectangle(36, 700, 112, 730), "get");
     
        //stamper.getWriter().addJavaScript(Utilities.readFileToString(RESOURCE));
        button.setText("SAVE My INFO");
        button.setBackgroundColor(new GrayColor(0.7f));
        button.setVisibility(PushbuttonField.VISIBLE_BUT_DOES_NOT_PRINT);
        PdfFormField submit = button.getField();
        
        
        
        
        
        
  /*
        button.setBackgroundColor(new GrayColor(0.7f));
        button.setVisibility(PushbuttonField.VISIBLE_BUT_DOES_NOT_PRINT);
   */    
        
        //PdfFormField pull_data = upload_info.getField();
      //  pull_data.setAction(PdfAction.javaScript(Utilities.readFileToString(submit_button_script), stamper.getWriter()));
        stamper.getWriter().addJavaScript(Utilities.readFileToString(checkbox));
          stamper.getWriter().addJavaScript(Utilities.readFileToString(upload_info));
        //PushbuttonField submitButton=stamper.getAcroFields().getNewPushbuttonFromField("UseSavedInfo");
        //PdfFormField field=submitButton.getField();
        //field.setAction(PdfAction.javaScript("app.alert('hello')" ,stamper.getWriter()));
        /*
         PushbuttonField useMySavedInfo = new PushbuttonField(
          stamper.getWriter(), new Rectangle(36, 1000, 559, 806), "MySavedInfo" );
          useMySavedInfo.setText("Upload info");
          useMySavedInfo.setBackgroundColor(new GrayColor(0.7f));
          useMySavedInfo.setVisibility(PushbuttonField.VISIBLE_BUT_DOES_NOT_PRINT);
           PdfFormField  extractInfo=useMySavedInfo.getField();
*/
         //  extractInfo.setAction(PdfAction.javaScript("alert('hello')", stamper.getWriter()));
         //  extractInfo.setAction(PdfAction.);
        //stamper.
        
        /*
        AcroFields fields = stamper.getAcroFields();
         PushbuttonField submitButton=fields.getNewPushbuttonFromField("SubmitForm");
*/         
//System.out.println(submitButton.getAppearance().getHeight());
         //System.out.println(submitButton.getAppearance().getWidth());
         //System.out.println(submitButton.getAppearance());
         //submitButton
         //submitButton.getField().get
         //submitButton.getWriter().setAdditionalAction(, PdfAction.javaScript("app.alert('os')",stamper.getWriter()));
         //submitButton.getWriter().setAdditionalAction(PdfName., action);
        //PdfFormField sb=submitButton.getField();
        //sb.setAction(PdfAction.javaScript("app.alert('test')", stamper.getWriter()));
       

 // sumbitInfo.setAction(PdfAction.javaScript("app.alert('test')", stamper.getWriter()));
      //submit.setAction(PdfAction.javaScript("app.alert('test')", stamper.getWriter()));
      
   
        
        //PushbuttonField useInfo = fields.getNewPushbuttonFromField("UseSavedInfo");
        //PdfAnnotation getInfo=useInfo.getField();
        //getInfo.setAction(PdfAction.javaScript("app.alert('action!')", stamper.getWriter()));
       
       // ffield.SetAdditionalActions(PdfName.E, PdfAction("app.alert('action!')"));
       
   AcroFields fields = stamper.getAcroFields(); 
   
  // PushbuttonField saveInfo = fields.getNewPushbuttonFromField("SaveInfo");
//   PdfFormField fd=saveInfo.getField();
   //fd.setAction(PdfAction.createSubmitForm("http://127.0.0.1/index.php",null,PdfAction.SUBMIT_HTML_FORMAT));
   //PdfAppearance pa =saveInfo.getAppearance();
  // pa.setAction(PdfAction.createSubmitForm("http://127.0.0.1/index.php",null,PdfAction.SUBMIT_HTML_FORMAT), 0, 0, 0, 0);
   Set<String> fldNames = fields.getFields().keySet();
   
     //AcroFields fields = stamper.getAcroFields();
for (String fldName : fldNames) {
  System.out.println( fldName + ": " + fields.getField( fldName ) );
}
      //submit.setAdditionalAction(PdfAction.javaScript(Utilities.readFileToString(submit_button_script), stamper.getWriter()));
     //http://www.mycrewid.com/Alexander/index.php
   //submit.setAction(PdfAction.createSubmitForm(
     //       "http://127.0.0.1/index.php", null,
       //     PdfAction.SUBMIT_HTML_FORMAT));
   submit.setAction(PdfAction.javaScript(Utilities.readFileToString(submit_button_script), stamper.getWriter()));
    stamper.addAnnotation(submit,1);
       stamper.close();
         //PdfAction.javaScript("this.getField('FirstName').value=util.printd(\"dd mmmm yyyy\",new Date())",stamper.getWriter());
                    
        //stamper.addAnnotation(submitButton, 1);
        //stamper.addAnnotation(sb,1);
      // submit.setAdditionalActions(PdfName.E, PdfAction.javaScript(Utilities.readFileToString(submit_button_script),stamper.getWriter()));
      
    }
 
 
    /**
     * Creates our first table
     * @return our first table
     */
   
  
}

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
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Utilities;
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
import com.itextpdf.text.pdf.PdfDictionary;

import java.io.BufferedReader;


//import com.itextpdf.text.pdf.PdfFormField; 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import java.util.Hashtable;
import java.util.Set;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.impl.client.HttpClientBuilder;

 
//import part2.chapter08.Subscribe;
 

public class SubmitForm {
    
       public static final String SRC = "results/ui4.pdf";
       public static final String RESOURCE = "results/js/insert.js";
    public static final String DEST = "results/acroforms/info.pdf";
     public static void main(String[] args) throws IOException, DocumentException
     {   File dir= new File("resources/pdfs");
         dir.mkdir();
         File dir1= new File("resources/acroforms");
         dir1.mkdir();
         File file = new File(DEST);
        file.getParentFile().mkdirs();
       
        new SubmitForm().extractFromPdf(SRC,DEST);
       
    }
  
 
  
  public void extractFromPdf(String src, String dest) throws DocumentException, IOException {
      Connection conn = null;
   Statement stmt = null;
   String id = null;
   String name =null;
   String last_name =null;
  
      
      
      
      
      
      
      
      
        //System.out.("AAAAAaA==="+userId);
        /*
	Hashtable<String, String>  user_table;
           user_table = getResponse("id="+userId);
          // String JS1="app.alert('hell'+app.URL)";
      */
      

      
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
      
        PushbuttonField button = new PushbuttonField(
            stamper.getWriter(), new Rectangle(36, 700, 72, 730), "get");
     
        stamper.getWriter().addJavaScript(Utilities.readFileToString(RESOURCE));
        button.setText("SAVEMyINFO");
        button.setBackgroundColor(new GrayColor(0.7f));
        button.setVisibility(PushbuttonField.VISIBLE_BUT_DOES_NOT_PRINT);
        PdfFormField submit = button.getField();
        
        
        
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
        
        
        AcroFields fields = stamper.getAcroFields();
        
        //PushbuttonField useInfo = fields.getNewPushbuttonFromField("UseSavedInfo");
        //PdfAnnotation getInfo=useInfo.getField();
        //getInfo.setAction(PdfAction.javaScript("app.alert('action!')", stamper.getWriter()));
       
       // ffield.SetAdditionalActions(PdfName.E, PdfAction("app.alert('action!')"));
       
       //fields.setField("FirstName", name); 
       //fields.setField("LastName", last_name);
       
       //fields.setField("SocialSecurityNumber", name);
       //PdfDictionary uri = new PdfDictionary(PdfName.URI);
      //fields.setField("LocationAddress",name );
       /*
        fields.setField("FirstName", user_table.get("FirstName"));
        fields.setField("LastName", user_table.get("LastName"));
        fields.setField("SocialSecurityNumber", user_table.get("SocialSecurityNumber"));
        fields.setField("LocationAddress", user_table.get("LocationAddress"));
*/
     Set<String> fldNames = fields.getFields().keySet();
     
for (String fldName : fldNames) {
  System.out.println( fldName + ": " + fields.getField( fldName ) );
}
      //submit.setAction(PdfAction.javaScript(JS1, stamper.getWriter()));
        
//submit.setAction(PdfAction.createSubmitForm(
          //  "http://127.0.0.1/index.php", null,
            //PdfAction.SUBMIT_HTML_FORMAT));
         //PdfAction.javaScript("this.getField('FirstName').value=util.printd(\"dd mmmm yyyy\",new Date())",stamper.getWriter());
                    
        stamper.addAnnotation(submit, 1);
        //stamper.addAnnotation(getInfo, 1);
        stamper.close();
    }
      
     
  
}

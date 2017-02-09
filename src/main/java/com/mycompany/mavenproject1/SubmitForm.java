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
import java.io.BufferedReader;
import java.io.DataOutputStream;
//import com.itextpdf.text.pdf.PdfFormField; 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import java.util.Hashtable;
import java.util.Set;
import org.apache.http.NameValuePair;

 
//import part2.chapter08.Subscribe;
 

public class SubmitForm {
    
       public static final String SRC = "results/ui3.pdf";
    public static final String DEST = "results/acroforms/upload_info.pdf";
     public static void main(String[] args) throws IOException, DocumentException
     {   File dir= new File("resources/pdfs");
         dir.mkdir();
         File dir1= new File("resources/acroforms");
         dir1.mkdir();
         File file = new File(DEST);
        file.getParentFile().mkdirs();
       
        new SubmitForm().extractFromPdf(SRC,DEST);
       
    }
    public static Hashtable getResponse(String urlParameters) 
    { 
   
                //String urlParameters="?user_email="+user_email;
                //byte[] b =user_email.getBytes(StandardCharsets.UTF_8);
         	String url = "http://127.0.0.1/api.php"+urlParameters;
                Hashtable<String, String>  user_info= new Hashtable<String, String>();
     
              
try
{
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		
		con.setRequestMethod("GET");
                con.setRequestProperty( "charset", "utf-8");
                /* 
                maybe need post here
                DataOutputStream wr = new DataOutputStream( con.getOutputStream());
                wr.write(b);
		*/

		int responseCode = con.getResponseCode();
		

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		

		while ((inputLine = in.readLine()) != null) {
			String array[] = inputLine.split("=");
                        user_info.put(array[0], array[1]);
		}
		in.close();
}
catch(Exception ex)
{
    
}
  return user_info;	

		
}
  public void extractFromPdf(String src, String dest) throws DocumentException, IOException {
       
	Hashtable<String, String>  user_table;
           user_table = getResponse("SocialSecurityNumber=John");
           String JS1="app.alert('hell'+app.URL)";
      
      
      
      
      
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        PushbuttonField button = new PushbuttonField(
            stamper.getWriter(), new Rectangle(36, 700, 72, 730), "get");
     
        button.setText("SAVE MY INFO");
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
        if(user_table.get("email")!=null)
        fields.setField("email", user_table.get("email"));
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
      
     
  public void manipulatePdf(String src, String dest) throws DocumentException, IOException {
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        PushbuttonField button = new PushbuttonField(
            stamper.getWriter(), new Rectangle(36, 700, 72, 730), "get");
     
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

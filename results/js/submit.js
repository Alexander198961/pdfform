
var email = this.getField('EmailAddress').value;

if(this.getField('LastName').value == "")
{
app.alert("Please input your name");
}
else if(this.getField('FirstName').value == "")
{
app.alert("Please input your name");
}

else if(this.getField('Telephone').value == "")
{
app.alert("Please input your Telepnone");
}
else if(this.getField('State').value == "")
{
app.alert("Please input your State");
}
else if(this.getField('Zip').value == "")
{
app.alert("Please input your Zip");
}
else if(this.getField('StartDate').value == "")
{
app.alert("Please input your StartDate");
}
else if(this.getField('City').value == "")
{
app.alert("Please input your City");
}

else if( email == "")
{
app.alert("Please input your email address");
}
else 
{
 

if ( email.indexOf("@") > 1 && email.length > 4 )
{
this.submitForm({
  cURL: "http://www.mycrewid.com/Alexander/index.php",
  cSubmitAs:"HTML"
});

}
else
{
app.alert("Please input correct an email")
} 

}
//else
//{
//app.alert("correct")
//this.submitForm({
//  cURL: "http://www.mycrewid.com/Alexander/index.php",
//  cSubmitAs:"HTML"
//});
//}

this.getField("newEmployee").setAction("MouseUp" , "this.getField('rehire').value='Off' ;  this.getField('Userchange').value='Off' ")
this.getField("rehire").setAction("MouseUp" , "this.getField('newEmployee').value='Off' ;  this.getField('Userchange').value='Off' ")
this.getField("Userchange").setAction("MouseUp" , "this.getField('rehire').value='Off' ;  this.getField('newEmployee').value='Off' ")
this.getField("us").setAction("MouseUp" , "this.getField('Resauen').value='Off' ;  this.getField('Other').value='Off' ")
this.getField("Resauen").setAction("MouseUp" , "this.getField('up').value='Off' ;  this.getField('Other').value='Off' ")
this.getField("Other").setAction("MouseUp" , "this.getField('up').value='Off' ;  this.getField('Resauen').value='Off' ")
this.getField("minorno").setAction("MouseUp" , "this.getField('minoryes').value='Off'")
this.getField("minoryes").setAction("MouseUp" , "this.getField('minorno').value='Off'")
this.getField("payment_yes").setAction("MouseUp" , "this.getField('payment_no').value='Off'")
this.getField("payment_no").setAction("MouseUp" , "this.getField('payment_yes').value='Off'")

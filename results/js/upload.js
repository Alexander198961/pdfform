
var str=this.path.split('?')[1]
var args=str.split("&")

var array=args[0].split("=")
var first_name=array[1]
var last_name=args[1].split("=")[1]

var address=args[2].split("=")[1]
var telephone=args[3].split("=")[1]


this.getField('LocationAddress').value=address
this.getField('FirstName').value=first_name
this.getField('LastName').value=last_name


var str=this.path.split('?')[1]
var args=str.split("&")
var array=args[0].split("=")
var first_name=array[1]
app.alert(first_name)

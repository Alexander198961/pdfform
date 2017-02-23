
function insert_into_pdf( str )
{
var arr=str.split("=")
try
{
this.getField(arr[0]).value=arr[1]
}
catch(err)
{
//console.info(err)
}
}
var params=this.path.split('?')[1]
var args=params.split("&")
for(i=0; i<args.length;i++)
{

 insert_into_pdf(args[i])

}

//var array=args[0].split("=")
//var first_name=array[1]




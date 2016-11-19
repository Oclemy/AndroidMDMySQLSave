<?php


$host='127.0.0.1';
$username='root';
$pwd='';
$db="spacecraftDB";

$con=mysqli_connect($host,$username,$pwd,$db) or die('Unable to connect');

if(mysqli_connect_error($con))
{
	echo "Failed to Connect to Database ".mysqli_connect_error();
}

$name=$_POST['name'];
$propellant=$_POST['propellant'];
$description=$_POST['description'];

$sql="INSERT INTO spacecraftTB(Name,Propellant,Description) VALUES('$name','$propellant','$description')";

$result=mysqli_query($con,$sql);

if($result)
{
	echo ('Successfully Saved........');
	
}else
{
	echo('Not saved Successfully............');
	
}

mysqli_close($con);

?>
<?php
	$con=mysqli_connect('localhost','root','');
	if(!$con)
	{
	die('Could Not Connect:'.mysql_error());
	}
	mysqli_select_db($con,"flatpro");
	
	//echo $con;
?> 
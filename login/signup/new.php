<?php
	include_once("../includes/connection.php");
	$u=$_POST['uname'];
	$p=$_POST['pass'];
	$s=$_POST['socnm'];
	if(mysqli_query($con,"INSERT INTO `loggin`(`username`, `pass`,`soc_name`) VALUES ('$u','$p','$s')"))
	{
		header("location:done.html");
	}
	else
		header("location:notdone.html");
?>
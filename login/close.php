<?php 
	include_once('includes/connection.php'); 
	$id=$_GET['id'];
	$result=mysqli_query($con,"DELETE FROM `logged_in` WHERE `id`='$id'");
?> 
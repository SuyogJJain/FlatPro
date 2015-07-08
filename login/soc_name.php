<?php  
	include_once('includes/connection.php');
	$id=$_GET['id'];
	$query="SELECT * FROM `logged_in` WHERE `id`='$id'";
	$result=mysqli_query($con,$query);
	if($result->num_rows!=0)
	{
		$row=mysqli_fetch_assoc($result);
		if(!$row)
		{
			echo 'no';
		}
		else
		{
			$username=$row['username'];
			$query="SELECT * FROM `loggin` WHERE `username`='$username'";
			$result=mysqli_query($con,$query);
			$row=mysqli_fetch_assoc($result);
			$ans=$row['soc_name'];
			$ans.=":".$row['main_cost'];
			echo $ans;
		}
	}
	else
	{
		echo 'in else';
	}
?> 
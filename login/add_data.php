<?php  
	include_once('includes/connection.php');
	$id=$_GET['id'];
	$flat_no=$_GET['no'];
	$flat_holder_name=$_GET['name'];
	$mob_no=$_GET['mob'];
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
			$query="INSERT INTO `flat_holders`(`flat_no`, `flat_holder_name`, `mob_no`, `balance`, `username`) VALUES". "('$flat_no','$flat_holder_name','$mob_no','','$username')";
			if($result=mysqli_query($con,$query))
			{
				echo 'yes';
			}
			else
			{
				echo 'no';
			}
		}
	}
	else
	{
		echo 'in else';
	}
?> 
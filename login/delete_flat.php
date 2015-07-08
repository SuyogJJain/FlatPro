<?php  
	include_once('includes/connection.php');
	$id=$_GET['id'];
	$flat_no=$_GET['fno'];
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
			$usernm=$row['username'];
			$query="DELETE FROM `flat_holders` WHERE `flat_no`='$flat_no' AND `username`='$usernm'";
			if(mysqli_query($con,$query))
			{
				echo 'Yes';
			}
			else
				echo 'no';
		}
	}
?> 
<?php  
	include_once('includes/connection.php');
	$id=$_GET['id'];
	$date=$_GET['date'];
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
			$query="DELETE FROM `schedue_meet` WHERE `username`='$usernm' AND `send_date`='$date'";
			if(mysqli_query($con,$query))
			{
				echo 'Yes';
			}
			else
				echo 'no';
		}
	}
?> 
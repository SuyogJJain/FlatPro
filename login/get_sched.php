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
			$query="SELECT * FROM `schedue_meet` WHERE `username`='$username'";
			$result=mysqli_query($con,$query);
			$ans="";
			while ($row = mysqli_fetch_array($result))
			{
				$ans .=$row["message"].":";
				$ans .= $row["send_date"].":";
			}
			trim($ans);
			echo $ans;
		}
	}
	else
	{
		echo 'in else';
	}
?> 
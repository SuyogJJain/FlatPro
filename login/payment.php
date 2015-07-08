<?php  
	include_once('includes/connection.php');
	$id=$_GET['id'];
	$fnm=$_GET['fnm'];
	$mn=$_GET['pay'];
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
			$query="UPDATE `flat_holders` SET `balance`=(`balance`-'$mn')".
			" WHERE `flat_no`='$fnm' AND `username`='$usernm'";
			if(mysqli_query($con,$query))
			{
				echo 'Yes';
				$query="UPDATE `loggin` SET `soc_credit`=`soc_credit`+'$mn' WHERE `username`='$usernm'";
				mysqli_query($con,$query);
			}
			else
				echo 'no';
		}
	}
?> 
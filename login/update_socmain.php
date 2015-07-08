<?php  
	include_once('includes/connection.php');
	$id=$_GET['id'];
	$amt=$_GET['amt'];
	$details=$_GET['details'];
	$get_date=getdate();
	$query="SELECT * FROM `logged_in` WHERE `id`='$id'";
	$result=mysqli_query($con,$query);
	if($result->num_rows!=0)
	{
		$row=mysqli_fetch_assoc($result);
		if(!$row)
		{
			echo 'no1';
		}
		else
		{
			$usernm=$row['username'];
			$query="UPDATE `soc_maintain` SET `debit`=`debit`+'$amt' ,`details`=`details`+'$details'".
			" WHERE `username`='$usernm' AND `month`='".$get_date['mon']."' AND `year`='".$get_date['year']."' ";
			if(mysqli_query($con,$query))
			{
				echo 'Yes';
			}
			else
				echo 'no';
		}
	}
?> 
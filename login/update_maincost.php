<?php  
	include_once('includes/connection.php');
	$id=$_GET['id'];
	$maincost=$_GET['maincost'];
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
			$query="UPDATE `loggin` SET `main_cost`='$maincost'".
			" WHERE  `username`='$usernm'";
			if(mysqli_query($con,$query))
			{
				//mysqli_query($con,"UPDATE `loggin` SET `soc_credit`=`soc_credit`+'$bal' WHERE `username`='$usernm'");
				//$get_date=getdate();
				//mysqli_query($con,"UPDATE `soc_maintain` SET `collection`=`collection`+'$bal' WHERE `username`='$usernm' AND `month`=$get_date['mon'] AND `year`=$get_date['year']")
				echo 'Yes';
			}
			else
				echo 'no';
		}
	}
?> 
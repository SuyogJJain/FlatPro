<?php  
	include_once('../includes/connection.php');
	$user=$_GET['username'];
	$pass=$_GET['pass'];
	$query="SELECT * FROM loggin WHERE `username`='$user' AND `pass`='$pass'";
	$result= mysqli_query($con,$query) ;
	if($result->num_rows!=0)
	{
			
			$id=rand();
			$query="SELECT * FROM logged_in WHERE 'id'='$id'";
			$result= mysqli_query($con,$query);
			$id=mt_rand(0,1000000);
			while($result->num_rows!=0)
			{
				$id=mt_rand(0,1000000);
				$result= mysqli_query($con,$query);
			}
			$query="INSERT INTO `logged_in`(`id`, `username`) VALUES ('$id','$user')";
			if(mysqli_query($con,$query))
			{
				$ans="YES";
				$ans.=":";
				$ans.=$id;
				echo $ans;
			}
			else 
			{
				echo 'No';
			}
	}
	else
	{
		echo 'No';
	}
	
		
?> 
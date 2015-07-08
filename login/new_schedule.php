<?php  
	include_once('includes/connection.php');
	$id=$_GET['id'];
	$msg=$_GET['message'];
	$sdate=$_GET['date'];
	$date2=strtok($sdate,"-");
	$year=$date2;
	$date2=strtok("-");
	$mon=$date2;
	$date=strtok("");
	$day=$date2;
	$main="".$year."-".$mon."-".$day;
	/*$date = DateTime::createFromFormat("Y-m-d", $sdate);
	if($date==false)
	{
		echo 'no';
	}
	else
	{
		$date1= date_format($date,'Y-m-d');
		//echo $date1;
		
	}*/
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
			$query="INSERT INTO `schedue_meet` (`username`, `message`, `send_date`) VALUES ('$username','$msg','$main')";
			//echo $date1;
			if(checkdate($mon, $day, $year))
			{
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
	}
	else
	{
		echo 'in else';
	}
?> 
<?php

########################################################
# Login information for the SMS Gateway
########################################################


########################################################
# Functions used to send the SMS message
########################################################


include_once('includes/connection.php');

function ozekiSend($phone, $msg, $debug=false){
      global $ozeki_user,$ozeki_password,$ozeki_url;

    
      $url= '{SMS:TEXT}';
	  $url.= '{BSNL}';
	  $url.= '{9371901788}';
      $url.= '{'.urlencode($phone).'}';
      $url.= '{'.urlencode($msg).'}';

    //  $urltouse =  $ozeki_url.$url;
     // if ($debug) { echo "Request: <br>$urltouse<br><br>"; }

      //Open the URL to send the message
   //   $response = httpRequest($urltouse);
      if ($debug) {
           echo $url;
          }

     
}
########################################################
# GET data from sendsms.html
########################################################

$get_date=getdate();
$month=$get_date['month'];
//echo $month;

//$d=cal_days_in_month(CAL_GREGORIAN,$val,$get_date['year']);

$mday=$get_date['mday'];
$dateform="".$get_date['year']."-".$get_date['mon']."-".$mday;
echo $dateform;
if(1)
{
  $result=mysqli_query($con,"SELECT `username`,`message` FROM `schedue_meet` WHERE `send_date`='$dateform'");
  while($row=mysqli_fetch_assoc($result))
  {
    $username=$row['username'];
    mysqli_query($con,"DELETE FROM `schedue_meet` WHERE `username`='$username' AND `send_date`='$dateform'");
    $new=mysqli_query($con,"SELECT `mob_no` FROM `flat_holders` WHERE `username`='$username'");
    while($newrow=mysqli_fetch_assoc($new))
    {
      $phonenum[]=$newrow['mob_no'];
    }
    $message="MEETING";
  }

}
if($mday==1)
{
  $result=mysqli_query($con,"SELECT `username` FROM `loggin`");
  while($row=mysqli_fetch_assoc($result))
  {
    echo 'hello';
    echo mysqli_query($con,"INSERT INTO `soc_maintain`(`month`, `username`, `year`) VALUES ('".$get_date['mon']."','".$row['username']."','".$get_date['year']."')");
  }
}
if($mday==28)
{
  $result=mysqli_query($con,"SELECT * FROM `flat_holders`");
  while($row=mysqli_fetch_assoc($result))
  {
      $phonenum[]=$row['mob_no'];
  }
  $message="PAY MAINTAINANCE";

}
else if($mday==3)
{
    $result=mysqli_query($con,"SELECT `mob_no` FROM `flat_holders` WHERE `balance`>0");
    while($row=mysqli_fetch_assoc($result))
    {
        $phonenum[]=$row['mob_no'];
        
    }
    $message = "MAINTAINANCE DATE OVERDUED";
     $result=mysqli_query($con,"SELECT * FROM `loggin`");
  while($row=mysqli_fetch_assoc($result))
  {
      $username[]=$row['username'];
      $main_cost[]=$row['main_cost'];
  }
  
  for($i=0;$i<count($username);$i++)
  {
    $result=mysqli_query($con,"UPDATE `flat_holders` SET `balance`=`balance`+'$main_cost[$i]'  WHERE `username`= '$username[$i]'");
    if(!$result)
    {
      echo 'no';
    }
  }
}


//echo implode($phonenum);

$debug = true;
$url="";
for($i=0;$i<0;$i++)//count($phonenum)
{
  //ozekiSend($phonenum[$i],$message,$debug);
    $url.= '{SMS:TEXT}';
    $url.= '{BSNL}';
    $url.= '{9371901788}';
    $url.= '{'.urlencode($phonenum[$i]).'}';
    $url.= '{'.urlencode($message).'}';
    $url.='</br>';
}
$ch = curl_init();
$user="sjjain.home28@gmail.com:123456789";
$receipientno="9403509212"; 
$senderID="TEST SMS"; 
$msgtxt="this is test message , test"; 
curl_setopt($ch,CURLOPT_URL,  "http://api.mVaayoo.com/mvaayooapi/MessageCompose");
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
curl_setopt($ch, CURLOPT_POST, 1);
curl_setopt($ch, CURLOPT_POSTFIELDS, "user=$user&senderID=$senderID&receipientno=$receipientno&msgtxt=$msgtxt&state=1");
$buffer = curl_exec($ch);
if(empty ($buffer))
{ echo " buffer is empty "; }
else
{ echo $buffer; } 
curl_close($ch);
echo $url;
?>
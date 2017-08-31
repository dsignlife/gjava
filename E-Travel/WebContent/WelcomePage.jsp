<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<!-- 
@author Tomz
-->
<title>ETravel Guide</title>
</head>
 
<body>


<s:actionerror />
<s:form action="Welcome" name="Welcome">

	<table width="80%" border="0" align="center">
		<tr align="center">
			<td align="center">
				<h2>Welcome To eTravel Guide!</h2>
			</td>	
		</tr>

<tr align="center">
			<td align="center">
				
				<div id="divflash"  onmousedown="javascript:doABC();" style="background-color: white; width: 550px ; height: 400px;">
					<object name="f" >
						<param name="wmode" value="transparent" />
		   		  		<EMBED src="flash/etravel.swf" wmode=transparent quality=high bgcolor=#FFFFFF WIDTH="550" HEIGHT="400" NAME="etravel" ALIGN="center" TYPE="application/x-shockwave-flash" PLUGINSPAGE="http://www.macromedia.com/go/getflashplayer"></EMBED>
					</object>
				</div>
	    
	    	</td>
		</tr>
	</table>

</s:form>
<script language="javascript">

function doABC(){
	var form = document.forms["Welcome"];
	form.action = "MainPage.action";
	form.x= 3;
	form.submit();
}

</script>
</body>
</html>
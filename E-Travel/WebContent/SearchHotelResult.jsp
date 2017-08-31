<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<link rel="stylesheet" type="text/css" href="css/themes.css" />
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
	<title>ETravel Guide</title>
	<style>
	html { 
			background: url(image/background.png) no-repeat center center fixed; 
			-webkit-background-size: cover;
			-moz-background-size: cover;
			-o-background-size: cover;
			background-size: cover;
		}
	#transbox
		{  /* Fallback for web browsers that doesn't support RGBa */
			background-color: white
		}	
	</style>
</head>
<body>
<s:actionerror />
<center>
<img style="visibility:hidden;width:0px;height:0px;" border=0 width=0 height=0 src="http://c.gigcount.com/wildfire/IMP/CXNID=2000002.0NXC/bT*xJmx*PTEzMjMzNzI4NTQyMzgmcHQ9MTMyMzM3Mjg1OTM3OSZwPTQ1NTkzMiZkPSZnPTEmbz1kYjZlMDQ4OTE4YmM*ZmFmODc4/NzQwMDcwM2I1ZjdlMyZvZj*w.gif" /><object id="embededBannersnackFlash_3316855ac85ca4f85e5c02aeb3764088" type="application/x-shockwave-flash" data="http://files.bannersnack.net/app/swf2/EmbedPlayerV2.swf?hash_id=3316855ac85ca4f85e5c02aeb3764088&amp;bgcolor=#3D3D3D&amp;clickTag=null&amp;t=1323372821" width="1000" height="200"><param name="allowScriptAccess" value="always" /><param name="movie" value="http://files.bannersnack.net/app/swf2/EmbedPlayerV2.swf?hash_id=3316855ac85ca4f85e5c02aeb3764088&amp;bgcolor=#3D3D3D&amp;clickTag=null&amp;t=1323372821" /><param name="allowFullScreen" value="true" /><param name="bgcolor" value="#3D3D3D" /></object><noscript>To view this animated banner you need to have Flash Player 9 or newer installed and JavaScript enabled. BannerSnack is a <a href="http://www.bannersnack.com/" title="BannerSnack - Free flash banner maker">banner creator</a> that allows you to create cool flash banners without coding.</noscript>
<s:form action="SearchHotel" theme="css_xhtml">
	<table id="transbox"  width="1000" cellpadding="0" cellspacing="0" border="0">
	<s:hidden name="HotelNumber" />
	<tr>
		<td height="7px" colspan="2">
		</td>
		</tr>
		<tr >
			<td  class="headerInfo" bgcolor="#F79239" width="1000px" style="border-left: solid 10px #ffffff; border-right: solid 10px #ffffff" colspan="2">
				<h1 align="center">Hotels Located In Your Selected City</h1>
				<p style="margin-left: 100px; margin-right: 100px;" class="subHead"><font color="#FFFFFF"><DIV ALIGN=CENTER>Contact information and descriptions are listed below</font></DIV></p>
			</td>
		</tr>
				<s:iterator value="hotels" status="portStatus">
					<tr>
						<td height="18">
						</td>
					</tr>
					<tr class="flights">
						<td width="50%" class="borders">
						<b>Name:</b>
							<s:property value="hotelName"/>
						</td>
					</tr>
					<tr class="flights">
						<td width="50%" class="borders" style="background-color: #F0F0F0">
						<b>City:</b>
							<s:property value="city"/>
						</td>
					</tr>
					<tr class="flights">
						<td width="50%" class="borders">
						<b>Rank:</b>
							<s:property value="rank"/>
							
						</td>
					</tr>
					<tr class="flights">
						<td  width="50%" class="borders" style="background-color: #F0F0F0">
						<b>Price:</b>
							<s:property value="price"/>
							
						</td>
					</tr>		
					<tr class="flights">
						<td  width="50%" class="borders">
						<b>Phone:</b>
							<s:property value="phone"/>
							
						</td>
					</tr>
					<tr class="flights">
						<td  width="50%" class="borders" style="background-color: #F0F0F0">
						<b>Link:</b>
							<s:property value="link"/>
							
						</td>
					</tr>
							<tr class="flights">
						<td  width="50%" class="borders">
						<b>Description:</b>
							<s:property value="description"/>
							
						</td>
					</tr>
					
				</s:iterator>
	
		<tr>
			<td height="10px" style="border-left: solid 4px #ffffff; border-right: solid 4px #ffffff">
			</td>
		</tr>	
	</table>
</s:form>
</center>
</body>
</html>
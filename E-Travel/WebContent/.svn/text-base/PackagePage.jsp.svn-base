<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" type="text/css" href="css/themes.css" />
<html>
<head>
<title>ETravel Guide</title>
<script type="text/javascript">
	function set_hidden_value(myvalue) {
		document.getElementById("value_to_submit").value = myvalue;
	}
</script>
<style>
html {
	background: url(image/background.png) no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}
</style>
</head>
<body>
	<center>
		<img style="visibility: hidden; width: 0px; height: 0px;" border=0
			width=0 height=0
			src="http://c.gigcount.com/wildfire/IMP/CXNID=2000002.0NXC/bT*xJmx*PTEzMjMzNzI4NTQyMzgmcHQ9MTMyMzM3Mjg1OTM3OSZwPTQ1NTkzMiZkPSZnPTEmbz1kYjZlMDQ4OTE4YmM*ZmFmODc4/NzQwMDcwM2I1ZjdlMyZvZj*w.gif" />
		<object id="embededBannersnackFlash_3316855ac85ca4f85e5c02aeb3764088"
			type="application/x-shockwave-flash"
			data="http://files.bannersnack.net/app/swf2/EmbedPlayerV2.swf?hash_id=3316855ac85ca4f85e5c02aeb3764088&amp;bgcolor=#3D3D3D&amp;clickTag=null&amp;t=1323372821"
			width="1000" height="200">
			<param name="allowScriptAccess" value="always" />
			<param name="movie"
				value="http://files.bannersnack.net/app/swf2/EmbedPlayerV2.swf?hash_id=3316855ac85ca4f85e5c02aeb3764088&amp;bgcolor=#3D3D3D&amp;clickTag=null&amp;t=1323372821" />
			<param name="allowFullScreen" value="true" />
			<param name="bgcolor" value="#3D3D3D" />
		</object>
		<noscript>
			To view this animated banner you need to have Flash Player 9 or newer
			installed and JavaScript enabled. BannerSnack is a <a
				href="http://www.bannersnack.com/"
				title="BannerSnack - Free flash banner maker">banner creator</a>
			that allows you to create cool flash banners without coding.
		</noscript>
		<s:form action="PackagePage" theme="css_xhtml">
		<s:hidden id="value_to_submit" name="value_to_submit" />
			<table id="transbox" width="1000px" cellpadding="2" cellspacing="0"
				border="0" bgcolor="white">
				<tr>
					<td height="7px" colspan="4"></td>
				</tr>
				<tr>
					<td align="center" colspan="4" class="headerInfo" bgcolor="#F79239"
						width="1000px"
						style="border-left: solid 10px #ffffff; border-right: solid 10px #ffffff">
						<h1>Save Time With Pre-planned Packages!</h1>
						<p class="subHead"
							style="margin-left: 100px; margin-right: 100px;" align="left">Our
							travel experts have put together the best travel packages from
							the most popular destinations in Europe. We'll save you time by
							showing you the best places to stay and the flights that get you
							there.</p>
					</td>
				</tr>
				<tr style="border: none">
					<td colspan="2" align="center" class="headerInfo"
						style="border-left: solid 4px #ffffff; border-right: solid 4px #ffffff">
						<br></br>
					</td>
				</tr>
				<s:iterator value="packages" status="portStatus">
					<tr style="display: inline;" class="packages">
						<td bgcolor="faf6f3" style="border-left: solid 120px #ffffff;">
							<p style="padding-left: 20px;">
								<b>Name:</b>
							</p>
						</td>
						<td bgcolor="faf6f3" style="padding-left: 20px" width="400">
							<p>
								<s:property value="packageName" />
							</p>
						</td>
						<td bgcolor="faf6f3" style="padding-left: 20px">
							<p>
								<b>Date:</b>
							</p>
						</td>
						<td bgcolor="faf6f3" width="169">
							<p>
								<s:property value="packageStartDate" />
							</p>
						</td>
					</tr>
					<tr style="display: inline; padding-bottom: 10px" class="packages">
						<td bgcolor="faf6f3" style="border-left: solid 120px #ffffff;">
							<p style="padding-left: 20px;">
								<b>From:</b>
							</p>
						</td>
						<td bgcolor="faf6f3" style="padding-left: 20px" width="400">
							<p>
								<s:property value="packageDeparture" />
							</p>
						</td>
						<td bgcolor="faf6f3" style="padding-left: 20px">
							<p>
								<b>Cost:</b>
							</p>
						</td>
						<td bgcolor="faf6f3" width="178">
							<p>
								<s:property value="packagePrice" />
							</p>
						</td>
					</tr>
					<tr bgcolor="faf6f3" style="padding-right: 10px">
						<td
							style="border-left: solid 120px #ffffff; border-right: solid 120px #ffffff">
							<p style="margin-left: 150px; margin-right: 20px">
								<s:property value="packageDiscription" />
							</p> <s:submit id="%{packageName}" onclick="set_hidden_value(this.id)" method="packageDetail" value="" cssStyle="background: transparent url(image/buttons/detail.png) no-repeat center top; border: 0px; width: 100px; height: 25px;"/>
							
						</td>
					</tr>
					<tr bgcolor="faf6f3">
						<td
							style="border-left: solid 120px #ffffff; border-right: solid 120px #ffffff"
							height="5"></td>
					</tr>
					<tr>
						<td><br></br></td>
					</tr>
				</s:iterator>
			</table>

		</s:form>
	</center>
</body>
</html>
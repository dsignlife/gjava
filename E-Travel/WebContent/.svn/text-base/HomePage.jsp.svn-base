<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<!-- 
@author Lee
-->
<link rel="stylesheet" type="text/css" media="all"
	href="css/jsDatePick_ltr.min.css" />
<link rel="stylesheet" type="text/css" href="css/themes.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		new JsDatePick({
			useMode : 2,
			target : "inputField",
			dateFormat : "%Y-%m-%d"
		/*selectedDate:{				
			day:5,					
			month:9,
			year:2006
		},
		yearsRange:[1978,2020],
		limitToToday:false,
		cellColorScheme:"beige",
		dateFormat:"%m-%d-%Y",
		imgPath:"img/",
		weekStartDay:1*/
		});
	};
</script>
<script type="text/javascript">
	function upperCase(x) {
		var y = document.getElementById(x).value;
		document.getElementById(x).value = y.toUpperCase();
	}
	function movepic(img_name, img_src) {
		document[img_name].src = 'image/' + img_src + '.jpg';
		document[img_name].title = img_src;
	}

	function set_hidden_value(myvalue) {
		document.getElementById("value_to_submit").value = myvalue;
	}
</script>
<script type="text/javascript" src="js/jsDatePick.min.1.3.js"></script>
<style>
html {
	background: url(image/background.png) no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
}

#transbox { /* Fallback for web browsers that doesn't support RGBa */
	background: rgb(255, 255, 255);
	/* RGBa with 0.05 opacity */
	background: rgba(255, 255, 255);
}
</style>
<title>ETravel Guide</title>
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
		<s:form action="HomePage" theme="css_xhtml">
			<s:hidden id="value_to_submit" name="value_to_submit" />
			<table id="transbox" cellspacing="0" border="0" width="1000px"
				cellpadding="0">
				<tr>
					<td height="7px"></td>
				</tr>
				<tr>
					<td align="center" class="headerInfo" bgcolor="#F79239"
						width="1000px"
						style="border-left: solid 10px #ffffff; border-right: solid 10px #ffffff"
						colspan="2">
						<h1>Welcome to the E-Travel Guide!</h1>
						<p class="subHead">Here you'll find the best prices on travel
							packages and flights to 5 major cities and 25 premiere
							attractions</p>
					</td>
				</tr>
				<tr>
					<td
						style="border-left: solid 4px #ffffff; border-right: solid 4px #ffffff">
						<br></br>
					</td>
				</tr>
				<tr style="display: inline">
					<td style="border-left: solid 80px #ffffff; padding-left: 5px"
						bgcolor="faf6f3" width="417px">
						<p style="text-align: center" class="headed">TRAVELING MADE
							EASY</p>
						<p style="margin-left: 10px; margin-right: 10px; color: #404040"
							class="description">Get the most out of your traveling
							experience with the E-Travel Guide. Pick the cities you're
							interested in or select the attractions you want to visit in
							Europe, and we'll provide you with the best prices on flights and
							accomodations!
						<p style="margin-left: 10px">
							<a href="/E-Travel/MainPage.action">Find the lowest priced
								flights to cities in Europe</a>
						</p>
						<p style="margin-left: 10px">
							<a href="/E-Travel/PlaceSearch.action">Plan your trip based
								on popular attractions</a>
						</p>
					</td>
					<td><img src="image/HomeImages/globe.jpg">
					<td>
				</tr>
				<tr>
					<td><br> <br></td>
				</tr>
				<tr style="display: inline">
					<td style="padding-left: 85px"><img
						src="image/HomeImages/Packages-to-Travel.jpg"></td>
					<td bgcolor="faf6f3" width="423px">
						<p style="text-align: center" class="headed">UPCOMING PACKAGES</p>
						<p style="margin-left: 10px; margin-right: 10px; color: #404040"
							class="description">The E-Travel guide provides trip packages
							to the most popular attractions in Europe. Packages included
							flights, hotels, and other sight-seeing recommendations. See
							which packages are available in the next 2 weeks!</p> <s:iterator
							value="packages" status="portStatus">
							<p style="margin-left: 10px" style="display: inline;"
								align="center">
							<table>
								<tr style="display: inline">
									<td style="padding-left: 10px" width="300px"><s:property value="packageName"/></td>
									<td style="padding-left: 50px"><s:submit id="%{packageName}"
											onclick="set_hidden_value(this.id)" method="packageDetail"
											value="" 
											cssStyle="background: transparent url(image/buttons/detail.png) no-repeat center top; border: 0px; width: 100px; height: 25px;" />
									</td>
								</tr>
							</table>
							</p>
						</s:iterator>
					</td>
				</tr>
				<tr>
					<td><br> <br></td>
				</tr>
				<tr style="display: inline">
					<td style="border-left: solid 80px #ffffff; padding-left: 5px"
						bgcolor="faf6f3" width="417px">
						<p
							style="text-align: center; margin-left: 20x; margin-right: 20px;"
							class="headed">THE MOST SEARCHED TRAVEL ITINERARIES</p>
						<p style="margin-left: 10px; margin-right: 10px; color: #404040"
							class="description">The E-Travel Guide has connecting flights
							to numerous popular destination cities in Europe. Find out which
							cities have been searched the most by other E-Travelers!</p> <s:iterator
							value="topSearcheds" status="portStatus">
							<p style="margin-left: 10px">
								<table>
									<tr>
									<td width="300px"> <s:property value="name" /> </td>
									<td>
								<s:submit id="%{searchedId}" onclick="set_hidden_value(this.id)"
									method="flightsDetail" value=""
									cssStyle="background: transparent url(image/buttons/detail.png) no-repeat center top; border: 0px; width: 100px; height: 25px;" />
									</td>
									<tr>
								</table>
							</p>
						</s:iterator>
					</td>
					<td><img src="image/HomeImages/cities.jpg">
					<td>
				</tr>
				<tr>
					<td><br> <br></td>
				</tr>
			</table>
		</s:form>
	</center>
</body>
</html>
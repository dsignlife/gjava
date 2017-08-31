<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<link rel="stylesheet" type="text/css" href="css/themes.css" />
<link rel="stylesheet" type="text/css" media="all" href="css/jsDatePick_ltr.min.css" />
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<!-- 
@author Lee & Khashayar
-->
	<title>ETravel Guide</title>
	<script type="text/javascript">
	function upperCase(x)
	{
	var y=document.getElementById(x).value;
	document.getElementById(x).value=y.toUpperCase();
	}
	function movepic(img_name,img_src) {
		document[img_name].src='image/places/'+img_src+'.jpg';
		document[img_name].title=img_src;
	}
	</script>
	<script type="text/javascript">
		window.onload = function(){
			new JsDatePick({
				useMode:2,
				target:"inputField",
				dateFormat:"%Y-%m-%d"
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
	<script type="text/javascript" src="js/jsDatePick.min.1.3.js"></script>
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
	<s:actionerror />
	<center>
		<img style="visibility:hidden;width:0px;height:0px;" border=0 width=0 height=0 src="http://c.gigcount.com/wildfire/IMP/CXNID=2000002.0NXC/bT*xJmx*PTEzMjMzNzI4NTQyMzgmcHQ9MTMyMzM3Mjg1OTM3OSZwPTQ1NTkzMiZkPSZnPTEmbz1kYjZlMDQ4OTE4YmM*ZmFmODc4/NzQwMDcwM2I1ZjdlMyZvZj*w.gif" /><object id="embededBannersnackFlash_3316855ac85ca4f85e5c02aeb3764088" type="application/x-shockwave-flash" data="http://files.bannersnack.net/app/swf2/EmbedPlayerV2.swf?hash_id=3316855ac85ca4f85e5c02aeb3764088&amp;bgcolor=#3D3D3D&amp;clickTag=null&amp;t=1323372821" width="1000" height="200"><param name="allowScriptAccess" value="always" /><param name="movie" value="http://files.bannersnack.net/app/swf2/EmbedPlayerV2.swf?hash_id=3316855ac85ca4f85e5c02aeb3764088&amp;bgcolor=#3D3D3D&amp;clickTag=null&amp;t=1323372821" /><param name="allowFullScreen" value="true" /><param name="bgcolor" value="#3D3D3D" /></object><noscript>To view this animated banner you need to have Flash Player 9 or newer installed and JavaScript enabled. BannerSnack is a <a href="http://www.bannersnack.com/" title="BannerSnack - Free flash banner maker">banner creator</a> that allows you to create cool flash banners without coding.</noscript>
		<s:form action="PlaceSearch" theme="css_xhtml">
		<table id="transbox"  width="1000"  border="0" bgcolor="#ffffff">
				<tr>
					<td height="7px">
					</td>
				</tr>
				<tr >
					<td align="center" class="headerInfo" bgcolor="#F79239" width="1000px" style="border-left: solid 10px #ffffff; border-right: solid 10px #ffffff">
						<h1>Visit Landmark Attractions in Europe!</h1>
						<p class="subHead">Here you can find over 25 popular tourist attractions in Europe to help plan your trip! </p>
					</td>
				</tr>
				<s:hidden name="placesNumber" />
				<tr style="border: none">
					<td align="center" class="headerInfo" >
						<br></br>		
					</td>
				</tr>
				<tr style="display: inline" >
					<td  class="selections" style="padding-left: 180px">
						<s:label value="Departure From:" />
					</td>
					<td align="left" style="padding-left: 10px" >
						<select name="sourcePlace" >
							<s:iterator value="citys" status="portStatus">
						  		<option class="dropList">
						    		<s:property value="cityName"/>
						      	</option>
							</s:iterator>
						</select>
					</td>
					<td style="padding-left: 100px" class="selections">
						<s:text name="Departure Date:" />
					</td>
					<td align="left" style="padding-left: 50px">
						<s:textfield name="departureDate" id="inputField" />
					</td>
				</tr>
				<tr>
					<td>
					<br></br>
					</td>
				</tr>
				<tr>
					<td class="selections" style="padding-left: 430px">
						<s:text name="City Attractions:" />
					</td>
				</tr>
					<s:iterator value="selectedPlaces" status="portStatusNo">
						<s:if test="%{#portStatusNo.count < placesNumber +1 }">
							<tr>
								<td align="center">
									<select name="selectedPlaces[${portStatusNo.count}-1]" onchange="movepic('sel'+${portStatusNo.count},this.value)">
									    <s:iterator value="places" status="portStatus">
								    		<s:if test="%{selectedPlaces[#portStatusNo.count-1] == name}">
									            <option class="dropList" selected="selected">
									                <s:property value="name"/>
									            </option>
		                                    </s:if>
		                                    <s:else>
									            <option class="dropList">
									                <s:property value="name"/>
									            </option>
		                                    </s:else>
									    </s:iterator>
								    </select>
								</td>
							</tr>	
							<tr>
								<td height="10px" style="border-left: solid 4px #ffffff; border-right: solid 4px #ffffff">
								</td>
							</tr>
							<tr>
								<td align="center" > 
									<img src="image/places/${selectedPlaces[portStatusNo.count-1]}.jpg" name="sel${portStatusNo.count}" title="Liseberg" />	
								</td>
							</tr>
							<tr>
								<td height="10px" style="border-left: solid 4px #ffffff; border-right: solid 4px #ffffff">
								</td>
							</tr>	
						</s:if>
					</s:iterator>
				<tr style="display: inline">
					<td width="50%" style="padding-left: 250px">
			    		<s:submit method="more" align="center" value="" cssStyle="background: transparent url(image/buttons/addAttraction.png) no-repeat center top; border: 0px; width: 100px; height: 25px;" />
					</td>
					<td width="50%" style="padding-left: 270px">
			    		<s:submit method="less" align="center" value="" cssStyle="background: transparent url(image/buttons/removeAttraction.png) no-repeat center top; border: 0px; width: 100px; height: 25px;" />
					</td>
				</tr>
				<tr>
					<td colspan="2" style="padding-left: 20px">
			    		<s:submit method="search" align="center" value="" cssStyle="background: transparent url(image/buttons/find.png) no-repeat center top; border: 0px; width: 100px; height: 25px;" />
					</td>
				</tr>	
			</table>
		</s:form>
	</center>
</body>
</html>
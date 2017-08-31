<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<!-- 
@author Lee & Khashayar
-->
	<link rel="stylesheet" type="text/css" media="all" href="css/jsDatePick_ltr.min.css" />
	<link rel="stylesheet" type="text/css" href="css/themes.css" />
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
	<script type="text/javascript">
	function upperCase(x)
	{
	var y=document.getElementById(x).value;
	document.getElementById(x).value=y.toUpperCase();
	}
	function movepic(img_name,img_src) {
		document[img_name].src='image/cities/'+img_src+'.jpg';
		document[img_name].title=img_src;
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
	#transbox
	{  /* Fallback for web browsers that doesn't support RGBa */
	background: rgb(255, 255, 255);
	/* RGBa with 0.05 opacity */
	background: rgba(255, 255, 255);
	}
	</style>
	<title>ETravel Guide</title>
</head>
 
<body>
<s:actionerror />
<center>
<img style="visibility:hidden;width:0px;height:0px;" border=0 width=0 height=0 src="http://c.gigcount.com/wildfire/IMP/CXNID=2000002.0NXC/bT*xJmx*PTEzMjMzNzI4NTQyMzgmcHQ9MTMyMzM3Mjg1OTM3OSZwPTQ1NTkzMiZkPSZnPTEmbz1kYjZlMDQ4OTE4YmM*ZmFmODc4/NzQwMDcwM2I1ZjdlMyZvZj*w.gif" /><object id="embededBannersnackFlash_3316855ac85ca4f85e5c02aeb3764088" type="application/x-shockwave-flash" data="http://files.bannersnack.net/app/swf2/EmbedPlayerV2.swf?hash_id=3316855ac85ca4f85e5c02aeb3764088&amp;bgcolor=#3D3D3D&amp;clickTag=null&amp;t=1323372821" width="1000" height="200"><param name="allowScriptAccess" value="always" /><param name="movie" value="http://files.bannersnack.net/app/swf2/EmbedPlayerV2.swf?hash_id=3316855ac85ca4f85e5c02aeb3764088&amp;bgcolor=#3D3D3D&amp;clickTag=null&amp;t=1323372821" /><param name="allowFullScreen" value="true" /><param name="bgcolor" value="#3D3D3D" /></object><noscript>To view this animated banner you need to have Flash Player 9 or newer installed and JavaScript enabled. BannerSnack is a <a href="http://www.bannersnack.com/" title="BannerSnack - Free flash banner maker">banner creator</a> that allows you to create cool flash banners without coding.</noscript>
<s:form action="MainPage" theme="css_xhtml">
	
	<table id="transbox" cellspacing="0" border="0" width="1000px" >
	<s:hidden name="destinationNumber" />
	<tr>
		<td height="7px" colspan="4">
		</td>
	</tr>
	<tr >
		<td align="center" colspan="4" class="headerInfo" bgcolor="#F79239" width="1000px" style="border-left: solid 10px #ffffff; border-right: solid 10px #ffffff">
			<h1>Welcome to the E-Travel Guide!</h1>
			<p class="subHead">Here you'll find the best prices on travel packages and flights to 5 major cities and 25 premiere attractions </p>
		</td>
	</tr>
	<tr>
		<td  style="border-left: solid 4px #ffffff; border-right: solid 4px #ffffff" colspan="4">
		<br></br>
	</td>
	</tr>
	<tr style="display: inline" >
		<td style="padding-left: 180px; border-left: solid 4px #ffffff" class="selections" style="border-left: solid 10px #ffffff" >
			<s:label value="Departure From:" />
		</td>
			<td style="padding-left: 5px" >
				<select name="sourcePlace">
				    <s:iterator value="citys" status="portStatus">
			            <option class="dropList">
			                <s:property value="cityName"/>
			            </option>
				    </s:iterator>
				</select>
			</td>
			<td style="padding-left: 50px" class="selections" >
				<s:text name="Departure Date:" />
			</td>
			<td >
				<s:textfield name="departureDate" id="inputField" />
			</td>
		</tr>
		<tr style="border: none">
			<td colspan="2" align="center" class="headerInfo" style="border-left: solid 4px #ffffff; border-right: solid 4px #ffffff" >
			<br></br>
			</td>
		</tr>
		<tr align="left" style="display: inline" >
			<td style="padding-left: 250px; border-left: solid 4px #ffffff" class="selections">
				<s:text name="Destination:"/>
			</td>
			<td align="left" style="padding-left: 230px"  class="selections"  >
				<s:text name="Number of Days to Stay:"/>
			</td>
		</tr>
		<tr style="display: block">
			<s:iterator value="destination" status="portStatusNo">
				<s:if test="%{#portStatusNo.count < destinationNumber +1 }">
					<tr style="display: block">
						<td style="padding-left: 250px; border-left: solid 4px #ffffff" align="left" style="display: block">
							<select name="destination[${portStatusNo.count}-1]" onchange="movepic('des'+${portStatusNo.count},this.value)">
							    <s:iterator value="citys" status="portStatus">
						    		<s:if test="%{destination[#portStatusNo.count-1] == cityName}">
							            <option selected="selected">
							                <s:property value="cityName"/>
							            </option>
                                    </s:if>
                                    <s:else>
							            <option>
							                <s:property value="cityName"/>
							            </option>
                                    </s:else>
							    </s:iterator>
						    </select>
						</td>	
						<td align="left" style="padding-left: 290px">
							<select name="stayingDays[${portStatusNo.count}-1]" >
							    <s:iterator value="days" status="portStatus">
							    	<s:if test="%{stayingDays[#portStatusNo.count-1] == number}">
						            	<option selected="selected">
						                	<s:property value="number" />
						            	</option>
					            	</s:if>
					            	<s:else>
						            	<option>
						                	<s:property value="number"/>
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
					<tr align="left" style="display: block">
						<td style="padding-left: 250px; border-left: solid 4px #ffffff">
							<img src="image/cities/${destination[portStatusNo.count-1]}.jpg" name="des${portStatusNo.count}" title="Gothenburg" />
						</td>	
					</tr>
					<tr>
						<td height="10px" style="border-left: solid 4px #ffffff; border-right: solid 4px #ffffff">
						</td>
					</tr>
				</s:if>
			</s:iterator>
		</tr>
		<tr>
			<td align="center" class="selections" style="border-left: solid 4px #ffffff; border-right: solid 4px #ffffff">
				<p>Add More Destinations To Your Trip:</p>
			</td>
		</tr>
		<tr>
			<td height="5px" style="border-left: solid 4px #ffffff; border-right: solid 4px #ffffff">
			</td>
		</tr>
		<tr style="display: inline" style="border-top-style: solid">
			<td style="padding-left: 250px; border-left: solid 4px #ffffff">
			    <s:submit method="more" align="center" value="" cssStyle="background: transparent url(image/buttons/addCity.png) no-repeat center top; border: 0px; width: 100px; height: 25px;" />
			</td>
			<td style="padding-left: 300px;">
			    <s:submit method="less" align="center" value="" cssStyle="background: transparent url(image/buttons/removeCity.png) no-repeat center top; border: 0px; width: 100px; height: 25px;" />
			</td>
			<td width="246px" style="border-right: solid 4px #ffffff">
			</td>
		</tr>
		<tr>
			<td height="10px" style="border-left: solid 4px #ffffff; border-left: solid 4px #ffffff; border-right: solid 4px #ffffff">
			</td>
		</tr>
		<tr>
			<td height="10px" style="border-left: solid 4px #ffffff; border-right: solid 4px #ffffff">
			</td>
		</tr>
		<tr >
			<td colspan="2" style="padding-left: 20px; border-left: solid 4px #ffffff; border-right: solid 4px #ffffff" >
			    <s:submit method="search" align="center" value="" cssStyle="background: transparent url(image/buttons/find.png) no-repeat center top; border: 0px; width: 100px; height: 25px;" />
			</td>
		</tr>
		<tr>
			<td height="3" style="border-left: solid 4px #ffffff; border-right: solid 4px #ffffff">
			</td>
		</tr>
		<tr>
			<td  height="3px">
			</td>
		</tr>
	</table>
</s:form>
</center>
</body>
</html>
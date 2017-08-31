<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<link rel="stylesheet" type="text/css" href="css/themes.css" />
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<!-- 
@author Lee & Khashayar
-->
	<title>ETravel Guide</title>
	<style>
	html { 
			background-color:#F0F0F0 ;
		}

	#flightinfo th
		{
		font-size:1.6em;
		text-align:left;
		background-color:#F79239;
		color:#ffffff;
		}
	</style>
</head>
<body>
<s:actionerror />
<center>
<img style="visibility:hidden;width:0px;height:0px;" border=0 width=0 height=0 src="http://c.gigcount.com/wildfire/IMP/CXNID=2000002.0NXC/bT*xJmx*PTEzMjMzNzI4NTQyMzgmcHQ9MTMyMzM3Mjg1OTM3OSZwPTQ1NTkzMiZkPSZnPTEmbz1kYjZlMDQ4OTE4YmM*ZmFmODc4/NzQwMDcwM2I1ZjdlMyZvZj*w.gif" /><object id="embededBannersnackFlash_3316855ac85ca4f85e5c02aeb3764088" type="application/x-shockwave-flash" data="http://files.bannersnack.net/app/swf2/EmbedPlayerV2.swf?hash_id=3316855ac85ca4f85e5c02aeb3764088&amp;bgcolor=#3D3D3D&amp;clickTag=null&amp;t=1323372821" width="1000" height="200"><param name="allowScriptAccess" value="always" /><param name="movie" value="http://files.bannersnack.net/app/swf2/EmbedPlayerV2.swf?hash_id=3316855ac85ca4f85e5c02aeb3764088&amp;bgcolor=#3D3D3D&amp;clickTag=null&amp;t=1323372821" /><param name="allowFullScreen" value="true" /><param name="bgcolor" value="#3D3D3D" /></object><noscript>To view this animated banner you need to have Flash Player 9 or newer installed and JavaScript enabled. BannerSnack is a <a href="http://www.bannersnack.com/" title="BannerSnack - Free flash banner maker">banner creator</a> that allows you to create cool flash banners without coding.</noscript>
<s:form action="ResultPage" theme="css_xhtml">
		<table id="flightinfo" width="1000" align="center" border="0" bgcolor="ffffff">
		<th>Flight Information</th>
			
			<s:hidden name="page"/>
			<s:iterator value="resultFlights" status="portStatus" >
				<s:if test="%{#portStatus.count == page+1}">
					<tr class="flights">
						<td width="50%" class="borders">
						<b>Departure Airport:</b>
							<s:property value="from"/>
							
						</td>
						<td rowspan="11"  width="50%" align="center" style="padding-bottom: 2em">
							<embed src="${imagePath}" quality=high bgcolor=#FFFFFF WIDTH="461" HEIGHT="500" NAME="Got-Paris" TYPE="application/x-shockwave-flash" PLUGINSPAGE="http://www.macromedia.com/go/getflashplayer"></embed>
						</td>
					</tr>
					<tr class="flights" style="background-color: #F0F0F0">
						<td  width="50%" class="borders">
						<b>Destination Airport:</b>
							<s:property value="to"/>
							
						</td>
					</tr>
					<tr class="flights">
						<td width="50%" class="borders">
						<b>Flight Name:</b>
							<s:property value="flightNo"/>
							
						</td>
					</tr>
					<tr class="flights">
						<td width="50%" class="borders" style="background-color: #F0F0F0">
						<b>Return Airline:</b>
							<s:property value="airLine"/>
							
						</td>
					</tr>
					<tr class="flights">
						<td width="50%" class="borders">
						<b>Flight Date:</b>
							<s:property value="date"/>
							
						</td>
					</tr>
					<tr class="flights">
						<td width="50%" class="borders" style="background-color: #F0F0F0">
						<b>Departure Time:</b>
							<s:property value="time"/>
							
						</td>
					</tr>
					<tr class="flights">
						<td width="50%" class="borders">
						<b>Landing Time:</b>
							<s:property value="duration"/>
						</td>
					</tr>
					<tr class="flights">
						<td width="50%" class="borders" style="background-color: #F0F0F0">
						<b>Delayed:</b>
							<s:property value="delayed"/>
						</td>
					</tr>
					<tr class="flights">
						<td width="50%" class="borders">
						<b>Economy Class (SEK):</b>
							<s:property value="cost"/>
							
						</td>
					</tr>
					<tr class="flights">
						<td  width="50%" class="borders" style="background-color: #F0F0F0">
						<b>Business Class (SEK):</b>
							<s:property value="businessCost"/>
							
						</td>
					</tr>
					<tr valign="top" class="flights">
						<td width="50%" valign="top" class="borders">
						<b>Gate #:</b>
							<s:property value="gate"/>
						</td>
					</tr>
				</s:if>
			</s:iterator>
			<tr >
				<td colspan="2"  width="100%">
					<table border="0" cellspacing="0" width="100%">
					<th>City Attractions</th>
					<th>Category</th>
					<th>Cost</th>
						<s:iterator value="places" status="portStatus2">
							<tr>
								<td class="places">
									<s:a href="#" onclick="javascript:window.open('%{link}');"><s:property value="name"/></s:a>
								</td>
								<td class="catagories">
									<s:property value="type"/>
								</td>
								<td class="catagories">
									<s:property value="cost"/>
								</td>
							</tr>																
						</s:iterator>
					</table>
				</td>
			</tr>
			<tr class="menubuttons">
				<td colspan="2" width="100%">
					<table width="100%" border="0">
						<tr>
							<s:if test="%{pageStatus == -1}">
								<td align="left">
									<s:submit method="back" value="" align="left" disabled="true" cssStyle="background: transparent url(image/buttons/BackBlank.png) no-repeat center top; border: 0px; width: 200px; height: 25px;"/>
								</td>
							</s:if>
							<s:else>
								<td align="left">
									<s:submit method="back" value="" align="left" disabled="false" cssStyle="background: transparent url(image/buttons/Back.png) no-repeat center top; border: 0px; width: 200px; height: 25px;"/>
								</td>
							</s:else>
							<td align="center">
								<s:submit method="home" value="" align="center" cssStyle="background: transparent url(image/buttons/SearchAgain.png) no-repeat center top; border: 0px; width: 200px; height: 25px;"/>
							</td>
							<s:if test="%{pageStatus == 1}">
								<td align="right">
									<s:submit method="next" value="" align="right" disabled="true" cssStyle="background: transparent url(image/buttons/NextBlank.png) no-repeat center top; border: 0px; width: 200px; height: 25px;"/>
								</td>
							</s:if>
							<s:else>
								<td align="right">
									<s:submit method="next" value="" align="right" disabled="false" cssStyle="background: transparent url(image/buttons/Next.png) no-repeat center top; border: 0px; width: 200px; height: 25px;" />
								</td>
							</s:else>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		
</s:form>
</center>
</body>
</html>
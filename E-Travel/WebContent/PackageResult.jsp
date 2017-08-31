<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/themes.css" />
<script type="text/javascript">
	function addHTML(target, title, desc, price) {

		var i = 1;
		for (i = 1; i <= 100; i++) {
			if (document.getElementById(i) != null) {
				document.getElementById(i).style.backgroundColor = "white";
			}
		}
		var myTarget = document.getElementById(target);
		myTarget.style.backgroundColor = "red";

		var myTitle = document.getElementById("myinfotitle");
		var myDesc = document.getElementById("myinfodescription");
		var myPrice = document.getElementById("myinfoprice");

		myTitle.innerHTML = title;
		myDesc.innerHTML = desc;
		myPrice.innerHTML = price;
	}
 
	function addFlightHtml(target, flightNo, airLine, fromCity, toCity, date,
			time, duration, cost, gate, image) {

		var i = 1;
		for (i = 1; i <= 100; i++) {
			if (document.getElementById(i) != null) {
				document.getElementById(i).style.backgroundColor = "white";
			}
		}
		var myTarget = document.getElementById(target);
		myTarget.style.backgroundColor = "gray";

		var table = document.getElementById("myinfotable");
		table.innerHTML = "";
		var rowTitle = document.createElement("TR");
		var tdTitle = document.createElement("TD");

		var tableTitle = document.createElement("TABLE");
		var rowfirst = document.createElement("TR");
		var tdTitleFlightNo = document.createElement("TD");
		var tdTitleImage = document.createElement("IMG");
		var fontTitle = document.createElement("FONT");
		var rowTitleDeparture = document.createElement("TR");
		var tdTitleDeparture = document.createElement("TD");
		var fontTitleDeparture = document.createElement("FONT");
		var rowTitleDestination = document.createElement("TR");
		var tdTitleDestination = document.createElement("TD");
		var fontTitleDestination = document.createElement("FONT");
		fontTitleDestination.face = "helvetica";
		fontTitleDestination.size = "2";
		fontTitleDeparture.face = "helvetica";
		fontTitleDeparture.size = "2";

		fontTitleDestination.innerHTML = "Arrival : " + toCity;
		tdTitleDestination.appendChild(fontTitleDestination);
		tdTitleDestination.align = "left";
		tdTitleDestination.colspan = "2";
		rowTitleDestination.appendChild(tdTitleDestination);
		rowTitleDestination.style.height = "40px";
		rowTitleDestination.style.verticalAlign = "top";

		fontTitleDeparture.innerHTML = "Depurture : " + fromCity + "  " + time;
		tdTitleDeparture.appendChild(fontTitleDeparture);
		tdTitleDeparture.align = "left";
		tdTitleDeparture.colspan = "2";
		rowTitleDeparture.appendChild(tdTitleDeparture);
		rowTitleDeparture.style.height = "20px";

		fontTitle.face = "helvetica";
		fontTitle.size = "6";

		fontTitle.innerHTML = flightNo + "  ";
		tdTitleFlightNo.appendChild(fontTitle);
		tdTitleImage.src = image;
		tdTitleImage.style.width = "35px";
		tdTitleImage.style.height = "35px";
		rowfirst.appendChild(tdTitleFlightNo);
		rowfirst.appendChild(tdTitleImage);
		tableTitle.appendChild(rowfirst);
		tableTitle.appendChild(rowTitleDeparture);
		tableTitle.appendChild(rowTitleDestination);

		tdTitle.appendChild(tableTitle);
		tdTitle.style.height = "50px";
		tdTitle.align = "center";
		rowTitle.appendChild(tdTitle);

		var rowPrice = document.createElement("TR");
		var tdPrice = document.createElement("TD");
		var fontPrice = document.createElement("FONT");
		fontPrice.face = "helvetica";
		fontPrice.size = "3";

		fontPrice.innerHTML = "Price : " + cost;
		tdPrice.appendChild(fontPrice);
		tdPrice.align = "center";
		rowPrice.appendChild(tdPrice);
		rowPrice.style.height = "40px";
		rowPrice.style.backgroundColor = "#e4e4e4";

		var rowDeparture = document.createElement("TR");
		var tdDeparture = document.createElement("TD");
		var fontDeparture = document.createElement("FONT");
		fontDeparture.face = "helvetica";
		fontDeparture.size = "4";

		fontDeparture.innerHTML = "Depurture : " + fromCity + "  " + time
				+ "  " + date;
		tdDeparture.appendChild(fontDeparture);
		tdDeparture.align = "center";
		rowDeparture.appendChild(tdDeparture);
		rowDeparture.style.height = "40px";

		var rowGate = document.createElement("TR");
		var tdGate = document.createElement("TD");
		var fontGate = document.createElement("FONT");
		fontGate.face = "helvetica";
		fontGate.size = "3";

		fontGate.innerHTML = "Gate : " + gate;
		tdGate.appendChild(fontGate);
		tdGate.align = "center";
		rowGate.appendChild(tdGate);
		rowGate.style.height = "40px";
		rowGate.style.backgroundColor = "#e4e4e4";

		var rowDestination = document.createElement("TR");
		var tdDestination = document.createElement("TD");
		var fontDestination = document.createElement("FONT");
		fontDestination.face = "helvetica";
		fontDestination.size = "4";
		var rowDestination = document.createElement("TR");
		var tdDestination = document.createElement("TD");
		var fontDestination = document.createElement("FONT");
		fontDestination.face = "helvetica";
		fontDestination.size = "4";

		fontDestination.innerHTML = "Destination : " + toCity;
		tdDestination.appendChild(fontDestination);
		tdDestination.align = "center";
		rowDestination.appendChild(tdDestination);
		rowDestination.style.verticalAlign = "top";

		table.appendChild(rowTitle);
		table.appendChild(rowPrice);
		table.appendChild(rowDeparture);
		table.appendChild(rowGate);
		table.appendChild(rowDestination);
	}

	function addHotelHtml(target, hotelName, rank, price, phone, link,
			description , image) {

		var i = 1;
		for (i = 1; i <= 100; i++) {
			if (document.getElementById(i) != null) {
				document.getElementById(i).style.backgroundColor = "white";
			}
		}
		var myTarget = document.getElementById(target);
		myTarget.style.backgroundColor = "gray";

		var table = document.getElementById("myinfotable");
		table.innerHTML = "";

		var rowName = document.createElement("TR");
		var tdName = document.createElement("TD");
		var fontName = document.createElement("FONT");
		fontName.face = "helvetica";
		fontName.size = "4";

		fontName.innerHTML = hotelName;
		tdName.appendChild(fontName);
		tdName.align = "center";
		tdName.colSpan = "2";
		rowName.appendChild(tdName);

		var rowDescPhoto = document.createElement("TR");
		var tdDescription= document.createElement("TD");
		var fontDescription = document.createElement("FONT");
		var imageHotel = document.createElement("IMG");
		var tdPhoto= document.createElement("TD");
		fontDescription.face = "helvetica";
		fontDescription.size = "3";
		
		fontDescription.innerHTML = description;
		tdDescription.appendChild(fontDescription);
		tdDescription.align = "left";
		tdDescription.rowSpan = "5";
		
		imageHotel.src = image;
		tdPhoto.appendChild(imageHotel);
		rowDescPhoto.appendChild(tdDescription);
		rowDescPhoto.appendChild(tdPhoto);

		var rowPrice = document.createElement("TR");
		var tdPrice = document.createElement("TD");
		var fontPrice = document.createElement("FONT");
		fontPrice.face = "helvetica";
		fontPrice.size = "2";

		fontPrice.innerHTML = "Price Per Day : " + price;
		tdPrice.appendChild(fontPrice);
		tdPrice.align = "left";
		rowPrice.appendChild(tdPrice);

		var rowRank = document.createElement("TR");
		var tdRank = document.createElement("TD");
		var fontRank = document.createElement("FONT");
		fontRank.face = "helvetica";
		fontRank.size = "2";

		fontRank.innerHTML = "Rank : " + rank;
		tdRank.appendChild(fontRank);
		tdRank.align = "left";
		rowRank.appendChild(tdRank);
		
		var rowPhone = document.createElement("TR");
		var tdPhone = document.createElement("TD");
		var fontPhone = document.createElement("FONT");
		fontPhone.face = "helvetica";
		fontPhone.size = "2";

		fontPhone.innerHTML = "Phone : " + phone;
		tdPhone.appendChild(fontPhone);
		tdPhone.align = "left";
		rowPhone.appendChild(tdPhone);
		
		var rowLink = document.createElement("TR");
		var tdLink = document.createElement("TD");
		var fontLink = document.createElement("FONT");
		var hrefLink = document.createElement("a");
		fontLink.face = "helvetica";
		fontLink.size = "2";

		fontLink.innerHTML = link;
		hrefLink.appendChild(fontLink);
		hrefLink.href = "#";
		var jsc = "window.open('"+link+"')";
		hrefLink.setAttribute('onclick', jsc); 
		tdLink.appendChild(hrefLink);
		tdLink.align = "left";
		rowLink.appendChild(tdLink);
		
		table.appendChild(rowName);
		table.appendChild(rowDescPhoto);
		table.appendChild(rowPrice);
		table.appendChild(rowRank);
		table.appendChild(rowPhone);
		table.appendChild(rowLink);

	}

	function addPlaceHtml(target, placeName, description , image) {

		var i = 1;
		for (i = 1; i <= 100; i++) {
			if (document.getElementById(i) != null) {
				document.getElementById(i).style.backgroundColor = "white";
			}
		}
		var myTarget = document.getElementById(target);
		myTarget.style.backgroundColor = "gray";

		var table = document.getElementById("myinfotable");
		table.innerHTML = "";
		
		var rowPhoto = document.createElement("TR");
		var tdPhoto= document.createElement("TD");
		var imagePlace = document.createElement("IMG");

		imagePlace.src = image;
		tdPhoto.appendChild(imagePlace);
		rowPhoto.appendChild(tdPhoto);
		
		var rowName = document.createElement("TR");
		var tdName = document.createElement("TD");
		var fontName = document.createElement("FONT");
		fontName.face = "helvetica";
		fontName.size = "4";

		fontName.innerHTML = placeName;
		tdName.appendChild(fontName);
		tdName.align = "left";
		rowName.appendChild(tdName);

		var rowDesc = document.createElement("TR");
		var tdDesc = document.createElement("TD");
		var fontDesc = document.createElement("FONT");
		fontDesc.face = "helvetica";
		fontDesc.size = "3";

		fontDesc.innerHTML = description;
		tdDesc.appendChild(fontDesc);
		tdDesc.align = "left";
		rowDesc.appendChild(tdDesc);

		table.appendChild(rowPhoto);
		table.appendChild(rowName);
		table.appendChild(rowDesc);
		
	}	
	
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

#transbox {
	background-color: white
}
</style>
<title>ETravel Guide</title>
</head>
<body>
	<s:actionerror />
	<div style="margin-left: 175px; top: 0px; position: fixed; z-index: 1;">
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
	</div>
	<s:form action="PackageResult" theme="css_xhtml">
		<s:hidden id="value_to_submit" name="value_to_submit" />
		<div
			style="width: 500px; margin-left: 179px; z-index: 0; position: absolute; margin-top: 191px; height: 70%; background-color: white;">
			<table id="transbox" width="100%" cellpadding="2" cellspacing="0"
				border="0">
				<tr>
					<td>
						<br />
					</td>
				</tr>
				<s:iterator value="packageCities" status="portStatus">
					<tr>
						<td colspan="3">
							<font face="helvetica" size=2> 
								<s:property	value="cityName" />
							</font>
						</td>
					</tr>
					<s:if test="%{status == 0}">
						<tr>
							<td colspan="3"><s:submit id="%{cityName}" onclick="set_hidden_value(this.id)" method="open"
									align="center" value=""
									cssStyle="background: transparent url(image/down.jpg) no-repeat center top; border: 0px; width: 495px; height: 12px;">
								</s:submit></td>
						</tr>
					</s:if>
					<s:else>
						<s:iterator value="packageInners" status="portStatus2">
							<s:if test="%{step >= from && step <= to}">
								<s:if test="%{type == 'flight'}">
									<tr id="${step}" style=""
										onmouseover="javascript:addFlightHtml(this.id , '${flightNo}' , '${flightAirLine}' , '${flightFrom}' , '${flightTo}' , '${flightDate}' , '${flightTime}' , '${flightDuration}' , '${flightCost}' , '${flightGate}' , '${flightImagePath}')">
								</s:if>
								<s:if test="%{type == 'hotel'}">
									<tr id="${step}" style=""
										onmouseover="javascript:addHotelHtml(this.id, '${hotelName}' , '${hotelRank}' , '${hotelPrice}' , '${hotelPhone}' , '${hotelLink}' , '${hotelDescription}' , '${hotelImagePath}')">
								</s:if>
								<s:if test="%{type == 'place'}">
									<tr id="${step}" style=""
										onmouseover="javascript:addPlaceHtml(this.id, '${placeName}', '${placeDescription}' , '${placeImagePath}')">
								</s:if>

								<td><font face="helvetica" size=2> <img
										src="${imagePath}" alt="${imagePath}" />
								</font></td>
								<td><font face="helvetica" size=2> <s:property
											value="title" />
								</font></td>
								<td><font face="helvetica" size=2> <s:property
											value="date" />
								</font></td>
								</tr>
							</s:if>
						</s:iterator>
						<tr>
							<td colspan="3"><s:submit id="%{cityName}"
									onclick="set_hidden_value(this.id)" method="close"
									align="center" value=""
									cssStyle="background: transparent url(image/up.jpg) no-repeat center top; border: 0px; width: 495px; height: 12px;">
								</s:submit></td>
						</tr>
					</s:else>
				</s:iterator>
			</table>
		</div>
		<div id="myinfodiv"
			style="width: 500px; height: 70%; margin-left: 679px; z-index: 3; position: fixed; margin-top: 191px; background-color: white;">
			<table id="myinfotable" width='100%' border="0"
				style="background-color: white; border: 1px; border-width: 1px; border-style: double; height: 100%; font-family: fantasy;">
				<tr>
					<td id="myinfotitle"></td>
				</tr>
				<tr>
					<td id="myinfodescription"></td>
				</tr>
				<tr>
					<td id="myinfoprice"></td>
				</tr>
			</table>
		</div>
	</s:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PG Homes</title>
<link rel="shortcut icon" href="images/pg_homes.gif" />
<link rel="stylesheet" href="scripts/style.css" type="text/css" />
<script type="text/javascript" src="scripts/script.js"></script>
<style type="text/css">#l_top{border-top: 1px solid #aaa;)</style>
<style type="text/css">#lv_right{border-right: 1px solid #aaa;)</style>
<style type="text/css">#lv_left{border-left: 1px solid #aaa;)</style>
<style type="text/css">#l_bottom{border-bottom: 1px solid #aaa;)</style>
<script type="text/javascript">
function getRoomNames(pgId) {
	var url="GetRoomNames?pgId="+pgId;
	var xmlhttp = false;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	}
	else if (window.ActiveXObject){ 
		try {
			xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
		} 
		catch (e) {
			try{
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			catch (e){}
		}
	}
	else return false;
	
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            document.getElementById("roomNames").innerHTML=xmlhttp.responseText;
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}
function getLocalityList(cityName) {
	var url="GetLocalityList?cityName="+cityName;
	var xmlhttp = false;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	}
	else if (window.ActiveXObject){ 
		try {
			xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
		} 
		catch (e) {
			try{
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			catch (e){}
		}
	}
	else return false;
	
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            document.getElementById("localityList").innerHTML=xmlhttp.responseText;
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}
function validateRooms() {
	var room_name = document.forms["addRooms"]["room_name"];
	if(room_name.value==null || room_name.value==""){
		alert("This field is required!");
		room_name.focus();
		return false;
	}
	var room_which_floor = document.forms["addRooms"]["room_which_floor"];
	if(room_which_floor.value==null || room_which_floor.value==""){
		alert("This field is required!");
		room_which_floor.focus();
		return false;
	}
	var room_details = document.forms["addRooms"]["room_rent"];
	if(room_rent.value==null || room_rent.value==""){
		alert("This field is required!");
		room_rent.focus();
		return false;
	}
	return true;
}
function validatePG() {
	var pg_name = document.forms["addPG"]["pg_name"];
	if(pg_name.value==null || pg_name.value==""){
		alert("This field is required!");
		pg_name.focus();
		return false;
	}
	var pg_phone = document.forms["addPG"]["pg_phone"];
	if(pg_phone.value==null || pg_phone.value==""){
		alert("This field is required!");
		pg_phone.focus();
		return false;
	}
	var pg_address = document.forms["addPG"]["pg_address"];
	if(pg_address.value==null || pg_address.value==""){
		alert("This field is required!");
		pg_address.focus();
		return false;
	}
	var pg_details = document.forms["addPG"]["pg_details"];
	if(pg_details.value==null || pg_details.value==""){
		alert("This field is required!");
		pg_details.focus();
		return false;
	}
	return true;
}
function validateOwner() {
	var owner_name = document.forms["ownerReg"]["owner_name"];
	if(owner_name.value==null || owner_name.value==""){
		alert("This field is required!");
		owner_name.focus();
		return false;
	}
	var owner_gender = document.forms["ownerReg"]["owner_gender"];
	if(owner_gender.value==null || owner_gender.value==""){
		alert("This field is required!");
		owner_gender.focus();
	    return false;
	}
	var perma_add = document.forms["ownerReg"]["perma_add"];
	if(perma_add.value==null || perma_add.value==""){
		alert("This field is required!");
		perma_add.focus();
	    return false;
	}
	var present_add = document.forms["ownerReg"]["present_add"];
	if(present_add.value==null || present_add.value==""){
		alert("This field is required!");
		present_add.focus();
	    return false;
	}
	var phone = document.forms["ownerReg"]["phone"];
	if(phone.value==null || phone.value==""){
		alert("This field is required!");
		phone.focus();
	    return false;
	}
	var mail_id = document.forms["ownerReg"]["mail_id"];
	if(mail_id.value==null || mail_id.value==""){
		alert("This field is required!");
		mail_id.focus();
	    return false;
	}
	var password_owner = document.forms["ownerReg"]["password_owner"];
	if(password_owner.value==null || password_owner.value==""){
		alert("This field is required!");
		password_owner.focus();
	    return false;
	}
	return true;
}
function getGuestDetails(ownerId, pgId, editInputGuestId, onlyDueGuest){
	var url="PopulateGuest?ownerId="+ownerId+"&pgId="+pgId+"&onlyDueGuest="+onlyDueGuest+"&editInputGuestId="+editInputGuestId;
	//alert(url);
	var xmlhttp = false;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	}
	else if (window.ActiveXObject){ 
		try {
			xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
		} 
		catch (e) {
			try{
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			catch (e){}
		}
	}
	else return false;
	
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            document.getElementById("getGuestDetails").innerHTML=xmlhttp.responseText;
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}
function getRoomDetails(pgId, ownerId){
	//alert(pgId);
	var url="PopulateRooms?ownerId="+ownerId+"&pgId="+pgId;
	var xmlhttp = false;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	}
	else if (window.ActiveXObject){ 
		try {
			xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
		} 
		catch (e) {
			try{
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			catch (e){}
		}
	}
	else return false;
	
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            document.getElementById("getRoomDetails").innerHTML=xmlhttp.responseText;
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}
function getBedDetails(pgId, ownerId){
	//alert(pgId);
	var url="PopulateBeds?ownerId="+ownerId+"&pgId="+pgId;
	var xmlhttp = false;
	if (window.XMLHttpRequest) {
		xmlhttp = new XMLHttpRequest();
	}
	else if (window.ActiveXObject){ 
		try {
			xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
		} 
		catch (e) {
			try{
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			catch (e){}
		}
	}
	else return false;
	
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            document.getElementById("getBedDetails").innerHTML=xmlhttp.responseText;
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}
</script>
</head>
<body>
<table border="0" align="center"><tr><td><div id="lv_left"><div id="lv_right"><div id="l_bottom">
<%@include file="pgowner/header.jsp" %>
<%@include file="pgowner/homeBody.jsp" %><div id="l_top">
<%@include file="users/footer.jsp" %></div>
</div></div></div>
</td></tr></table>
</body>
</html>
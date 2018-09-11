<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pghomes.openuser.PGDAO"%>
<%
int pgId = 1;
float latg = -31.78f;
float longg = 56.67f;
String pgIdInfo = request.getParameter("infoPGId");
if(pgIdInfo != null){
	pgId = Integer.parseInt(pgIdInfo);
}
ArrayList<String> list = PGDAO.getPGLatLong(pgId);
if(!list.isEmpty()){
	latg = Float.parseFloat(list.get(0));
	longg = Float.parseFloat(list.get(1));
}
//System.out.println(latg+"======="+longg);
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="description" content="PG Homes is an online PG help service committed towards helping you make wise and profitable decisions regarding PG advertising, booking, searching, managing, renting and leasing of PG homes in India">
<meta name="keywords" content="PG in Bangalore, Paying Guest in Bangalore, paying guest accommodations in bangalore, paying guest in bangalore for women, paying guest in bangalore for men, PG in Bangalore for men, PG in bangalore for women, pg for girls in bangalore, pg for boys in bangalore, PG in bangalore for Gents, PG in bangalore for ladies">
<meta name="author" content="PG Homes">
<meta name="robots" content="index, nofollow">
<meta name="Language" content="english" />
<title>PG Homes</title>
<link rel="shortcut icon" href="images/pg_homes.gif" />
<link rel="stylesheet" href="scripts/style.css" type="text/css" />
<script type="text/javascript" src="scripts/script.js"></script>
<style type="text/css">#l_top{border-top: 1px solid #aaa;)</style>
<style type="text/css">#lv_right{border-right: 1px solid #aaa;)</style>
<style type="text/css">#lv_left{border-left: 1px solid #aaa;)</style>
<style type="text/css">#l_bottom{border-bottom: 1px solid #aaa;)</style>
<script src="js/jquery-1.10.2.min.js"></script>
<script src="js/jquery.bxslider.min.js"></script>
<script>
$(document).ready(function(){
	  $('.bxslider').bxSlider();
	});
</script>
<link href="js/jquery.bxslider.css" rel="stylesheet" />
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/all.js#xfbml=1";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>
<style>
	html, body, #map-canvas {
	height: 100%;
    margin: 0px;
    padding: 0px
    }
</style>
<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
<script>
	var map;
	function initialize() {
	var latLng = new google.maps.LatLng(<%= latg %>, <%= longg %>);
  	var mapOptions = {
    	zoom: 8,
    	center: latLng
  		};
  	map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
  	geocoder = new google.maps.Geocoder();
  	marker = new google.maps.Marker({
    	position: latLng,
    	map: map
  		});
	}
	google.maps.event.addDomListener(window, 'load', initialize);
</script>
</head>
<body>
<table border="0" align="center"><tr><td><div id="lv_left"><div id="lv_right"><div id="l_bottom">
<%@include file="users/header.jsp" %>
<%@include file="users/homeBody.jsp" %><div id="l_top">
<%@include file="users/footer.jsp" %></div>
</div></div></div>
</td></tr></table>
</body>
</html>
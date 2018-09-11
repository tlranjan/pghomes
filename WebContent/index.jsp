<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-48136309-1', 'pghomesindia.com');
  ga('send', 'pageview');

</script>
<script type="text/javascript" src="scripts/script.js"></script>
<script type="text/javascript">
function getSearchParams(){
	var searchCriteria = "";
	var formCity = document.getElementById("formCity");
	for(i = 0; i < formCity.cities.length; i++){
		if(formCity.cities[i].checked){
			searchCriteria = searchCriteria+"&cities="+formCity.cities[i].value;
		}
	}
	var formLocality = document.getElementById("formLocality");
	for(i = 0; i < formLocality.localities.length; i++){
		if(formLocality.localities[i].checked){
			searchCriteria = searchCriteria+"&localities="+formLocality.localities[i].value;
		}
	}
	var formRents = document.getElementById("formRents");
	for(i = 0; i < formRents.rentranges.length; i++){
		if(formRents.rentranges[i].checked){
			searchCriteria = searchCriteria+"&rentranges="+formRents.rentranges[i].value;
		}
	}
	var formShare = document.getElementById("formShare");
	for(i = 0; i < formShare.shareTypes.length; i++){
		if(formShare.shareTypes[i].checked){
			searchCriteria = searchCriteria+"&shareTypes="+formShare.shareTypes[i].value;
		}
	}
	var formGender = document.getElementById("formGender");
	for(i = 0; i < formGender.gender.length; i++){
		if(formGender.gender[i].checked){
			searchCriteria = searchCriteria+"&gender="+formGender.gender[i].value;
		}
	}
	searchCriteria = searchCriteria.substring(1, searchCriteria.length);
	//alert(searchCriteria);
    var url="users/populateSearchParams.jsp?"+searchCriteria;
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
            document.getElementById("searchFor").innerHTML=xmlhttp.responseText;
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}
function getPGCountList(searchPageNo){
	var searchCriteria = "";
	var formCity = document.getElementById("formCity");
	for(i = 0; i < formCity.cities.length; i++){
		if(formCity.cities[i].checked){
			searchCriteria = searchCriteria+"&cities="+formCity.cities[i].value;
		}
	}
	var formLocality = document.getElementById("formLocality");
	for(i = 0; i < formLocality.localities.length; i++){
		if(formLocality.localities[i].checked){
			searchCriteria = searchCriteria+"&localities="+formLocality.localities[i].value;
		}
	}
	var formRents = document.getElementById("formRents");
	for(i = 0; i < formRents.rentranges.length; i++){
		if(formRents.rentranges[i].checked){
			searchCriteria = searchCriteria+"&rentranges="+formRents.rentranges[i].value;
		}
	}
	var formShare = document.getElementById("formShare");
	for(i = 0; i < formShare.shareTypes.length; i++){
		if(formShare.shareTypes[i].checked){
			searchCriteria = searchCriteria+"&shareTypes="+formShare.shareTypes[i].value;
		}
	}
	var formGender = document.getElementById("formGender");
	for(i = 0; i < formGender.gender.length; i++){
		if(formGender.gender[i].checked){
			searchCriteria = searchCriteria+"&gender="+formGender.gender[i].value;
		}
	}
	searchCriteria = searchCriteria+"&searchPageNo="+searchPageNo;
	searchCriteria = searchCriteria.substring(1, searchCriteria.length);
	//alert(searchCriteria);
    var url="PopulatePGCountList?"+searchCriteria;

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
            document.getElementById("pgResultCountUpper").innerHTML=xmlhttp.responseText;
            document.getElementById("pgResultCountLower").innerHTML=xmlhttp.responseText;
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}
function getPGList(searchPageNo){
	var searchCriteria = "";
	var formCity = document.getElementById("formCity");
	for(i = 0; i < formCity.cities.length; i++){
		if(formCity.cities[i].checked){
			searchCriteria = searchCriteria+"&cities="+formCity.cities[i].value;
		}
	}
	var formLocality = document.getElementById("formLocality");
	for(i = 0; i < formLocality.localities.length; i++){
		if(formLocality.localities[i].checked){
			searchCriteria = searchCriteria+"&localities="+formLocality.localities[i].value;
		}
	}
	var formRents = document.getElementById("formRents");
	for(i = 0; i < formRents.rentranges.length; i++){
		if(formRents.rentranges[i].checked){
			searchCriteria = searchCriteria+"&rentranges="+formRents.rentranges[i].value;
		}
	}
	var formShare = document.getElementById("formShare");
	for(i = 0; i < formShare.shareTypes.length; i++){
		if(formShare.shareTypes[i].checked){
			searchCriteria = searchCriteria+"&shareTypes="+formShare.shareTypes[i].value;
		}
	}
	var formGender = document.getElementById("formGender");
	for(i = 0; i < formGender.gender.length; i++){
		if(formGender.gender[i].checked){
			searchCriteria = searchCriteria+"&gender="+formGender.gender[i].value;
		}
	}
	searchCriteria = searchCriteria+"&searchPageNo="+searchPageNo;
	searchCriteria = searchCriteria.substring(1, searchCriteria.length);
	//alert(searchCriteria);
    var url="PopulatePGList?"+searchCriteria;
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
            document.getElementById("loadSearchedContent").innerHTML=xmlhttp.responseText;
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}
function getLocalityList(){
	var searchCriteria = "";
	var formCity = document.getElementById("formCity");
	for(i = 0; i < formCity.cities.length; i++){
		if(formCity.cities[i].checked){
			searchCriteria = searchCriteria+"&cities="+formCity.cities[i].value;
		}
	}
	searchCriteria = searchCriteria.substring(1, searchCriteria.length);
	//alert(searchCriteria);
    var url="PopulateLocality?"+searchCriteria;
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
            document.getElementById("loadLocalities").innerHTML=xmlhttp.responseText;
        }
    };
    xmlhttp.open("GET", url, true);
    xmlhttp.send();
}
</script>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/all.js#xfbml=1";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
<script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+'://platform.twitter.com/widgets.js';fjs.parentNode.insertBefore(js,fjs);}}(document, 'script', 'twitter-wjs');</script>
<style type="text/css">#l_top{border-top: 1px solid #aaa;)</style>
<style type="text/css">#lv_right{border-right: 1px solid #aaa;)</style>
<style type="text/css">#lv_left{border-left: 1px solid #aaa;)</style>
<style type="text/css">#l_bottom{border-bottom: 1px solid #aaa;)</style>
</head>
<body>
<table border="0" align="center"><tr><td><div id="lv_left"><div id="lv_right"><div id="l_bottom">
<%@include file="users/header.jsp" %>
<%@include file="users/body.jsp" %><div id="l_top">
<%@include file="users/footer.jsp" %></div>
</div></div></div>
</td></tr></table>
</body>
</html>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Edifyer: ${theCompany.name}</title>
  
  <!--  There are so many style sheet links idk which ones are relevant  -->
  <link rel="icon" href="${pageContext.request.contextPath}/resources/img/icon.png">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
  <link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/templatestyle.css" /> 
  <%-- <link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/search.css" />	  --%> 
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <style>
  .ui-autocomplete-loading {
    background: white url("images/ui-anim_basic_16x16.gif") right center no-repeat;
  }
  </style>
	<script type="text/javascript">
		$(function() {
			$("#companyName").autocomplete({
				source: "company/search", 
				minLength: 3,//tb to when you lot were havin a laugh bout my slow search
				select: function(event, ui) {
					this.value = ui.item.label;
					return false;
				}
			});

		});
	</script>

</head>
<body onload= "startStop()">
<!-- partial:index.partial.html -->
<div class="header">
<div class="backhome"><form method="get" action="back"><button type="submit" class="btn-link"><h2 id="home">Edifyer</h2></button></form></div>
<div class="pagesearch">
    <form action="find" method="get">
    	<input autofocus placeholder="Enter a company" class="form-control" type="text" autocomplete="off" name="company" id="companyName"/>
    	<!-- -9999px to remove it from the screen, user can just press enter -->
    	<button type="submit" style="position: absolute; left:-9999px"></button>
        <ul class="list-group" id="list"></ul>
  </form>
  </div>
  </div>

  
<div id="hidden-score">${theCompany.ratings[0].sdrate}</div> 

<div id="wrapdisplay">
	<div id="display">0</div>
</div>
 


<h1 id="companyname">
  ${theCompany.name}
  </h1>
  <p id="wordedresult"></p>

  
  
    
<div class="encapsulateProgress">
<svg
   class="progress-ring"
   width="600"
   height="600">
   
  <circle
    class="progress-ring__circle"
    stroke="#9DB68C"
    stroke-width="20"
    fill="transparent"
    r="180"
    cx="400"
    cy="200"/>
    
</svg>
</div>

<!-- partial -->
  <script  src="${pageContext.request.contextPath}/resources/js/animation-script.js"></script>
  <div class="footer">
  <div class="footer">
	<div id="outer">
  		<div class="inner"><form method="get" action="how"><button type="submit" class="btn-link">How It Works?</button></form></div>
  		<div class="inner"><form method="get" action="about"><button type="submit" class="btn-link">About Us</button></form></div>
  	</div>
</div>
  </div>
</body>
</html>
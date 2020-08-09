<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html xmlns:th="http://wwww.thymeleaf.org">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/search.css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>How We Rate</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>

<div class="header">
  <div class="headings">
  <h2 id="home">How We Rate</h2>
  <p id="tagline">We analyse companies to help you consume responsibly</p>
  
  <!-- Put the list of the sources here:  -->
  <br>
  <h3>Our sources of information: </h3>
  <ul class="oval">
  <c:forEach var="tempSource" items="${theSources}">	
  	<li><a href=${tempSource.homeLink}>${tempSource.name}</a></li>
  </c:forEach>
  </ul>

  </div>
</div>

</body>
</html>
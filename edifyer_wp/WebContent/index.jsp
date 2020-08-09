<!DOCTYPE html>
<html xmlns:th="http://wwww.thymeleaf.org">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/search.css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Edifyer</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

  
  <style>
  .ui-autocomplete-loading {
    background: white url("images/ui-anim_basic_16x16.gif") right center no-repeat;
  }
  </style>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#companyName").autocomplete({
				source: "company/search", 
				minLength: 3,
				select: function(event, ui) {
					this.value = ui.item.label;
				}
			});

		});
	</script>
</head>
<body>

<div class="header">
  <div class="headings">
  <h2 id="home">Edifyer</h2>
  <p id="tagline">We analyse companies to help you consume responsibly</p>
  </div>
  <form action="find" method="get">
    	<input autofocus placeholder="Enter a company to find out how ethical it is" class="form-control" type="text" autocomplete="off" name="company" id="companyName"/>
    	<button type="submit" class="btn button btn"><i class="fas fa-pencil-alt" aria-hidden="true"></i>Search</button>
        <ul class="list-group" id="list"></ul>
  </form>
</div>

<div class="footer">
	<div id="outer">
  		<div class="inner"><form method="get" action="how"><button type="submit" class="btn-link">How It Works?</button></form></div>
  		<div class="inner"><form method="get" action="about"><button type="submit" class="btn-link">About Us</button></form></div>
  	</div>
</div>

</body>
</html>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Edifyer: ${theCompany.name}</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
  <link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/templatestyle.css" /> 
  <link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/search.css" />	  
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
				minLength: 2,
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
<div class="title">
  <a id= "home-link" href="index.jsp">
  <h2 id="home">Edifyer</h2></a>
  </div>
    <form action="find" method="get">
    	<input autofocus placeholder="Enter another company to get an ethics rating" class="form-control" type="text" autocomplete="off" name="company" id="companyName"/>
    	<button type="submit" style="position: absolute; left:-9999px"></button>
        <ul class="list-group" id="list"></ul>
  </form>
  </div>

  
<div id="hidden-score">${theCompany.ratings[0].sdrate}
</div>
<div id="wrapdisplay">
<div id="display">0</div></div>
 

<h1 id="companyname">
  ${theCompany.name}
  </h1>
  <p id="wordedresult"></p>
  <?php 
    $filename = 'companyratings.csv';

    // The nested array to hold all the arrays
    $the_big_array = []; 
    
    // Open the file for reading
    if (($h = fopen("{$filename}", "r")) !== FALSE) 
    {
      // Each line in the file is converted into an individual array that we call $data
      // The items of the array are comma separated
      while (($data = fgetcsv($h, 1000, ",")) !== FALSE) 
      {
        // Each individual array is being pushed into the nested array
        $the_big_array[] = $data;		
      }
    
      // Close the file
      fclose($h);
    }
    
  ?>
  <script>
      //var peeps = "<php echo $namey?>";
  //console.log(peeps);
  //document.getElementById('home').innerHTML = peeps;
  var companyscorearray = <?php echo json_encode($the_big_array); ?>;
  //const companyName = <php echo $name; ?>;
  var passedArray = <?php echo json_encode($the_big_array); ?>;
    </script>
    <script src="${pageContext.request.contextPath}/resources/js/search.js"></script>
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
  <a class="links" href="howitworks.html">How it works?</a>&emsp;&emsp;&emsp;&emsp;<a class="links" href="aboutus.html">About Us</a>
</div>
</body>
</html>
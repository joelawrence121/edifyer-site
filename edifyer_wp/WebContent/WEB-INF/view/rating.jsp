<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Edifyer: ${theCompany.name}</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
	<!-- <link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/templatestyle.css" /> -->
	<style>
	/*html,
body {
  background-color: #2962FF;
  display: -webkit-box;
  display: flex;
  -webkit-box-align: center;
          align-items: center;
  -webkit-box-pack: center;
          justify-content: center;
  height: 100%;
  position: relative;
}*/
.progress-ring__circle {
  -webkit-transition: 0.35s stroke-dashoffset;
  transition: 0.35s stroke-dashoffset;
  -webkit-transform: rotate(-90deg);
          transform: rotate(-90deg);
  -webkit-transform-origin: 50% 50%;
          transform-origin: 50% 50%;
}

#hidden-score {
	display: none;
	color: red;
}
.encapsulateProgress {
	text-align: center;
	border: 1px black solid;
}
.progress-ring {
		/* display: block;
		margin: auto; */
        /* position: absolute;
        top: 200px;
        left:35vw; */
        display: inline-block;
        margin-left: 225px;
        
        
}
#wrapdisplay {
	position: absolute;
	top: 245px;
    left: 50%;
    
    margin-left: -50px;
	
}
#display {
        /* position: absolute;
        top: 330px;
        left: 45vw; */
        text-align: center;
		
        font-size: 125px;
        color: #ff4c4c;
        /* z-index: 1; */
}
#companyname {
  top: 20px;
  left: -20px;
  position: relative;
  text-align: center;
  font-size: 80px;
  padding: 0;
  margin: 0;
}
*{margin: 0; padding: 0; border: 0; outline: 0;}

  body {
    font-family: Arial;
    padding: 20px;
    background: white;
    color: #05386b;
  }
  
  .header {
    padding: 0px;
    font-size: 20px;
    text-align: center;
    position: fixed;
    top: 0;
    z-index: 3;
    
  }

.title {
  position: fixed;
  left: 34vw;
}

#home {
  font-size: 30px;
}
  
  

  #tagline {
    color: grey;
    font-size: 0.5em;
    margin: 0;
    padding: 0;
  }

  /* Clear floats after the columns */
 .input-group {
  width: 400px;
  margin: auto;
  position: fixed;
  left: 41vw;
  top:0.5vh;
  
  
 }
 .insearch {
   width: 100%;
 }
  .form-control {
    width: 100%;
    height: 35px;
  }
  .suggestdiv {
    width: 100%;
    margin: auto;
  }
  
  .list-group {
    list-style-type:none;
    margin: 0;
  padding: 0;
  }
  .dropdown {
    width: 100%;
    height: 60px;
    text-align: left;
    font-size: 0.75em;
    opacity: 0.9;
    cursor: pointer;
  }
 .dropdown:hover{
   background-color: #cccccc;
 }
  /* Footer */
  .footer {
    position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
   background-color: red;
   color: white;
   text-align: center;
  }
  
  .links {
    color: white;
  }
  /* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other */
  
	</style>

</head>
<body onload= "startStop()">
<!-- partial:index.partial.html -->
<div class="header">
<div class="title">
  <a id= "home-link" href="index.php">
  <h2 id="home">Edifyer</h2></a>
  </div>
  <div class="input-group">
    <div class="insearch">
    <input autofocus placeholder="Enter a company to find out how ethical it is" class="form-control" type="text" autocomplete="off" name="search" id="search"/>
    </div>
    <div class="suggestdiv">
    <ul class="list-group" id="list"></ul>
    </div>
  </div>
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
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Edifyer: <?php
  $name = $_GET["companyname"]; 
  echo $name; 
  ?></title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="css/templatestyle.css">

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
  

  
<div id="display">
  0
</div>
<h1 id="companyname">
  <?php
      
      echo $name;
  ?>
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
    <script src="scripts/search.js"></script>
<svg
   class="progress-ring"
   width="600"
   height="600">
   
  <circle
    class="progress-ring__circle"
    stroke="#9DB68C"
    stroke-width="40"
    fill="transparent"
    r="180"
    cx="400"
    cy="200"/>
    
</svg>



<!-- partial -->
  <script  src="scripts/templatescript.js"></script>
  <div class="footer">
  <a class="links" href="howitworks.html">How it works?</a>&emsp;&emsp;&emsp;&emsp;<a class="links" href="aboutus.html">About Us</a>
</div>
</body>
</html>

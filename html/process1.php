<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>C</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="css/templatestyle.css">

</head>
<body onload= "startStop()">
<!-- partial:index.partial.html -->
<div class="header">
  <h2 id="home">Edifyer</h2>
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
      $name = $_POST["companyname"];
      echo $name;
  ?>
  </h1>
  <?php 
    $filename = 'examplecompanies.csv';

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
    <script src="scripts/search1.js"></script>
<svg
   class="progress-ring"
   width="600"
   height="600">
   
  <circle
    class="progress-ring__circle"
    stroke="green"
    stroke-width="20"
    fill="transparent"
    r="100"
    cx="400"
    cy="200"/>
    
</svg>



<!-- partial -->
  <script  src="scripts/templatescript.js"></script>

</body>
</html>

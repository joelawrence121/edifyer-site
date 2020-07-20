<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/search.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Edifyer</title>
</head>
<body>
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
    
    // Display the code in a readable format
    
    
    ?>
<div class="header">
  <div class="headings">
  <h2 id="home">Edifyer</h2>
  <p id="tagline">We analyse companies to help you consume responsibly</p>
  </div>
  <div class="input-group">
    <div class="insearch">
    <input autofocus placeholder="Enter a company to find out how ethical it is" class="form-control" type="text" autocomplete="off" name="search" id="search"/>
    </div>
    <div class="suggestdiv">
    <ul class="list-group" id="list"></ul>
    </div>
  </div>
  

    <script>
      //var peeps = "<php echo $namey?>";
  //document.getElementById('home').innerHTML = peeps;
  var passedArray = <?php echo json_encode($the_big_array); ?>;
    </script>
    <script src="scripts/search.js"></script>
</div>


</div>

<div class="footer">
  <a class="links" href="howitworks.html">How it works?</a>&emsp;&emsp;&emsp;&emsp;<a class="links" href="aboutus.html">About Us</a>
</div>

</body>
</html>

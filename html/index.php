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
    
    // Display the code in a readable format
    
    
    ?>
<div class="header">
  <h2 id="home">Homepage</h2>
  <div class="input-group">
    <div class="input-group-prepend">
      <span class="input-group-text">
        <span class="fa fa-search"></span>
      </span>
    </div>
    <input autofocus placeholder="search" class="form-control" type="text" autocomplete="off" name="search" id="search"/>
    
  </div>
  <ul class="list-group" id="list"></ul>

    <script>
      //var peeps = "<php echo $namey?>";
  //console.log(peeps);
  //document.getElementById('home').innerHTML = peeps;
  var passedArray = <?php echo json_encode($the_big_array); ?>;
  console.log(passedArray);
    </script>
    <script src="scripts/search.js"></script>
</div>

<div class="row">
  <div class="leftcolumn">
   
  </div>
  <div class="rightcolumn">
    <div class="card">
      
    </div>
    </div>
    
    
  </div>
</div>

<div class="footer">
  
</div>

</body>
</html>

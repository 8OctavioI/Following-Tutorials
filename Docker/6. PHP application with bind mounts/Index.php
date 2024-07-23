<html lang="en">
  <head>
    <meta charset="utf-8">    
    <meta name="description" content="List of courses">    
    <link href="./lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>Courses</title>
</head>
<body>
<?php 
$fileptr = fopen("Courses.txt", "r"); 
?>
    <div class="container-sm">

      <h1>Courses</h1>
      <p class="lead">List of Courses</p>
    

    <table class="table table-striped table-bordered">
        <thead class="table-dark">
          <tr>
            <th class="th-sm" scope="col">Course Name</th>                
          </tr>
        </thead>
        <?php             
                while(!feof($fileptr)) { 
            ?>
        <tbody>
          <tr>
            <th scope="row"><?php echo fgets($fileptr);?></th>                    
          </tr>          
        </tbody>
        <?php
                }
            ?>
      </table>
    </div>
</body>
</html>


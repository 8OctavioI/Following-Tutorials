<html lang="en">
  <head>
    <meta charset="utf-8">    
    <meta name="description" content="Displaying list of courses">    
    <link href="./lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>List of Courses</title>
</head>
<body>
<?php
   $host_name = '172.17.0.2';
   $user = 'root';
   $password = '1234';
   $database='appdb';
   $connection = new mysqli($host_name, $user, $password,$database);
   
   if($connection) {
    $statement = " SELECT CourseID,CourseName,Rating FROM Course ";
    $records = $connection->query($statement);
    $connection->close();
   }
   
   ?>
    <div class="container-sm">

      <h1>Courses</h1>
      <p class="lead">This is a list Courses</p>
    

    <table class="table table-striped table-bordered">
        <thead class="table-dark">
          <tr>
            <th class="th-sm" scope="col">Course ID</th>
            <th class="th-sm" scope="col">Course Name</th>
            <th class="th-sm" scope="col">Rating</th>            
          </tr>
        </thead>
        <?php             
                while($data=$records->fetch_assoc())
                {
            ?>
        <tbody>
          <tr>
            <th scope="row"><?php echo $data['CourseID'];?></th>
            <td><?php echo $data['CourseName'];?></td>
            <td><?php echo $data['Rating'];?></td>            
          </tr>          
        </tbody>
        <?php
                }
            ?>
      </table>
    </div>
</body>
</html>


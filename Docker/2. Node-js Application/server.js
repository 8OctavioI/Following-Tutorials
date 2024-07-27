var http = require("http");




http.createServer(function (request, response) {    
    let ts = Date.now();
    
    let date_ob = new Date(ts);
    let date = date_ob.getSeconds();
    let month = date_ob.getMinutes();
    let year = date_ob.getHours();
    response.writeHead(200, {'Content-Type': 'text/plain'});
    response.end('Hello, We are running from within a container\n' + 'The time is: ' + year + "-" + month + "-" + date);
    console.log('The server is running from within a container for ');

 }).listen(80);
 
  
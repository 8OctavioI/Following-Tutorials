var http = require("http");

http.createServer(function (request, response) {    
    response.writeHead(200, {'Content-Type': 'text/plain'});
     
    response.end('We are running from within a container\n');
    console.log('The server is running from within a container');
 }).listen(80);
 
  
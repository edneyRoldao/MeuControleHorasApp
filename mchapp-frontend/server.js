var http = require('http');
var app = require('./config/express')();

http.createServer(app).listen(app.get('port'), function() {
	console.log('MeuControleHoras frontend is listening to the port: ' + app.get('port'));
});

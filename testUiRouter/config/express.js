var express = require('express');

module.exports = function() {
	var app = express();

	app.use(express.static('./public'));
	app.set('port', 3002);

	return app;
};
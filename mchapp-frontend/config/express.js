var express = require('express');

module.exports = function() {
	var app = express();

	app.use(express.static('./app'));
	app.set('port', 3030);

	return app;
};
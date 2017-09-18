var React = require('react');
var ReactDOM = require('react-dom');
var App = require('./components/App');
var fetch = require('whatwg-fetch');

ReactDOM.render(
    <App/>,
    document.getElementById('app')
);
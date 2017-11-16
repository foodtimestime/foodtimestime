var React = require('react');
var ReactDOM = require('react-dom');
var App = require('./components/landingSearch');
var fetch = require('whatwg-fetch');

ReactDOM.render(
    <App/>,
    document.getElementById('landing-search')
);
var React = require('react');

var foodName = "FOOD";

class HelloMessage extends React.Component {
    render() {
        return <div className={'hello'}>
            <h4>today you should eat:</h4>
            <h1>{foodName}</h1>
        </div>;
    }
}

module.exports = HelloMessage;
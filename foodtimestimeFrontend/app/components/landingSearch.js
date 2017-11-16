var React = require('react');

var url = 'http://localhost:5678/api/v1/random'

class HelloMessage extends React.Component {
    constructor() {
        super();
        this.state = {foodName: "..."};
    }

    componentDidMount() {
        this.fetchRandomMealName(this);
    }

    fetchRandomMealName(dis) {
        fetch(url, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            credentials: "same-origin"
        })
            .then(response => response.text())
            .then(function(parsedData) {
                dis.setState({foodName: parsedData})
        });
    }

    render() {
        return <div className={'hello'}>
            <h4>today you should eat:</h4>
            <h1>{this.state.foodName}</h1>
        </div>;
    }
}

module.exports = HelloMessage;
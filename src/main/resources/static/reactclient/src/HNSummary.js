import React, {Component} from 'react';

class HNSummary extends Component {

	constructor(props) {
		super(props);

		this.state = {
			title: null,
			url: null
		}
	}

	componentDidMount() {
		
		fetch("/api/" + this.props.item).then(function(response) {
			return response.json();
		}).then((respJson) => {
			this.setState({title: respJson['title']});
			this.setState({url: respJson['url']});
		});

	}

    render() {
        return (
            <div>
                <p>{this.state.title} {this.state.url}</p>
            </div>
        );
    }
}

export default HNSummary;
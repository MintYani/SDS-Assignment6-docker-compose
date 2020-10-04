import React from 'react';
import './App.css';

class App extends React.Component {
  constructor(props){
    super(props)
    this.state = {
      input: "",

    };
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleChange = this.handleChange.bind(this);
  }
  render(){
    return (
      <div className="App">
        <form onSubmit={(event) => this.handleSubmit(event)}>
          <input value={this.state.input} onChange={(event) => this.handleChange(event)} placeholder="enter your name"></input>
          <button>submit</button>
        </form>
      </div>
    );
  }

  handleChange(event){
    const target = event.target;
    this.setState({
      input:target.value
    });
  }
  async handleSubmit(event){
    event.preventDefault();
    const name = this.state.input;
    const URL = "http://localhost:8080/user";
    const response = await fetch(URL, {
      method: "POST",
      mode: "cors",
      cache: "no-cache",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ name }),
    });
    console.log(response.status);
    if (response.status === 500) return response.json();
    if (response.status === 200) return response.json();
  }
}

export default App;

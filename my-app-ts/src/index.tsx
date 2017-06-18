import * as React from 'react';
import {render} from 'react-dom';

export interface AppProps {
    value: string;
}       

class App extends React.Component < AppProps, {} > {

    public state: any;
    public idx: number;
    public arrayList: Array<any>;
    public value: string;

    constructor(props: AppProps) {
        super(props);
        this.state = {
            idx: 0,
            seq: 1,
            value: '',
            arrayList: []
        }
        this.arrayList = [];
    }

    addHandleUpdate(e: any) {
        let array = this.arrayList;
        let index = e.target.value-1;
        let inputEl = ( 
            <div key={index+1}>
                {this.value}{index+1}
                <button value={index+1} onClick={this.addHandleDelete.bind(this)}>Del</button>
                <button value={index+1} onClick={this.addHandleUpdate.bind(this)}>update</button>
            </div>
        );
        array[index] = inputEl;
        this.setState({ arrayList: array});
    }

    addHandleDelete(e: any) {
        let array = this.arrayList;
        let index = this.arrayList.indexOf(e.target.value-1);
        array.splice(index, 1);
        let seq = this.state.seq - 1;
        this.setState({ arrayList: array, seq: seq});
    }

    addHandle(e: any) {
        this.idx = this.state.idx + 1;
        let inputEl = (
            <div key={this.idx}>
                {this.value}{this.idx}
                <button value={this.idx} onClick={this.addHandleDelete.bind(this)}>Del</button>
                <button value={this.idx} onClick={this.addHandleUpdate.bind(this)}>update</button>
            </div>
        );
        this.arrayList.push(inputEl);
        let seq = this.state.seq + 1;
        this.setState({idx: this.idx, 
            value: this.value, 
            arrayList: this.arrayList,
            seq: seq
        });
        
    }

    changeHandle(e: any) {
        this.value = e.target.value;
        this.setState({value: e.target.value});

    }

    handleKeyPress(e: any) {
        if (e.key === 'Enter') {
            console.log('do validate');
            this.addHandle(e);
        }
    }


    render() {
        
        return (
            <div>
                <p>TODO LIST => [SEQ:{this.state.seq}][INPUT:{this.props.value}] </p>
                <p>
                    이름:<input type="text" value={this.state.value} onKeyPress={this.handleKeyPress.bind(this)} onChange={this.changeHandle.bind(this)}/> 
                    <button onClick={this.addHandle.bind(this)}>이름입력</button>
                    전화번호:<input type="text" value={this.state.value} onKeyPress={this.handleKeyPress.bind(this)} onChange={this.changeHandle.bind(this)}/> 
                    <button onClick={this.addHandle.bind(this)}>전화번호입력</button>
                </p>
                {this.state.arrayList}
            </div>
        );
    }
}

export default App;

render(<App value={'mr.kim'}/>, document.getElementById('root'));

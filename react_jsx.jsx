// react 만들기 
import React, {Component} from 'react';

function Input () {

    function handlerChange () {
        console.log();
    }
    var styles = {
        margin: '5px'
    }
    return (
        <div style={styles}>
            <p>인풋이나 입력을 요구하는 태그는 function을 쓰면 안됨.</p>
            <button> 입력 </button>
        </div>
    )
}

class Tab extends Component {
    render() {
        return (
            <div>
                <p>tab select...!</p>
            </div>
        );
    }
}

export default Tab;
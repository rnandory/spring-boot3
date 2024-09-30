class Calc extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            x:0,
            y:0,
            result:0
        };
    }

    xInputHandler() {

    }
    yInputHandler(e) {        
        this.setState({y:parseInt(e.target.value)});        
    }
    calcHandler() {

    }
    
    render() {      
        return <div>
                <section id="calc" class="n-frame:rounded-shadow w:2/3">
                    <h1>계산기</h1>
                    <form class="n-form">
                        <div>
                            <label>
                                <span>X:</span>
                                <input onChange={e=>{this.setState({x:parseInt(e.target.value)})}} type="text" value={this.state.x} class="text-align:right"/>
                            </label>
                        </div>
                        <div>
                            <label>
                                <span>Y:</span>
                                <input onChange={this.yInputHandler.bind(this)} type="text" value={this.state.y} class="text-align:right"/>
                            </label>
                        </div>
                        <div>
                            <input onClick={(e) => {
                                e.preventDefault();
                                let x = this.state.x;
                                let y = this.state.y;
                                console.log(x+y);
                                let result = x+y;
                                this.setState({result});
                            }} class="n-btn n-btn-color:main" type="submit" value="계산하기"/>
                        </div>
                        <div>
                            <label>
                                <span>Result:</span>
                                <input type="text" value={this.state.result} readonly dir="rtl"/>
                            </label>
                        </div>
                    </form>
                </section>
            </div>
    }
}

ReactDOM.render(<Calc/>, document.getElementById("root"));
class Calc extends React.Component {
    render() {
        return <div>
                <section id="calc" class="n-frame:rounded-shadow w:2/3">
                    <h1>계산기</h1>
                    <form class="n-form">
                        <div>
                            <label>
                                <span>X:</span>
                                <input type="text" class="text-align:right"/>
                            </label>
                        </div>
                        <div>
                            <label>
                                <span>Y:</span>
                                <input type="text" class="text-align:right"/>
                            </label>
                        </div>
                        <div>
                            <input class="n-btn n-btn-color:main" type="submit" value="계산하기"/>
                        </div>
                        <div>
                            <label>
                                <span>Result:</span>
                                <input type="text" readonly dir="rtl"/>
                            </label>
                        </div>
                    </form>
                </section>
            </div>
    }
}

ReactDOM.render(<Calc/>, document.getElementById("root"));
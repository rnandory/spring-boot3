function sum(x,y) {
    return x+y;
}

var x = 1;
var y = 2;

exports.sum = sum;
exports.x = x;
exports.y2 = y;



function Calc() {

}

Calc.prototype.calc = function(x, y) {
    return x+y;
}

exports.Calc = Calc;
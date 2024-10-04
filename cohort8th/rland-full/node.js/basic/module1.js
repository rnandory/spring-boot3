import exam from './exam.js';

export default function() {
    console.log("module1 func");
    exam.kor = 100;
};

function f2() {
    console.log("module1 func2");    
}

function f3() {
    console.log("module1 func3");    
}

export {f2, f3}
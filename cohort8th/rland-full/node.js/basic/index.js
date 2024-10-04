// ESM(ECMAScript Modules)
import test, {f2 as aa, f3} from './module1.js';
import exam1, {Exam} from './exam.js';

test();
f3();
aa();

let exam = new Exam();
exam.kor = 30;
console.log(exam.total());

console.log(exam1.total());
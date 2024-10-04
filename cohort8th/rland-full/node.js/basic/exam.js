class Exam {
    #kor;
    constructor() {
        this.#kor=0;
        this.eng=0;
    }

    total() {
        return this.#kor + this.eng;
    }

    set kor(kor) {
        this.#kor = kor;
    }
}

let exam = new Exam();
exam.kor = 50;

export {Exam}
export default exam;
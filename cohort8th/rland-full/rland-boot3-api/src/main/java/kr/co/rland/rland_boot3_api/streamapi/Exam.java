package kr.co.rland.rland_boot3_api.streamapi;

public class Exam implements Comparable<Exam> {
    private int kor;
    private int eng;
    private int math;

    public Exam() {
    }

    public Exam(int kor, int eng, int mat) {
        this.kor = kor;
        this.eng = eng;
        this.math = mat;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int total() {
        return kor + eng + math;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "kor=" + kor +
                ", eng=" + eng +
                ", mat=" + math +
                '}';
    }

    @Override
    public int compareTo(Exam exam) {
        // this vs exam
        return this.total() - exam.total();
    }

    public static Exam of(String line) {
        String[] tokens = line.split(",");
        int kor = Integer.parseInt(tokens[0]);
        int eng = Integer.parseInt(tokens[1]);
        int math = Integer.parseInt(tokens[2]);
        return new Exam(kor, eng, math);
    }
}

package com.newlecture.web.cohort8th.java.exception;

public class Calc {
    public static int add(int a, int b) {
        return a + b;
    }


    public static int sub(int a, int b) throws 음수가되는Exception, 매개변수가10000을넘는Exception {

        int result = a - b;

        if (a > 10000)
            throw new 매개변수가10000을넘는Exception();

        if (result < 0)
            throw new 음수가되는Exception();

        return result;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {



        return a / b;
    }

}

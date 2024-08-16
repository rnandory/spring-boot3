package com.newlecture.web.cohort8th.java.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class App {
    public static void main(String[] args) {

        try(
            FileInputStream fis = new FileInputStream("");
            FileOutputStream fos = new FileOutputStream("");
                ) {
            fis.read();
//            fis.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
//        finally {
//            try {
//                fis.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }





        System.out.println(Calc.add(20, 30));

//        try {
//            System.out.println(Calc.sub(20, 30));
//        } catch (음수가되는Exception e) {
//            System.out.println(e.getMessage());
//        } catch (매개변수가10000을넘는Exception e) {
//            throw new RuntimeException(e);
//        }


        System.out.println("프로그램 끝부분");

    }
    }
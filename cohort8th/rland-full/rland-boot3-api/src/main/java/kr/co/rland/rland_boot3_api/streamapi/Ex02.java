package kr.co.rland.rland_boot3_api.streamapi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Ex02 {
    public static void main(String[] args) throws IOException {
        int[] ages = {10, 20, 30, 43, 23, 45, 12, 32, 42};

        IntStream stream = IntStream.of(ages);

        int[] result = stream
                .filter(a -> a > 20)
                .sorted()
                .map(a -> a / 10 * 10)
                .toArray();

        System.out.println(Arrays.toString(result));


        // 파일 내용 읽어와서 List로 만들기
//        List<Exam> exams =
        OptionalInt max =
                Files
                        .lines(Path.of("exams.txt"))
                        .skip(1) // caption 스킵
                        .map(Exam::of) // String -> Exam
//                        .filter(e -> e.total() <= 100)
//                .count();
                        .mapToInt(exam -> exam.getKor())
//                        .sum();
                        .max();

//                .sorted(Exam::compareTo)
//                .forEach(System.out::println);
//                .forEach(exam -> System.out.println(exam.total()));
//                .toList();
//
//        System.out.println(exams);

//        max.isEmpty();
//        max.orElse(100);
        System.out.println(max.getAsInt());
    }
}

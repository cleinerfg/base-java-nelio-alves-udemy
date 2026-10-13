package org.example.summary.generics.boundedwildcard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetPutPrinciple {
    static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubles = Arrays.asList(4.35, 3.14, 5.7);
        List<Object> objects = new ArrayList<>();

        copy(integers, objects);
        print(objects);
        copy(doubles, objects);
        print(objects);
    }

    public static void copy(List<? extends Number> source, List<? super Number> target) {
        for (Number number : source) {
            target.add(number);
        }
    }

    public static void print(List<?> list) {
        for (Object o : list) {
            System.out.print(o + " ");
        }
        System.out.println();
    }
}

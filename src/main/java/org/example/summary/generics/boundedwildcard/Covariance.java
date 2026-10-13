package org.example.summary.generics.boundedwildcard;

import java.util.ArrayList;
import java.util.List;

public class Covariance {

    // Get is allowed, put is not.
    static void main(String[] args) {

        List<Integer> intList = new ArrayList<Integer>();
        intList.add(10);
        intList.add(5);

        List<? extends Number> list = intList;

        Number x = list.get(0);
        System.out.println("x = " + x);

        // list.add(34); // error

    }
}

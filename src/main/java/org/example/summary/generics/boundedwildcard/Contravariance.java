package org.example.summary.generics.boundedwildcard;

import java.util.ArrayList;
import java.util.List;

public class Contravariance {

    // Put is allowed, get is not.
    static void main(String[] args) {
        List<Object> myObjs = new ArrayList<Object>();
        myObjs.add("Maria");
        myObjs.add("Alex");

        List<? super Number> myNums = myObjs;

        myNums.add(10);
        myNums.add(3.14);

        // Number x = myNums.get(0); // error
    }
}

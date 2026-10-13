package org.example.summary.generics.listofvalues.services;

import java.util.ArrayList;
import java.util.List;

public class PrintService<T> {

    List<T> list = new ArrayList<>();

    public void addValue(T value) {
        list.add(value);
    }

    public T getFirst() {
        if (list.isEmpty()) return null;
        return list.getFirst();
    }

    public void print() {
        System.out.print("[");
        if (!list.isEmpty()) {
            System.out.print(list.getFirst());
        }
        for (int i = 1; i < list.size(); i++) {
            System.out.print(", " + list.get(i));
        }
        System.out.println("]");
    }

}

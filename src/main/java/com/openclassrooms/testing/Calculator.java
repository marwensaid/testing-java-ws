package com.openclassrooms.testing;

import java.util.HashSet;
import java.util.Set;

class Calculator {

    int add(int a, int b) {
        return a + b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    Set<Integer> digitalOp(int number) {

        HashSet<Integer> integers = new HashSet<>();
        String numberString = String.valueOf(number);

        for (int i = 0; i < numberString.length(); i++) {
            if (numberString.charAt(i) != '-') {
                integers.add(Integer.parseInt(numberString, i, i + 1, 10));
            }
        }

        return integers;
    }
}

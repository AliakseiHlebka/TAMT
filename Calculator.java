package com.epam.task.TAMT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public static int plus(int a, int b) {
        return a + b;
    }

    public static int minus(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static double division(int a, int b) {
        double c = Double.parseDouble(String.valueOf(a));
        double d = Double.parseDouble(String.valueOf(b));
        if (d != 0) {
            return c / d;
        } else {
            throw new RuntimeException("Can't divide by zero!");
        }
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int firstValue = 0;
        char actionSymbol = 0;
        int secondValue = 0;
        try {
            System.out.println("Enter first number");
            firstValue = Integer.parseInt(reader.readLine());
            System.out.println("Enter math operator");
            actionSymbol = reader.readLine().charAt(0);
            System.out.println("Enter second number");
            secondValue = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (actionSymbol == '+') {
            System.out.println("Result: " + plus(firstValue, secondValue));
        } if (actionSymbol == '-') {
            System.out.println("Result: " + minus(firstValue, secondValue));
        } if (actionSymbol == '*') {
            System.out.println("Result: " + multiply(firstValue, secondValue));
        } if (actionSymbol == '/') {
            try {
                System.out.println("Result: " + division(firstValue, secondValue));
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

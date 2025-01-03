package com.example.calculator2;

import java.util.ArrayList;

public class Calculator {
    // 필드
    public ArrayList<Double> saveResult = new ArrayList<>();


    //메서드
    public double calculate(int num1, int num2, char op) throws CalculatorException{
        switch (op) {
            case '+': {
                double result = add(num1, num2);
                saveResult.add(result);
                return result;
            }
            case '-': {
                double result = subtract(num1, num2);
                saveResult.add(result);
                return result;
            }
            case '*': {
                double result = multiply(num1, num2);
                saveResult.add(result);
                return result;
            }
            case '/': {
                if(num2 == 0){
                    throw new DivideException();
                }
                double result = divide(num1,num2);
                saveResult.add(result);
                return result;
            }
            default: {
                throw new InvalidInputValueException();
            }
        }
    }

    public double add(int num1, int num2) {
        return num1 + num2;
    }

    public double subtract(int num1, int num2) {
        return num1 - num2;
    }

    public double multiply(int num1, int num2) {
        return num1 * num2;
    }

    public double divide(int num1, int num2) {
        return (double) num1 / num2;
    }
}

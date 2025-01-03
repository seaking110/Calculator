package com.example.calculator2;

import java.util.ArrayList;

public class Calculator {
    // 필드
    private ArrayList<Double> saveResult = new ArrayList<>();

    public void setSaveResult(Double num) {
        this.saveResult.add(num);
    }

    public ArrayList<Double> getsaveResult() {
        return saveResult;
    }


    //메서드
    public double calculate(int num1, int num2, char op) throws CalculatorException{
        switch (op) {
            case '+': {
                return  add(num1, num2);
            }
            case '-': {
                return subtract(num1, num2);
            }
            case '*': {
                return  multiply(num1, num2);
            }
            case '/': {
                if(num2 == 0){
                    throw new DivideException();
                }
                return divide(num1,num2);

            }
            default: {
                throw new InvalidInputValueException();
            }
        }
    }

    public void removeResult() {
        saveResult.remove(0);
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

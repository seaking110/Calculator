package com.example.calculator2;

public class InvalidInputValueException extends CalculatorException{
    public InvalidInputValueException(){
        super("잘못된 연산자를 입력하셨습니다.");
    }
}

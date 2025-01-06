package com.example.calculator2;

public class InvalidInputValueException extends CalculatorException{
    //잘못된 사칙 연산 기호를 입력 했을 때 처리할 예외 클래스
    public InvalidInputValueException(){
        super("잘못된 연산자를 입력하셨습니다.");
    }
}

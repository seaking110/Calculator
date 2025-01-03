package com.example.calculator2;

public class DivideException extends CalculatorException{
    public DivideException(){
        super("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
    }
}

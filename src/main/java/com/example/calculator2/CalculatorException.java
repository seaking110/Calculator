package com.example.calculator2;

public class CalculatorException extends RuntimeException{
    // 예외 클래스를 한번에 사용하기 위한 부모 예외 클래스
    // RuntimeException을 쓰며 Exception보다 예외 처리의 강제 여부를 완화
    public CalculatorException(String message){
        super(message);
    }
}

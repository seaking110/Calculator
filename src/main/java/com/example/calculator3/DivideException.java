package com.example.calculator3;

public class DivideException extends RuntimeException {
    // 0으로 나눴을 때의 예외를 처리하기 위한 예외 클래스
    public DivideException(){
        super("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
    }
}

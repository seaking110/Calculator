package com.example.calculator3;

import java.util.ArrayList;
import java.util.List;


public class ArithmeticCalculator <T extends Number>{
    // 필드
    //계산 결과 값을 저장할 컬렉션 필드
    private List<T> saveResult = new ArrayList<>();
    private T t;
    //메서드
    // 컬렉션에 값을 추가하는 Setter 메서드
    public void setSaveResult(T num) {
        this.saveResult.add(num);
    }
    // 컬렉션 필드에 접근하여 값을 가져오는 Getter 메서드
    public List<T> getsaveResult() {
        return saveResult;
    }

    public void set(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    // 계산 메서드
    // return switch 문을 사용하고 -> 연산자를 사용하여 가독성을 높히며 yield 키워드를 사용하여 블록 내부의 반환 값을 지정
    public double calculate(T num1, T num2, OperatorType op) {
        return switch (op) {
            case PLUS -> add(num1, num2);
            case MINUS -> subtract(num1, num2);
            case MULTIPLY -> multiply(num1, num2);
            case DIVIDE-> {
                if (num2.doubleValue() == 0) {
                    throw new DivideException();
                }
                yield divide(num1, num2);
            }
        };
    }

    // 컬렉션 필드의 맨 앞 값 삭제 메서드
    public void removeResult() {
        saveResult.remove(0);
    }

    //사칙 연산 메서드
    public double add(T num1, T num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

    public double subtract(T num1, T num2) {
        return num1.doubleValue() - num2.doubleValue();
    }

    public double multiply(T num1, T num2) {
        return num1.doubleValue() * num2.doubleValue();
    }

    public double divide(T num1, T num2) {
        return num1.doubleValue() / num2.doubleValue();
    }
}

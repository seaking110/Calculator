package com.example.calculator2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // 필드
    //계산 결과 값을 저장할 컬렉션 필드
    private List<Double> saveResult = new ArrayList<>();

    //메서드
    // 컬렉션에 값을 추가하는 Setter 메서드
    public void setSaveResult(Double num) {
        this.saveResult.add(num);
    }
    // 컬렉션 필드에 접근하여 값을 가져오는 Getter 메서드
    public List<Double> getsaveResult() {
        return saveResult;
    }

    // 계산 메서드
    // return switch 문을 사용하고 -> 연산자를 사용하여 가독성을 높히며 yield 키워드를 사용하여 블록 내부의 반환 값을 지정
    public double calculate(int num1, int num2, char op) {
        return switch (op) {
            case '+' -> add(num1, num2);
            case '-' -> subtract(num1, num2);
            case '*' -> multiply(num1, num2);
            case '/'-> {
                if (num2 == 0) {
                    throw new DivideException();
                }
                yield divide(num1, num2);
            }
            default -> throw new InvalidInputValueException();
        };
    }

    // 컬렉션 필드의 맨 앞 값 삭제 메서드
    public void removeResult() {
        saveResult.remove(0);
    }

    //사칙 연산 메서드
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

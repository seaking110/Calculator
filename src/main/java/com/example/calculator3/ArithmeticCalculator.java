package com.example.calculator3;

import java.util.ArrayList;
import java.util.List;


public class ArithmeticCalculator <T extends Number>{
    // 필드
    //계산 결과 값을 저장할 컬렉션 필드
    private List<Double> saveResult = new ArrayList<>();
    // 기준 값 보다 큰 값만을 저장할 컬렉션 필드
    private List<Double> largeResult = new ArrayList<>();
    // 타입 정보 저장
    private T t;


    //메서드
    // 컬렉션에 값을 추가하는 Setter 메서드
    public void setSaveResult(double num) {
        this.saveResult.add(num);
    }
    public void setlargeResult(double num) {
        this.largeResult.add(num);
    }

    // 컬렉션 필드에 접근하여 값을 가져오는 Getter 메서드
    public List<Double> getsaveResult() {
        return saveResult;
    }
    public List<Double> getLargeResult() {
        return largeResult;
    }

    // 해당 계산기의 타입정보 저장 및 가져오기 기능
    // 제네릭 타입 T의 클래스 정보를 나타내며 런타임 타입 정보를 얻을 수 있다.
    public Class<T> getType() {
        return (Class<T>) t.getClass();
    }
    public void setType(T t) {
        this.t = t;
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
            case MODULO -> {
                if (num2.doubleValue() == 0) {
                throw new DivideException();
            }
                yield modulo(num1, num2);
            }
        };
    }
    // 입력 받은 값보다 큰 결과물만 출력
    public List<Double> largeResult(double d) {
        largeResult.clear();
        saveResult.stream().filter(f-> f > d).forEach(f -> largeResult.add(f));
        return getLargeResult();
    }
    // 컬렉션 필드의 맨 앞 값 삭제 메서드
    public void removeResult() {saveResult.remove(0);}

    // 컬렉션 필드의 입력 인덱스 값 삭제 메서드
    public void removeResult(int n) {saveResult.remove(n);}


    // 연산 메서드
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

    public double modulo(T num1, T num2) {
        return  num1.doubleValue() % num2.doubleValue();
    }
}

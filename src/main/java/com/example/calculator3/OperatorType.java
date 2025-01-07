package com.example.calculator3;

public enum OperatorType {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');

    private final char type;

    OperatorType(char type) {
        this.type = type;
    }
    public char getType() {
        return type;
    }
    // 해당 메서드가 특정 인스턴스에 의존하지 않으니 static을 추가했고
    // values를 사용해서 enum 클래스를 순회하여 같은 값이 있으면 해당 데이터를 리턴
    // 만약 없다면 널 값 리턴
    public static OperatorType findOp(char op) {
        for (OperatorType operator : values()) {
            if (operator.getType() == op) {
                return operator;
            }
        }
        return null; // 유효하지 않은 연산자일 경우
    }



}

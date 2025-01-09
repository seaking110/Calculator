package com.example.calculator3;

public enum OperatorType {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/'),
    MODULO('%');

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
        // 이미 입력 받을 때 검사를 진행
        // 따라서 예외처리
        throw new IllegalArgumentException("지원되지 않는 연산자입니다: " + op);
    }



}

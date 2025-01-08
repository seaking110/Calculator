package com.example.calculator3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("계산기 프로그램을 시작합니다!");
        ArithmeticCalculator <Double> cal = new ArithmeticCalculator();
        // exit를 받을 때까지 무한루프
        while (true) {
            double num1 =0; // 첫번째 입력값
            double num2 =0; // 두번째 입력값

            //입력 부분
            System.out.println("첫번째 실수를 입력하세요!");
            num1 = sc.nextDouble();

            System.out.println("사칙연산 기호를 입력하세요!");
            char operation = sc.next().charAt(0);

            OperatorType operatorType = OperatorType.findOp(operation);
            if (operatorType == null) {
                System.out.println("잘못된 사칙연산 기호를 입력하셨습니다! 다시 입력하세요!");
                continue;
            }
            System.out.println("두번째 실수를 입력하세요!");
            num2 = sc.nextDouble();

            // 계산 메소드를 호출하는 단계
            boolean issue = false; // 이슈 발생 여부 체크 변수
            double result = 0; // 계산 결과 값 저장 변수
            // enum을 이용, 일치하는 상수 반환

            // 계산 중 에러 발생 시 이슈 발생 여부 체크 변수의 값 변경 및 오류 메세지 출력
            try {
                result = cal.calculate(num1,num2,operatorType);
            } catch (CalculatorException e){
                issue = true;
                System.out.println(e.getMessage());
            }
            // 오류 발생 여부 체크 후 결과 출력
            if (!issue) {
                cal.setSaveResult(result);
                System.out.println("결과: " + result);
            }

            // 전체 결과 출력
            System.out.print("현재까지 연산한 결과는 :");
            for (double d : cal.getsaveResult()) {
                System.out.print(d+" ");
            }
            System.out.println();

            // 맨 앞의 연산 결과 삭제
            System.out.println("연산한 결과들의 맨 앞을 삭제하시겠습니까? (yes 입력시 삭제)");
            String delete = sc.next();
            // yes 라면 Calculator의 삭제 메소드를 호출하여 객체의 필드에 간접 접근하여 컬렉션 필드 값 수정
            if (delete.equals("yes")) {
                cal.removeResult();
                System.out.print("현재까지 연산한 결과는 :");
                for (double d : cal.getsaveResult()) {
                    System.out.print(d+" ");
                }
                System.out.println();
            }
            // 무한 루프를 빠져나가는 조건문
            System.out.println("더 계산하시겠습니까? (exit 입력시 종료)");
            String s = sc.next();
            if (s.equals("exit")) {
                System.out.println("계산기 프로그램을 종료합니다!");
                break;
            }
        }
    }
}

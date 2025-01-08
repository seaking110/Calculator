package com.example.calculator3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("계산기 프로그램을 시작합니다!");
        ArithmeticCalculator<Double> cal = new ArithmeticCalculator();
        // exit를 받을 때까지 무한루프
        while (true) {
            double num1 = 0; // 첫번째 입력값
            double num2 = 0; // 두번째 입력값

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
                result = cal.calculate(num1, num2, operatorType);
            } catch (DivideException e) {
                issue = true;
                System.out.println(e.getMessage());
            }
            // 오류 발생 여부 체크 후 결과 출력
            if (!issue) {
                cal.setSaveResult(result);
                System.out.println("결과: " + result);

            }
            boolean flag = true;
            while (flag) {
                System.out.println();
                System.out.println("전체 연산 조회 : 1");
                System.out.println("첫번째 연산 결과 삭제 : 2");
                System.out.println("계산기 프로그램 종료 : 3 (또는 exit)");
                System.out.println("입력 값보다 큰 값 조회 : 4");
                System.out.println("다시 계산 하시려면 그외의 값을 입력해주세요!!!");

                String s = sc.next();
                switch (s) {
                    case "1": {
                        System.out.print("현재까지 연산한 결과는 :");
                        for (double d : cal.getsaveResult()) {
                            System.out.print(d + " ");
                        }
                        System.out.println();
                        break;
                    }
                    case "2": {
                        cal.removeResult();
                        System.out.print("첫번째 연산을 삭제한 뒤 연산한 결과는 : ");
                        for (double d : cal.getsaveResult()) {
                            System.out.print(d + " ");
                        }
                        System.out.println();
                        break;
                    }
                    case "3": case "exit": {
                        System.out.println("계산기 프로그램을 종료합니다!");
                        System.exit(0);
                    }
                    case "4": {
                        System.out.println("기준이 될 값을 입력해주세요!!");
                        double min = sc.nextDouble();
                        if (cal.largeResult(min).size() == 0){
                            System.out.println("큰 값이 존재하지 않습니다!");
                        }
                        else {
                            System.out.print(min+"보다 큰 값은 : ");
                            for (double d : cal.getLargeResult()){
                                System.out.print(d+" ");
                            }
                            System.out.println();
                        }
                        break;
                    }
                    default: flag = false;
                }

            }
        }
    }
}

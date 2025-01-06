package com.example.calculator;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("계산기 프로그램을 시작합니다!");
        //무한 루프 반복문을 이용하여 무한으로 반복
        while (true) {
            System.out.println("첫번째 0을 포함한 양의 정수를 입력하세요!");
            int num1 = sc.nextInt();
            System.out.println("사칙연산 기호를 입력하세요!");
            // sc.nextLine으로 받을 시 위에 int 형을 받으며 개행문자가 들어가 문제 발생
            // sc.next로 받고 charAt(0) 으로 1개의 문자만 가져오기
            char operation = sc.next().charAt(0);
            System.out.println("두번째 0을 포함한 양의 정수를 입력하세요!");
            int num2 = sc.nextInt();
            // 케이스가 4개이상이기 때문에 if문 보다는 가독성이 좋은 switch문 채택
            switch (operation) {
                case '+' : {
                    int result = num1 + num2;
                    System.out.println("결과: "+ result);
                    break;
                }
                case '-' : {
                    int result = num1 - num2;
                    System.out.println("결과: "+ result);
                    break;
                }
                case '*' : {
                    int result = num1 * num2;
                    System.out.println("결과: "+ result);
                    break;
                }
                // 나누기 일때 분모가 0인 경우 따로 오류 내용 정제하여 출력
                case '/' : {
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    } else {
                        double result = (double) num1 / num2;
                        System.out.println("결과: "+ result);
                    }
                    break;
                }
                // 사칙연산 기호가 아닌 다른 문자나 숫자가 들어왔을 때 오류 내용 정제하여 출력
                default : {
                    System.out.println("잘못된 연산자를 입력하셨습니다");
                }
            }
            System.out.println("더 계산하시겠습니까? (exit 입력시 종료)");
            String s = sc.next();
            // 입력 받은 문자가 exit 인 경우 반복문 정지 후 프로그램 종료
            if (s.equals("exit")) {
                System.out.println("계산기 프로그램을 종료합니다!");
                break;
            }
        }
    }
}
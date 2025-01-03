package com.example.calculator;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("계산기 프로그램을 시작합니다!");
        while(true){
            System.out.println("첫번째 0을 포함한 양의 정수를 입력하세요!");
            int num1 = sc.nextInt();
            System.out.println("사칙연산 기호를 입력하세요!");
            char operation = sc.next().charAt(0);
            System.out.println("두번째 0을 포함한 양의 정수를 입력하세요!");
            int num2 = sc.nextInt();
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
                case '/' : {
                    if(num2 == 0){
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    }
                    else{
                        double result = (double) num1 / num2;
                        System.out.println("결과: "+ result);
                    }
                    break;
                }
                default : {
                    System.out.println("잘못된 연산자를 입력하셨습니다");
                }
            }

            System.out.println("더 계산하시겠습니까? (exit 입력시 종료)");
            String s = sc.next();
            if(s.equals("exit")){
                System.out.println("계산기 프로그램을 종료합니다!");
                break;
            }
        }
    }
}
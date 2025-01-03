package com.example.calculator2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("계산기 프로그램을 시작합니다!");
        Calculator cal = new Calculator();
        while(true){
            int num1 =0;
            int num2 =0;
            try{
                System.out.println("첫번째 0을 포함한 양의 정수를 입력하세요!");
                num1 = sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("잘못된 입력입니다!");
                sc.next();
                continue;
            }
            System.out.println("사칙연산 기호를 입력하세요!");
            char operation = sc.next().charAt(0);
            try{
                System.out.println("두번째 0을 포함한 양의 정수를 입력하세요!");
                num2 = sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("잘못된 입력입니다!");
                continue;
            }

            boolean issue = false;
            double result = 0;
            try{
                result = cal.calculate(num1,num2,operation);
            } catch (CalculatorException e){
                issue = true;
                System.out.println(e.getMessage());
            }
            if(!issue) {
                cal.setSaveResult(result);
                System.out.println("결과: " + result);

            }
            System.out.print("현재까지 연산한 결과는 :");
            for(double d : cal.getsaveResult()){
                System.out.print(d+" ");
            }
            System.out.println();
            System.out.println("연산한 결과들의 맨 앞을 삭제하시겠습니까? (yes 입력시 삭제)");
            String delete = sc.next();
            if(delete.equals("yes")){
                cal.removeResult();
                System.out.print("현재까지 연산한 결과는 :");
                for(double d : cal.getsaveResult()){
                    System.out.print(d+" ");
                }
                System.out.println();
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

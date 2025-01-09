package com.example.calculator3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 와일드 카드를 이용하여 어떤 값인지 모를 객체 생성
        ArithmeticCalculator<? extends Number> cal = null;
        // 계산기 타입을 구분할 변수
        int type = 0;
        System.out.println("계산기 프로그램을 시작합니다!");
        System.out.println("계산기 타입을 선택하세요: 1 (정수), 2 (실수)");
        // 계산기 선택 로직
        // 1번을 고를 시 계산기를 Integer 형으로 2번을 고를 시 Double 형으로 해당 타입 객체 생성
        // 또한 와일트 카드로 만든 객체를 다시 타입에 맞는 타입 캐스팅을 진행
        // 해당 데이터 타입에 맞는 초기값을 배정하여 타입을 미리 지정
        // 타입 캐스팅을 진행 해도 cal.setType은 안됨 cal의 실제 타입이 여전히 ? extends Number 이기 때문에
        // 따라서 명확한 doubleCal 이나 intCal을 사용해서 .setType을 하여 타입을 지정해놓기
        // 미리 타입으 지정해 놓아야 아래 getType에서 오류 발생 x
        while (true) {
            type = sc.nextInt();
            if (type == 1) {
                cal = new ArithmeticCalculator<Integer>();
                ArithmeticCalculator<Integer> intCal = (ArithmeticCalculator<Integer>) cal;
                intCal.setType(0);  // Integer 타입에 맞는 초기값
                break;
            } else if (type == 2) {
                cal = new ArithmeticCalculator<Double>();
                ArithmeticCalculator<Double> doubleCal = (ArithmeticCalculator<Double>) cal;
                doubleCal.setType(0.0);  // Double 타입에 맞는 초기값
                break;
            } else {
                System.out.println("잘못된 입력입니다! 다시 선택해주세요! 1 (정수), 2 (실수)");
            }
        }
        while (true) {
            runCalculation(sc, cal);
        }
    }


    // 입력 및 연산 수행 메서드
    private static <T extends Number> void runCalculation(Scanner sc, ArithmeticCalculator<T> cal) {
        // cal에서 type을 받아와 해당 타입에 맞는 입력 값을 받아오기
        // 문제가 생겼을 때 바로 다시 출력을 위해 출력하는 문자열도 매개 변수로 같이 전달
        T num1 = getNumber(sc, "첫번째 숫자를 입력하세요:" , cal.getType());
        // 연산자 받아오기
        char operation = getOperator(sc);
        T num2 = getNumber(sc, "두번째 숫자를 입력하세요:" , cal.getType());
        // 계산 중 예외 발생 시 오류 메세지 출력
        // enum 메서드를 통해 연산자 매칭
        try {
            double result = cal.calculate(num1, num2, OperatorType.findOp(operation));
            cal.setSaveResult(result);
            System.out.println("결과: " + result);
        } catch (DivideException e) {
            System.out.println(e.getMessage());
        }
        // 메뉴 출력
        menu(sc, cal);
    }

    // 사용자가 입력한 정수 or 실수 값 받아 오기
    // T 타입으로 반환하기 위해 입력받은 값을 .cast() 메서드를 사용해 강제 캐스팅
    // 입력값이 정수나 실수가 아닌 경우 NumberFormatException 예외를 처리하여 잘못된 입력을 처리
    private static <T extends Number> T getNumber(Scanner sc, String prompt, Class<T> type) {
        while (true) {
            System.out.println(prompt);
            try {
                String input = sc.next();
                if (type == Integer.class) {
                    return type.cast(Integer.parseInt(input));
                } else if (type == Double.class) {
                    return type.cast(Double.parseDouble(input));
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
    // 연산자 입력 받기
    // contains을 사용해서 연산자 존재 여부 확인
    private static char getOperator(Scanner sc) {
        while (true) {
            System.out.println("연산 기호를 입력하세요 (+, -, *, /, %):");
            String input = sc.next();
            if (input.length() == 1 && "+-*/%".contains(input)) {
                return input.charAt(0);
            }
            System.out.println("잘못된 연산 기호입니다. 다시 입력해주세요.");
        }
    }
    //메뉴 추력 및 선택 처리
    private static void menu(Scanner sc, ArithmeticCalculator<?> cal) {
        while (true) {
            System.out.println("\n메뉴: 1. 전체 결과 조회  2. 큰 값 조회  3. 결과 삭제  4. 첫 번째 삭제  5. 종료");
            System.out.println("그외의 값을 입력하면 다시 계산!!");
            String choice = sc.next();
            switch (choice) {
                // 전체 계산 결과 조회
                case "1":
                    System.out.print("현재까지 연산한 결과는 :");
                    for (double d : cal.getsaveResult()) {
                        System.out.print(d + " ");
                    }
                    System.out.println();
                    break;
                // 기준 값 보다 큰 값 조회
                case "2":
                    System.out.println("기준값을 입력하세요:");
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
                // 원하는 결과 삭제
                case "3":
                    int count = 1;
                    for (double d : cal.getsaveResult()) {
                        System.out.print((count++)+"번 :"+d + " ");
                    }
                    System.out.println();
                    int n = 0;
                    while (true) {
                        System.out.println("삭제할 값의 번호를 입력해주세요!!");
                        n = sc.nextInt();
                        if (cal.getsaveResult().size() < n || n <= 0) {
                            System.out.println("잘못된 번호 입니다!!");
                            break;
                        } else {
                            cal.removeResult(n -1);
                            System.out.println("삭제 되었습니다!!");
                            break;
                        }
                    }
                    break;
                // 첫번째 결과 삭제
                case "4":
                    if (cal.getsaveResult().size() == 0) {
                        System.out.println("저장된 연산이 없습니다!!");
                        break;
                    }
                    System.out.println("첫번째 연산이 삭제 되었습니다!!");
                    cal.removeResult();
                    break;
                //프로그램 종료
                case "5":
                    System.out.println("프로그램 종료!!");
                    System.exit(0);
                default:
                    //계산기 재 실행
                    return;
            }
        }
    }
}


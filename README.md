# 계산기 프로그램 (Generic Calculator)

이 프로젝트는 제네릭과 ENUM, STREAM을 활용하여 정수형 및 실수형 계산을 처리할 수 있는 계산기 프로그램입니다. 사용자는 두 개의 숫자와 연산 기호를 입력하여 계산을 수행할 수 있으며, 특정 조건에 따라 결과를 조회할 수 있습니다.

---

## 주요 기능

1. **제네릭(Generic) 기반 설계**
   - 정수형(`Integer`) 및 실수형(`Double`) 모두 지원.
   - `T extends Number`를 통해 다양한 숫자 타입을 처리.

2. **ENUM을 이용한 연산자 관리**
   - 사칙연산 기호(`+`, `-`, `*`, `/`)를 `OperatorType` 열거형으로 관리하여 코드 가독성과 유지보수성을 향상.

3. **결과 저장 및 조회**
   - 연산 결과를 컬렉션(List)에 저장하여 관리.
   - 입력 값보다 큰 결과를 조회하는 기능 제공.

4. **예외 처리**
   - 0으로 나누는 경우 `DivideException`을 통해 오류를 처리.

---

## 프로그램 흐름

1. 프로그램 시작 시 사용자에게 정수형(1) 또는 실수형(2)을 선택하도록 요청.
2. 두 개의 숫자와 사칙연산 기호를 입력받아 계산 수행.
3. 계산 결과를 출력하고 저장.
4. 추가 기능 제공:
   - **전체 연산 조회**: 지금까지 수행한 모든 연산 결과를 출력.
   - **첫 번째 연산 삭제**: 저장된 결과 중 가장 첫번째 값을 삭제.
   - **특정 조건 조회**: 특정 값보다 큰 연산 결과를 출력.
   - **프로그램 종료**: 프로그램을 종료.

---

## 코드 구성

### 1. `App.java`
사용자 입력 및 프로그램 흐름을 제어하는 메인 클래스입니다.


### 2. `ArithmeticCalculator<T>`
실제 계산 로직과 결과 관리 기능을 제공하는 제네릭 클래스입니다.

- **주요 메서드**:
  - `calculate(T num1, T num2, OperatorType op)`: 두 숫자와 연산자를 받아 계산 수행.
  - `add`, `subtract`, `multiply`, `divide`: 사칙연산 메서드.
  - `setSaveResult(double result)`: 계산 결과 저장.
  - `largeResult(double min)`: 특정 값보다 큰 결과를 조회.

### 3. `OperatorType`
사칙연산 기호를 관리하는 ENUM 클래스입니다.

- `PLUS`, `MINUS`, `MULTIPLY`, `DIVIDE`를 정의.
- `findOp(char op)`: 입력받은 문자에 해당하는 ENUM 반환.

### 4. `DivideException`
나눗셈의 분모가 0일 때의 예외를 처리하는 예외 클래스 입니다.

---


## 사용 예

```text
계산기 프로그램을 시작합니다!
첫 번째 실수를 입력하세요!
5.0
사칙연산 기호를 입력하세요!
+
두 번째 실수를 입력하세요!
3.2
결과: 8.2

전체 연산 조회 : 1
첫 번째 연산 결과 삭제 : 2
계산기 프로그램 종료 : 3 (또는 exit)
입력 값보다 큰 값 조회 : 4
```

---

## 아쉬운 점
- GUI 기반으로 사용자에게 인터페이스를 제공하는 프로그램으로 변경

---




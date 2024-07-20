### 열거 타입(ENUM)
- 관련이 있는 상수 집합의 클래스
- 각각의 열거 상수는 열거 객체로 생성됨
  - 기존 상수를 정의하는 방법을 효과적으로 대체
- 자바 1.5이후 추가
- 코드의 안정성, 가독성, 유지 보수성 향상

```java
접근제어자 enum 열거체이름 {

		상수명1, 상수명2, ... 상수명XX;		
		
}

public enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

```

<hr>

#### 정수 열거 패턴을 사용할 경우
```java
public class Foods {

		// 정수 열거 패턴
    public final static int MEAL_AN_BUTTER_KIMCHI_STEW = 0;
    public final static int MEAL_MINT_SEAWEED_SOUP = 1;

    public final static int DRINK_RADISH_KIMCHI_LATTE = 0;
    public final static int DRINK_WOOLUCK_SMOOTHIE = 1;
}
```
- 타입 안정성을 보장할 방법이 없고 에러 디버깅이 어려움
- 상수를 문자열로 출력이 어려움
- 정수 열거 그룹에 속한 모든 상수를 순회하는 방법도 쉽지 않음
- 상수에 변경이 발생하면 컴파일을 새로 해야함


#### 열거 타입은 정수 열거 패턴의 단점을 모두 보완할 뿐 아니라 그 외에 다양한 장점도 존재

#### 열거 타입의 장점
- 열거 타입은 **싱글톤** 방식으로 구현
    - 인스턴스의 생성이나 확장이 되지 않는다.
    - 즉, 인스턴스가 통제되며 하나만 존재하는 것이 보장
- 열거 타입은 컴파일 타임 **타입 안정성을 높여준다**.
    - 다른 타입의 매개변수가 들어오는 경우 컴파일 에러를 발생시켜 준다.
- 열거 타입은 상수 이름을 문자열로 출력할 수 있다.
- 열거 타입에 메소드나 필드를 추가 할 수 있다.
    - 추가로 열거 타입은 근본적으로 불변이라 모든 필드는 final 이어야 한다
- 열거 타입도 클래스이기 때문에 toString() 을 재정의하여 사용할 수 있다.
- 열거 타입에 선언된 상수 하나를 제거하더라도 클라이언트에 영향을 주지 않는다.
    - 혹시나 삭제된 상수를 참조하고 있는 곳이 있다면 컴파일 에러를 출력해주기 때문에 안전하다.
- 열거 타입 내에 선언된 상수들을 순회할 수 있다.

<hr>

### 람다(Lambda)
- 메소드를 하나의 식(expression)으로 표현한 것
- 메소드를 람다식으로 표현하면 메소드 이름과 리턴값이 없어서 익명 함수라고도 할 수 있음
- JAVA 8 버전에 새로 추가
- 사용 이유
  - 단순함, 편리함
  - 불필요하게 반복되는 코드 제거 가능
  
```java
// 매개 변수 없는 경우
() -> { ... }

// 매개 변수 있는 경우
(타입 매개변수, ...) -> { ... }
```

#### 함수적 인터페이스(@Functional Interface)
- 단 하나의 추상 메서드를 갖는 인터페이스
- 메소드는 항상 클래스 내부에서 선언되기 때문에 람다식은 단독으로 선언할 수 없음
- 익명 클래스처럼 인터페이스 변수에 대입됨
- @FunctionalInterface 어노테이션 : 두 개 이상의 추상 메서드가 선언될 경우 컴파일 오류를 발생시킴

```java
@FunctionalInterface
interface MyFunctionalInterface {   // 함수적 인터페이스 정의
    void execute();
}

public class LambdaExample {
    public static void main(String[] args) {
    
        // 람다 표현식 사용
        MyFunctionalInterface myFunc = () -> System.out.println("Hello, Lambda!");
        myFunc.execute();  // 출력: Hello, Lambda!
    }
}

```

#### 자바에서 제공하는 함수적 인터페이스

| 인터페이스           | 설명                                         | 예제 코드                                     |
|----------------------|--------------------------------------------|-----------------------------------------------|
| **Predicate<T>**     | 객체 T를 인수로 받아 boolean 값을 반환   | `Predicate<String> isEmpty = (s) -> s.isEmpty();` |
| **Function<T, R>** &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  | 객체 T를 인수로 받아 객체 R을 반환      | `Function<String, Integer> toLength = (s) -> s.length();` |
| **Consumer<T>**      | 객체 T를 인수로 받아 결과를 반환하지 않음 | `Consumer<String> print = (s) -> System.out.println(s);` |
| **Supplier<T>**      | 인수를 받지 않고 객체 T를 반환            | `Supplier<Double> randomValue = () -> Math.random();` |
| **UnaryOperator<T>** | T를 받아 T를 반환                       | `UnaryOperator<Integer> doubleValue = (x) -> x * 2;` |
| **BinaryOperator<T>**| 두 개의 T를 받아 T를 반환                | `BinaryOperator<Integer> add = (a, b) -> a + b;` |

<br>

#### 메소드 참조
- 함수형 인터페이스르 람다식이 아닌 일반 메소드를 참조시켜 선언하는 방법
  - 함수형 인터페이스의 매개변수 타입/갯수/반환형 == 메소드의 매개변수 타입/갯수/반환형 같을 경우 가능
- 사용 이유
  - 코드 간결성, 재사용성, 가독성 향상
  
```java
클래스이름::메소드이름 (static)일 경우
참조변수이름::메소드이름 (non-static)일 경우
```
  
#### 메소드 참조의 종류

| 종류                                | 설명                                     | 예시 코드                                      |
|-------------------------------------|----------------------------------------|-----------------------------------------------|
| **정적 메소드 참조**               | 클래스의 정적 메소드를 참조          | `Function<Integer, Integer> square = Math::abs;` |
| **인스턴스 메소드 참조**           | 특정 객체의 인스턴스 메소드를 참조  | `Printer printer = new Printer(); Consumer<String> print = printer::print;` |
| **임의 객체의 인스턴스 메소드 참조** | 특정 타입의 객체의 메소드를 참조     | `names.forEach(System.out::println);`       |
| **생성자 참조**                    | 생성자를 참조하여 객체 생성           | `Supplier<Person> personSupplier = Person::new;` |

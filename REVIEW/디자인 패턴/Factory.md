## 팩토리 패턴

![](https://velog.velcdn.com/images/hso07202/post/15384e55-6c96-46f8-ba9e-863218404fe7/image.png)

출처 : [https://refactoring.guru/ko/design-patterns/factory-method]

- 객체를 사용하는 코드에서 객체 생성 부분을 떼어내 추상화한 패턴
- 상속 관계에 있는 두 클래스에서 상위 클래스가 중요한 뼈대 결정(실제 객체 생성) 
→ 하위 클래스는 객체 생성의 구체적 내용을 결정
- 클래스의 객체를 동적으로 생성 → 생성 패턴

### 장점

- 상위 - 하위 클래스 분리로 느슨한 결합, 유연성
- 객체 생성 로직이 따로라 리팩토링 하더라도 한 곳만 고쳐서 유지보수성 증가

### 단점

- 인터페이스 및 구체적인 클래스와 팩토리 클래스가 모두 필요하므로, 클래스 파일이 많아지고 구조가 복잡해질 수 있음
    
    → 클래스 증가, 복잡성 증가
    
- 예시  코드
    
    ```java
    // 1. 제품 인터페이스
    interface Car {
        void drive();
    }
    
    // 2. 구체적인 제품 클래스들
    class Sedan implements Car {
        @Override
        public void drive() {
            System.out.println("Sedan 주행 중...");
        }
    }
    
    class SUV implements Car {
        @Override
        public void drive() {
            System.out.println("SUV 주행 중...");
        }
    }
    
    // 3. 팩토리 클래스
    class CarFactory {
        // 팩토리 메서드
        public Car createCar(String carType) {
            if (carType == null) {
                return null;
            }
            if (carType.equalsIgnoreCase("Sedan")) {
                return new Sedan();
            } else if (carType.equalsIgnoreCase("SUV")) {
                return new SUV();
            }
            return null;
        }
    }
    
    // 4. 클라이언트 코드
    public class Main {
        public static void main(String[] args) {
            CarFactory carFactory = new CarFactory();
    
            // Sedan 생성
            Car sedan = carFactory.createCar("Sedan");
            sedan.drive(); // Sedan 주행 중...
    
            // SUV 생성
            Car suv = carFactory.createCar("SUV");
            suv.drive(); // SUV 주행 중...
        }
    }
    
    ```

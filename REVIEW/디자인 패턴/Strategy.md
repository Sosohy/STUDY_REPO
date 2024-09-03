## 전략 패턴(정책 패턴)

![](https://velog.velcdn.com/images/hso07202/post/0e2df327-ef98-4ee4-803a-9e972d8ad384/image.png)

출처 : [[https://velog.io/@kyle/디자인-패턴-전략패턴이란](https://velog.io/@kyle/%EB%94%94%EC%9E%90%EC%9D%B8-%ED%8C%A8%ED%84%B4-%EC%A0%84%EB%9E%B5%ED%8C%A8%ED%84%B4%EC%9D%B4%EB%9E%80)]

- 객체의 행위를 바꾸고 싶은 경우, 직접 수정하지 않고 전략(캡슐화한 알고리즘)을 컨텍스트 안에서 변경하며  상호 교체가 가능하게 만드는 패턴
    - EX. 결제할 때, BC카드로 사거나, 농협 카드로 사는 등 결제 전략만 변경해 두 가지 방식으로 결제
    - 특정 작업을 수행하는 알고리즘을 동적으로 교체 → 행위 패턴

### 장점

- 알고리즘의 분리
- 런타임에 전략을 바꿀 수 있으므로 프로그램의 동작을 동적으로 변경 → 유연성 증가
- 새로운 전략을 추가할 때 기존 코드 수정 없이 새로운 전략 클래스를 추가 → 확장성

### 단점

- 클래스 수 증가
- 알고리즘 선택의 책임이 클라이언트에게 있음

- 예시 코드
    
    ```java
    // 결제 전략 인터페이스
    interface PaymentStrategy {
        void pay(int amount);
    }
    
    // 카드 결제 전략
    class CreditCardStrategy implements PaymentStrategy {
        private String cardNumber;
    
        public CreditCardStrategy(String cardNumber) {
            this.cardNumber = cardNumber;
        }
    
        @Override
        public void pay(int amount) {
            System.out.println(amount + "원을 카드로 결제합니다. 카드 번호: " + cardNumber);
        }
    }
    
    // 페이팔 결제 전략
    class PayPalStrategy implements PaymentStrategy {
        private String email;
    
        public PayPalStrategy(String email) {
            this.email = email;
        }
    
        @Override
        public void pay(int amount) {
            System.out.println(amount + "원을 페이팔로 결제합니다. 페이팔 계정: " + email);
        }
    }
    
    // Context 클래스 (결제 처리)
    class ShoppingCart {
        private PaymentStrategy paymentStrategy;
    
        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }
    
        public void checkout(int amount) {
            paymentStrategy.pay(amount);
        }
    }
    
    // 클라이언트 코드
    public class Main {
        public static void main(String[] args) {
            ShoppingCart cart = new ShoppingCart();
    
            // 카드로 결제
            cart.setPaymentStrategy(new CreditCardStrategy("1234-5678-9876-5432"));
            cart.checkout(5000); // 5000원을 카드로 결제합니다.
    
            // 페이팔로 결제
            cart.setPaymentStrategy(new PayPalStrategy("user@example.com"));
            cart.checkout(10000); // 10000원을 페이팔로 결제합니다.
        }
    }
    
    ```
    

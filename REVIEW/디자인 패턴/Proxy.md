## 프록시 패턴

### 프록시 패턴

![](https://velog.velcdn.com/images/hso07202/post/feecc8e9-0386-43ab-a089-ae3d6d87eaad/image.png)


출처 : [https://refactoring.guru/ko/design-patterns/proxy]

- 어떤 객체에 대한 **접근을 제어**하거나, 객체의 **대리인** 역할을 하는 클래스(프록시)를 통해 **간접적으로** 그 객체를 제어하는 패턴
    - 대상 객체에 접근 하기 전 그 접근에 대한 흐름을 가로채 해당 접근을 필터링,수정하는 등의 역할

### 장점

- **지연 초기화(Lazy Initialization)**: 실제 객체의 생성 비용이 클 경우, 프록시가 대신 작업을 처리하다가, 실제 객체가 필요할 때만 생성
- 민감한 객체에 대한 접근을 프록시를 통해 제어
- 프록시 통해 요청을 캐시하거나 성능 최적화 가능
- 로그, 트랜잭션 처리 등 추가 작업 수행 가능

### 단점

- 응답 속도 지연
- 복잡성 증가

- 예시 코드
    
    ```java
    // 1. 주제 인터페이스 (공통 인터페이스)
    interface Service {
        void request();
    }
    
    // 2. 실제 객체 (RealSubject)
    class RealService implements Service {
        @Override
        public void request() {
            System.out.println("실제 서비스 요청 처리");
        }
    }
    
    // 3. 프록시 객체 (Proxy)
    class ProxyService implements Service {
        private RealService realService;
    
        @Override
        public void request() {
            if (realService == null) {
                realService = new RealService();  // 실제 객체 생성 (지연 초기화)
            }
            System.out.println("프록시에서 접근 제어 처리 중...");
            realService.request();  // 실제 서비스 요청
        }
    }
    
    // 4. 클라이언트 코드
    public class Main {
        public static void main(String[] args) {
            Service service = new ProxyService();  // 프록시 객체 사용
            service.request();  // 프록시를 통해 실제 객체에 접근
        }
    }
    
    ```
    

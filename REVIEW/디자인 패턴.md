## 싱글톤 패턴

- 하나의 클래스에 오직 하나의 인스턴스만 가지는 패턴
    - 하나의 인스턴스를 만들어 놓고 해당 인스턴스를 다른 모듈들이 공유하며 사용함
- DB 연결 모듈, 전역 상태 관리 등

### 장점

- 인스턴스 생성 비용 감소

### 단점

- 의존성 높아짐
- TDD 시, 각 테스트마다 독립적인 인스턴스 만들기가 어려움

### 방식

- Lazy Initialization 방식 (지연 초기화)
    
    ```java
    public class Singleton{
    
        // 생성자는 외부에서 호출못하게 private 으로 지정
        private Singleton() {}
         
        // 인스턴스를 생성하고 반환하는 정적 메서드 제공 
        // (synchronized로 멀티스레드 안전성 보장)
        public static synchronized Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }
    ```
    
- Eager Initialization 방식 (이른 초기화)
    
    ```java
    public class Singleton {
        
        // 클래스 로딩 시 인스턴스를 미리 생성
        private static final Singleton instance = new Singleton();
        
        // 생성자는 외부에서 호출못하게 private 으로 지정
        private Singleton() {}
        
        // 인스턴스를 반환하는 정적 메서드 제공
        public static Singleton getInstance() {
            return instance;
        }
    }
    ```
    

---

### 📗 의존성 주입

- 의존성 주입을 통해 모듈 간의 결합을 좀 더 느슨하게 만들어 해결 가능
- 메인 모듈이 직접 다른 하위 모듈에 대한 의존성을 주기 보다는 의존성 주입자가 이 부분을 가로채 메인 모듈이 ‘간접적’으로 의존성을 주입하는 방식
- 의존성 주입 원칙
    - 상위 모듈은 하위 모듈에서 어떠한 것도 가져오지 않아야 함
    - 추상화에 의존 → 추상화는 세부 사항에 의존X
- 장점
    - 모듈을 쉽게 교체 가능해 테스팅 및 마이그레이션 쉬움
    - 애플리케이션ㄴ 의존성 방향이 일관됨
    - 모듈 간의 관계 명확해짐
- 단점
    - 클래스 수가 늘어나 복잡성 증가
    - 런타임 패널티가 생기기도 함

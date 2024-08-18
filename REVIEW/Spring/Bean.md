### Bean

- 스프링 IoC (Inversion of Control) 컨테이너에 의해 관리되는 객체
- 특징
  - 싱글톤
    - 애플리케이션 내에서 하나의 인스턴스만 생성되어 사용
    - 필요에 따라 프로토타입 스코프 등을 사용하여 여러 인스턴스를 생성 가능
  - 의존성 주입
    - 스프링 빈 간의 의존성은 컨테이너가 자동으로 주입
  - 라이프 사이클 관리
    - 스프링 컨테이너가 빈의 생성, 초기화, 소멸 등 라이프 사이클 관리
 
#### Bean Scope
 - 스프링 빈이 생성될 때 생성되는 인스턴스의 범위를 의미
 
 | Bean Scope | Description |
| --- | --- |
| Singleton | 하나의 인스턴스만을 생성하고, 모든 빈이 해당 인스턴스를 공유하여 사용한다. |
| Prototype | 매번 새로운 인스턴스를 생성한다. |
| Request | HTTP 요청을 처리할 때마다 새로운 인스턴스를 생성하고, 요청 처리가 끝나면 인스턴스를 폐기한다. 웹 애플리케이션 컨텍스트에만 해당된다. |
| Session | HTTP 세션 당 하나의 인스턴스를 생성하고, 세션이 종료되면 인스턴스를 폐기한다. 웹 애플리케이션 컨텍스트에만 해당된다. |

#### 빈 정의 방법
- XML 설정
  - 스프링 설정 파일(applicationContext.xml)에 빈을 정의
- 자바 설정 클래스
  - @Configuration과 @Bean 어노테이션을 사용하여 자바 클래스에서 빈을 정의
- 컴포넌트 스캔과 어노테이션
  - @Component, @Service, @Repository, @Controller 어노테이션을 사용하여 클래스에서 직접 빈을 정의하고, @Autowired 등을 사용하여 의존성을 주입받음
  
#### 빈의 라이프 사이클

1. 빈 생성: 컨테이너가 빈의 인스턴스를 생성합니다.
2. 의존성 주입: 필요한 의존성을 주입받습니다.
3. 초기화 메서드 호출: 초기화 작업을 위해 정의된 메서드를 호출합니다.
4. 빈 사용: 애플리케이션에서 빈을 사용합니다.
5. 소멸 전 메서드 호출: 컨테이너 종료 시 소멸 작업을 위해 정의된 메서드를 호출합니다.
6. 빈 소멸: 빈의 인스턴스를 제거합니다.

- 빈 라이프사이클 메서드는 @PostConstruct와 @PreDestroy 어노테이션을 사용하거나, XML 및 자바 설정에서 명시 가능

```java
@Component
public class MyBean {

    @PostConstruct
    public void init() {
        // 초기화 작업
    }

    @PreDestroy
    public void destroy() {
        // 소멸 전 작업
    }
}
```
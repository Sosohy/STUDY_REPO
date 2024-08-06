### IoC(Inversion of Control)
- 제어의 역전(IoC)은 일반적인 프로그래밍에서, 프로그램의 제어 흐름 구조가 뒤바뀌는 것을 의미
  -> 객체의 생성, 관리, 객체 간의 의존성 처리 등을 프레임워크에서 대신 처리해주는 것이 IoC의 대표적인 예

- 장점
  - 유연한 설계
  - 테스트 용이성
  - 코드 재사용성
  - 유지보수성
  
### IoC Container
- IoC를 구현한 구체적인 프레임워크
- 객체의 생성, 초기화, 의존성 처리 등을 자동으로 수행
![](https://velog.velcdn.com/images/hso07202/post/8d535773-20b5-410b-a4c0-e5d07a663b11/image.png)

#### Bean Factory
- Spring IoC Container의 가장 기본적인 형태
- Bean의 생성, 초기화, 연결, 제거 등의 **라이프사이클을 관리**
  - 이를 위해 Configuration Metadata를 사용

#### Application Context
- BeanFactory를 확장한 IoC 컨테이너로 Bean을 등록하고 관리하는 기능은 BeanFactory와 동일하지만 스프링이 제공하는 각종 부가 기능을 추가로 제공


##### <span style="color:green"> Bean </span>
- IoC Container에서 관리되는 객체
  - 스프링은 Bean 생성, 초기화, 의존성 주입, 제거 등의 일을 IoC Container를 통해 자동으로 처리 가능
  
##### <span style="color:green"> Configuration Metadata </span>
- BeanFactory가 IoC를 적용하기 위해 사용하는 설정 정보
- IoC 컨테이너에 의해 관리되는 Bean 객체를 생성하고 구성할 때 사용


---

### DI(Dependency Injection)
- 의존성
    - 파라미터나 리턴값 또는 지역변수 등으로 다른 객체를 참조하는 것
- 주입
  -  필요한 객체(의존성)를 전달하여 사용하는 것    


- 의존성 주입(DI)
  - IoC의 구현 방법 중 하나로, **객체가 필요로 하는 의존성을 외부에서 주입 받음**
  - 의존 관계를 빈 설정 정보를 바탕으로 컨테이너가 자동적으로 연결
  - 객체 간의 결합도를 낮출 수 있으며, 이로 인해 유지보수성, 유연성 증가
  - 생성자 주입, 필드 주입, 메서드 주입

- 특징
  - 코드의 재활용성 높임
  - 클래스 간 결합도 낮출 수 있음
  - 코드의 유연성
  - 단위 테스트가 쉬워짐


#### 방법

- 필드 주입
  - 클래스 외부에서 접근이 불가능해 테스트 하기 어려움
    
    ```java
    @Autowired
        private BookDAO bookDAO;
    ```
    
- Setter 주입
  - 변경 가능성이 있는 의존 관계에 사용
    
    ```java
    @Autowired
        public void setBookDAO(BookDAO bookDAO){
            this.bookDAO = bookDAO;
        }
    ```
    
- 생성자 주입
  - **생성자 주입의 이점**
        1. 필드에 final 키워드를 사용할 수 있다.
        2. 순환참조를 스프링 시작(컨테이너 생성 시)과 동시에 확인하고 에러를 발생시켜 준다.
        3. 중간에 값이 오염되지 않음을 확신을 가지고 사용할 수 있다.(불변성)
        4. 테스트 코드 작성 시 테스트 코드에 @Autowired 또는 주입받는 대상의 setter 등을 추가하지 않고 순수 자바 코드로 테스트 가능하다.
       → 생성자는 순수 자바 코드에서도 작동하므로 @Autowired를 생략해도 동작

    ```java
    @Autowired
        public BookService(BookDAO bookDAO) {
            this.bookDAO = bookDAO;
        }
    ```


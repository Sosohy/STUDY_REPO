### Servlet
- 자바를 사용하여 웹 요청을 처리하고 **동적 웹 콘텐츠를 생성**하는 서버 사이드 기술
- 웹 서버와 클라이언트 간의 통신을 처리하는 자바 프로그램
- 주요 기능 
  - 클라이언트 HTTP 요청 수신 및 처리
  - 응답 생성
    - 요청에 대한 적절한 응답을 생성해 클라이언트에게 전송
  - 세션을 통해 클라이언트 상태 관리
  
##### 특징
- Java Thread를 이용하여 동작
- MVC 패턴에서 Controller로 이용
- HTTP 프로토콜 서비스를 지원하는 javax.servlet.http.HttpServlet 클래스를 상속받음
- UDP보다 처리 속도가 느림

#### 서블릿 동작 방식
![](https://velog.velcdn.com/images/hso07202/post/c681191c-e158-4bf8-8d5b-5c214bbba513/image.png)

1. **클라이언트 요청**
   - 웹 브라우저(클라이언트)가 특정 URL에 대해 HTTP 요청을 서버로 보냅니다.

2. **서블릿 컨테이너**
   - 웹 서버는 서블릿 컨테이너와 연동되어 있으며, 서블릿 컨테이너는 요청된 URL에 매핑된 서블릿을 찾습니다.
   - 요청을 전송받은 서블릿 컨테이너는 `HttpServletRequest`, `HttpServletResponse` 객체를 생성합니다.

3. **서블릿 로딩 및 초기화**
   - 서블릿 컨테이너는 요청된 서블릿이 메모리에 로드되어 있는지 확인합니다.
   - 서블릿이 로드되지 않았다면 서블릿 클래스를 메모리에 로드하고, 서블릿의 인스턴스를 생성합니다.
   - `init()` 메소드를 호출하여 서블릿을 초기화합니다. 이 메소드는 서블릿이 최초로 생성될 때 한 번만 호출됩니다.

4. **서비스 요청 처리**
   - `web.xml`을 기반으로 사용자가 요청한 URL이 어느 서블릿에 대한 요청인지 찾습니다.
   - 서블릿 컨테이너는 `service()` 메소드를 호출하여 클라이언트의 GET, POST 여부에 따라 `doGet()` 또는 `doPost()` 메소드를 호출합니다.
   - 서블릿은 `doGet()` 또는 `doPost()` 메소드에서 클라이언트 요청을 처리하고 응답을 생성합니다.

5. **응답 반환**
   - 서블릿은 요청을 처리한 후 `HttpServletResponse` 객체를 사용하여 클라이언트에게 응답을 보냅니다.

6. **객체 소멸**
   - 응답이 끝나면 `HttpServletRequest`, `HttpServletResponse` 두 객체를 소멸시킵니다.

7. **서블릿 종료 및 자원 해제**
   - 서블릿이 더 이상 필요 없을 때, 서블릿 컨테이너는 `destroy()` 메소드를 호출하여 서블릿을 종료하고 자원을 해제합니다.
   - 이 메소드는 서블릿이 언로드될 때 한 번만 호출됩니다.

#### Servlet Container

- 웹 서버 또는 응용 프로그램 서버의 일부로, 웹 서버에서 온 요청을 받아 Servlet class를 관리하는 역할(= 생명 주기 관리)
- Servlet에 대한 Container 설정은 Deployment Descriptor(web.xml) 파일을 이용함
- 클라이언트 요청 처리 및 서블릿 실행 환경 제공하는 컴포넌트

##### 주요 기능
- 서블릿 관리
  - 생명 주기 관리
  - 서블릿 클래스 로드 및 인스턴스 생성
  - 서블릿의 init(), service(), destroy() 메소드를 호출하여 서블릿을 초기화, 요청 처리, 종료
- HTTP 요청 및 응답 처리
- 멀티스레딩 지원
- 서블릿 매핑
- 보안 및 세션 관리
- 라이프사이클 이벤트
  - 서블릿 컨텍스트나 세션의 생성 및 소멸 시에 이벤트를 발생시켜 이를 처리할 수 있는 리스너를 지원

---

#### 서블릿 생명주기

1. 초기화: 서블릿 컨테이너가 서블릿을 메모리에 로드하고 init() 메소드를 호출하여 초기화
2. 요청 처리: service() 메소드를 통해 HTTP 요청에 따라 doGet(), doPost() 등의 메소드를 호출하여 요청 처리
3. 종료: 서블릿이 더 이상 필요 없을 때 destroy() 메소드를 호출하여 서블릿을 종료하고 자원 해제

##### 생명 주기 메소드
- init(): 서블릿이 최초로 로드될 때 실행.
- service(): 클라이언트의 요청 처리
- doGet(): GET 요청 처리
- doPost(): POST 요청 처리
- destroy(): 서블릿이 언로드될 때 실행

---

### 주요 클래스 및 인터페이스
- HttpServlet: 모든 서블릿은 HttpServlet 클래스를 상속받아야 함.
- HttpServletRequest: 클라이언트의 요청 정보를 담고 있음.
- HttpServletResponse: 서버의 응답 정보를 담고 있음.

#### HttpServletRequest
- HTTP Servlet을 위한 요청 정보(request information)를 제공하는 메소드를 지정
- Interface 구현은 컨테이너가 알아서 설정하므로 메소드만 이용

##### 주요 메소드
| method 명 | 내용 |
| --- | --- |
| getParameter(String) | client가 전송한 값의 명칭이 매개변수와 같은 값 가져옴 |
| getParameterNames() | client가 전송한 값의 명칭 가져옴 |
| getParameterValues(String) | client가 전송한 값이 여러 개이면 배열로 가져옴 |
| getParameterMap() | client가 전송한 값 전체를 Map방식으로 가져옴 |
| setAttribute(String, object) | request 객체로 전달할 값을 String 이름-Object 값으로 설정 |
| getAttribute(String) | 매개변수와 동일한 객체 속성 값 가져옴 |
|  removeAttribute(String) | request객체에 저장된 매개변수와 동일한 속성 값 삭제 |
| setCharacterEncoding(String) | 전송 받은 request객체 값들의 CharaterSet 설정 |
| getRequestDispatcher(String) | 컨테이너 내에서 request, response객체를 전송하여 처리한 컴포넌트(jsp파일 등)를 가져옴 (forward() method와 같이 사용) |


#### HttpServletResponse
- 요청에 대한 처리 결과를 작성하기 위해 사용하는 객체
- Interface 구현은 컨테이너가 알아서 설정하므로 메소드만 이용

##### 주요 메소드
| method 명 | 내용 |
| --- | --- |
| setContentType(String) | 응답으로 작성하는 페이지의 MIME type을 설정 |
| setCharacterEncoding(String) | 응답하는 데이터의 CharacterSet을 지정 |
| getWriter() | 페이지에 문자 전송을 위한 Stream을 가져옴 |
| getOutputStream() | 페이지에 byte단위의 전송을 위한 Stream을 가져옴 |
| sendRedirect(String) | client가 매개변수의 페이지를 다시 서버에 요청함 |


---

### `forward()` vs `redirect()`

- forward()
  - 서버 내에서 처리를 하여 클라이언트에 URL 변경 없이 다음 페이지로 이동
  - request 객체를 통해 데이터 공유 가능
- redirect()
  - 클라이언트에게 새로운 URL로 이동하게 하며, URL이 변경
  - 데이터는 주로 URL 파라미터로 전달
  
![](https://velog.velcdn.com/images/hso07202/post/1f351755-1007-4875-b373-ba207615a2b3/image.png)


| 구분         | **forward()**                          | **redirect()**                          |
|--------------|---------------------------------------|-----------------------------------------|
| **정의**     | 요청을 다른 서블릿이나 JSP로 **전달** | 클라이언트에게 새로운 URL로 **전송**  |
| **작동 방식**| 서버 내에서 요청을 처리하며, URL은 변경되지 않음 | 클라이언트에게 새로운 요청을 하도록 지시, URL이 변경됨 |
| **사용 예**  | 내부 로직 처리 후 다음 페이지로 이동 시 | 로그인 후 메인 페이지로 이동 시      |
| **성능**     | 서버 내에서 처리되므로 성능이 좋음   | 추가 요청이 발생하므로 성능이 다소 떨어질 수 있음 |
| **데이터 전송** | `request` 객체를 통해 데이터 공유 가능 | URL 파라미터로만 데이터 전달 가능     |

---

### Servlet Filter
- javax.servlet.Filter Interface를 상속 받아 구현하는 Class
- HTTP 요청과 응답 사이에서 전달되는 데이터를 가로채어, 서비스에 맞게 변경하고 걸러내는 필터링 작업을 수행

##### 처리 내용
- Request에 대한 처리
    - 보안 관련 사항
    - 요청 header와 body 형식 지정
    - 요청에 대한 log 기록 유지
    
- Response에 대한 처리
    - 응답 stream 압축
    - 응답 stream 내용 추가 및 수정
    - 새로운 응답 작성
    
     + 여러 가지 필터를 연결(= chain, 서로 호출)하여 사용 가능
     
#### 동작
![](https://velog.velcdn.com/images/hso07202/post/0af9562f-54d6-4537-af82-83d179e804e6/image.png)

##### 주요 메소드
| 메소드                        | 설명                                                     |
|-------------------------------|--------------------------------------------------------|
| `doFilter(ServletRequest request, ServletResponse response, FilterChain chain)` | 요청과 응답을 가로채고 다음 필터 또는 서블릿으로 전달. |
| `init(FilterConfig filterConfig)`               | 필터 초기화 시 호출됨.                                 |
| `destroy()`                                     | 필터가 제거될 때 호출됨.                               |


### Wrapper
- 관련 클래스(ServletRequest, ServletResponse, HttpServletRequest,
HttpServletResponse)를 내부에 보관하며 해당 인터페이스를 구현한 객체를 참조하여 구현 메소드를 위임
- 요청 또는 응답의 데이터를 수정하거나, 추가적인 정보를 포함시키는 데 사용

---

### Servlet Listener
- 웹 애플리케이션의 특정 이벤트를 감지하고 처리하기 위해 사용
- 애플리케이션의 상태를 유지하고 필요한 작업을 자동으로 수행할 수 있음

##### Servlet Listener 종류
- ServletContextListener
  애플리케이션의 시작과 종료 이벤트를 감지.
  - contextInitialized(), contextDestroyed()
- ServletRequestListener
  HTTP 요청의 시작과 완료 이벤트를 감지.
  - requestInitialized(), requestDestroyed()
- HttpSessionListener
  HTTP 세션의 생성과 종료 이벤트를 감지.
  - sessionCreated(), sessionDestroyed()
- ServletContextAttributeListener
  서블릿 컨텍스트의 속성 변경 이벤트를 감지.
  - attributeAdded(), attributeRemoved(), attributeReplaced()
- HttpSessionAttributeListener
  세션의 속성 변경 이벤트를 감지.
  - attributeAdded(), attributeRemoved(), attributeReplaced()

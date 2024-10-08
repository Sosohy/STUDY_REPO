- M(Model): 애플리케이션의 데이터와 비즈니스 로직을 관리
  - 데이터 저장, 처리, 조작
  - 도메인 객체, DB와의 상호작용을 담당하는 객체 등 포함
  - 뷰에서 사용할 데이터를 제공하지만 직접적 참조X
  
- V(View): 사용자에게 데이터를 보여주는 역할
  - 모델로부터 전달받은 데이터를 기반으로 화면을 구성
  - HTML, JSP, Thymeleaf, FreeMarker 등의 템플릿 엔진을 사용하여 데이터를 렌더링
  - 사용자 인터페이스(UI)를 표현하지만, 비즈니스 로직은 포함X
  
- C(Controller):  사용자 입력을 처리하고, 모델과 뷰를 연결하는 역할
  - 사용자의 요청을 받아 적절한 서비스를 호출하고, 결과를 모델에 저장
  - 어떤 뷰를 사용할지 결정하고, 뷰에 필요한 데이터를 전달
  - 비즈니스 로직을 직접 수행하지 않고, 모델과 서비스를 통해 처리
  

 
### 처리 과정

![](https://velog.velcdn.com/images/hso07202/post/ec818306-0383-4724-bb7a-9c740ec72981/image.png)

1. **클라이언트 요청**: 사용자가 웹 브라우저에서 URL을 입력하거나 폼을 제출하여 HTTP 요청을 보냄.
2. **디스패처 서블릿**: 모든 요청을 `DispatcherServlet`으로 전달하여 중앙 집중식 처리.
3. **핸들러 매핑**: 요청 URL을 기반으로 적절한 컨트롤러 메서드 찾기.
4. **핸들러 어댑터**: 선택된 컨트롤러 메서드를 실행.
5. **컨트롤러**: 비즈니스 로직 처리 및 모델에 결과 저장, View 이름 반환.
6. **모델**: 뷰에 데이터를 전달하기 위한 컨테이너 역할.
7. **뷰 리졸버**: 뷰 이름을 실제 뷰로 변환 및 렌더링.
8. **뷰**: 모델 데이터를 사용하여 HTML 등의 응답 생성.
9. **응답 반환**: 생성된 응답을 클라이언트(웹 브라우저)로 전송.






## MVC 패턴

![](https://velog.velcdn.com/images/hso07202/post/26f78395-cc78-485a-85a0-5cdca7d45d30/image.png)


출처 : [[https://velog.io/@jw01987/MVC-패턴](https://velog.io/@jw01987/MVC-%ED%8C%A8%ED%84%B4)]

- 모델, 뷰, 컨트롤러로 이뤄진 디자인 패턴
    - 모델 : 애플리케이션의 데이터(DB, 상수, 변수 등)
    - 뷰 : 사용자 인터페이스 요소 → 모델을 기반으로 사용자가 볼 수 있는 화면
    - 컨트롤러 : 하나 이상의 모델과 하나 이상의 뷰를 잇는 다리 역할 → 메인 로직 담당

- 예시 코드
    
    ```java
    // Model (데이터 및 로직)
    class Model {
        private String data;
    
        public String getData() {
            return data;
        }
    
        public void setData(String data) {
            this.data = data;
        }
    }
    
    // View (UI)
    class View {
        public void display(String data) {
            System.out.println("Displaying: " + data);
        }
    }
    
    // Controller (사용자 요청 처리 및 데이터 전달)
    class Controller {
        private Model model;
        private View view;
    
        public Controller(Model model, View view) {
            this.model = model;
            this.view = view;
        }
    
        public void setData(String data) {
            model.setData(data);  // 모델에 데이터 설정
        }
    
        public void updateView() {
            view.display(model.getData());  // 뷰에 데이터 전달
        }
    }
    
    // 클라이언트 코드
    public class MVCPatternExample {
        public static void main(String[] args) {
            Model model = new Model();
            View view = new View();
            Controller controller = new Controller(model, view);
    
            controller.setData("Hello, MVC Pattern!");  // 모델 데이터 설정
            controller.updateView();  // 뷰 업데이트
        }
    }
    
    ```
    

---

- MVP 패턴
    - MVC에서 C에 해당하는 컨트롤러가 프레젠터로 교체된 패턴
    - 뷰와 프레젠터는 일대일 관계 → MVC 패턴보다 더 강한 경합을 지닌 디자인 패턴
- MVVM
    - MVC에서 C에 해당하는 컨트롤러가 뷰모델로 바뀐 패턴
        - 뷰모델은 뷰를 더 추상화한 계층
        - 커맨드와 데이터 바인딩을 가지는 것이 특징임
        - 뷰와 뷰모델 사이의 데이터 바인딩 지원
    - Vue.js가 해당 패턴을 가지고 있음

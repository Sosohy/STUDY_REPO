## 옵저버 패턴

![](https://velog.velcdn.com/images/hso07202/post/0bc3f5c9-f255-4d01-9c93-b599fe4d37d0/image.png)


출처 : [[https://medium.com/@jiyeeon1208/옵저버-패턴-observer-pattern-d4368116e279](https://medium.com/@jiyeeon1208/%EC%98%B5%EC%A0%80%EB%B2%84-%ED%8C%A8%ED%84%B4-observer-pattern-d4368116e279)]

- 어떤 객체의 상태 변화를 관찰하다가 상태 변화 시 메서드 등을 통해 옵저버 목록에 있는 옵저버들에게 변화를 알려주는 디자인 패턴
    - 주체 : 객체의 상태 변화를 보고 있는 관찰자.
    - 옵저버 : 객체의 상태 변화에 따라 추가 변화 사항이 생기는 객체
- 주로 이벤트 기반 시스템에 사용, MVC 패턴에도 사용됨
    - 모델에서 변경 사항 → update를 뷰에게 알려주고 → 이를 기반으로 컨트롤러 등이 작동

### 장점

- 느슨한 결합 : 주제와 옵저버 간의 결합도가 낮음
- 동적 연결 : 런타임에 옵저버 동적으로 추가/제거 가능
- 상태 변경 시, 자동으로 알림이 전달되므로 상태 변경 관리가 간편해짐

### 단점

- 복잡성 증가 → 많은 옵저버 등록 시 알림 시간 증가 및 코드 복잡
- 옵저버가 많아질수록, 상태를 변경할 때 어떤 옵저버가 어떻게 반응할지 예측 어려움
- 알림을 보낼 때 성능 저하가 발생할 수 있음

- 예시 코드
    
    ```java
    // 1. 옵저버 인터페이스 (Observer)
    interface Observer {
        void update(String message);
    }
    
    // 2. 주제 인터페이스 (Subject)
    interface Subject {
        void addObserver(Observer observer);
        void removeObserver(Observer observer);
        void notifyObservers();
    }
    
    // 3. 구체적인 주제 (ConcreteSubject)
    class NewsAgency implements Subject {
        private List<Observer> observers = new ArrayList<>();
        private String news;
    
        public void setNews(String news) {
            this.news = news;
            notifyObservers();  // 뉴스가 업데이트되면 옵저버들에게 알림
        }
    
        @Override
        public void addObserver(Observer observer) {
            observers.add(observer);
        }
    
        @Override
        public void removeObserver(Observer observer) {
            observers.remove(observer);
        }
    
        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(news);
            }
        }
    }
    
    // 4. 구체적인 옵저버 (ConcreteObserver)
    class NewsSubscriber implements Observer {
        private String name;
    
        public NewsSubscriber(String name) {
            this.name = name;
        }
    
        @Override
        public void update(String message) {
            System.out.println(name + " received news: " + message);
        }
    }
    
    // 5. 클라이언트 코드
    public class Main {
        public static void main(String[] args) {
            NewsAgency newsAgency = new NewsAgency();
            NewsSubscriber subscriber1 = new NewsSubscriber("Subscriber 1");
            NewsSubscriber subscriber2 = new NewsSubscriber("Subscriber 2");
    
            newsAgency.addObserver(subscriber1);
            newsAgency.addObserver(subscriber2);
    
            newsAgency.setNews("Breaking News: New Observer Pattern Example!");
        }
    }
    
    ```
    

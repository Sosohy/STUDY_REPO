### Stream
- 컬렉션에 저장된 엘리먼트들을 하나씩 순회하면서 처리할 수 있는 기능
- 람다식과 함께 사용 가능
- 컬렉션에 들어있는 데이터에 대한 처리 간결하게 표현 가능
- 자바 8부터 추가
- 사용 이유
  - 배열 또는 컬렉션을 함수 여러 개를 사용해 결과를 쉽게 얻을 수 있음
  - 람다식을 활용해 코드 양을 줄이고 간결하게 표현 가능
  - 내부 반복자를 사용하기 때문에 병렬처리가 가능함
  
```java
public static void main(String[] args) {

    List<String> stringList = new ArrayList<String>(Arrays.asList("hello", "stream", "world"));

    stringList.stream()
            .filter("stream"::equals)
            .forEach(str -> System.out.println("걸러낸 값 : " + str));
}
```

#### 특징
- 스트림은 원본을 변경하지 않는 읽기 전용
- iterator처럼 한 번만 사용되고 사라짐 -> 필요시 다시 생성해야 함
- 최종 연산 전까지 중간 연산이 처리되지 않음
- 병렬처리가 용이함

#### 활용
- 스트림은 크게 생성, 가공, 결과 3가지로 구분
 - 생성 : 스트림 생성
 - 가공 : 원하는 결과를 만들기 위한 필터링, 매핑 등의 작업
 - 결과 : 최종 결과를 만들어 내는 작업
```java
배열, 컬렉션 -> 스트림 생성 -> 매핑 -> 필터링 -> 결과
```

---

#### 생성
| 스트림 생성 메소드                                | 설명                                                                 |
|--------------------------------------------------|----------------------------------------------------------------------|
| **Stream.of(T... values)**                       | 주어진 값들로부터 스트림 생성                                        |
| **Arrays.stream(T[] array)**                     | 배열로부터 스트림 생성                                               |
| **Collection.stream()**                          | 컬렉션으로부터 스트림 생성                                           |
| **Stream.generate(Supplier<T> s)**               | Supplier를 사용하여 스트림 생성                                      |
| **Stream.iterate(T seed, UnaryOperator<T> f)**   | 초기값과 함수로 스트림 생성                                          |
| **BufferedReader.lines()**                       | 파일의 각 라인으로부터 스트림 생성                                   |
| **Pattern.splitAsStream(CharSequence input)**    | 문자열을 패턴으로 분할하여 스트림 생성                               |
| **Stream.empty()**                               | 빈 스트림 생성   |



#### 가공
- 스트림에 있는 데이터에 대해 내가 원하는 결과를 만들기 위한 중간 처리 작업

| 메소드                                        | 설명                                                         |
|-----------------------------------------------|--------------------------------------------------------------|
| **filter(Predicate<T> predicate)**            | 주어진 조건을 만족하는 요소만 통과                             |
| **map(Function<T, R> mapper)**                | 각 요소를 주어진 함수에 적용하여 변환                          |
| **flatMap(Function<T, Stream<R>> mapper)**    | 각 요소를 스트림으로 변환하고 하나의 스트림으로 평탄화           |
| **distinct()**                                | 중복 요소 제거                                                |
| **sorted()**                                  | 요소 정렬                                                     |
| **peek(Consumer<T> action)**                  | 각 요소에 대해 추가 작업 수행 (디버깅용)                       |



#### 결과

| 메소드                                    | 설명                                              |
|-------------------------------------------|---------------------------------------------------|
| **forEach(Consumer<T> action)**           | 각 요소에 대해 작업 수행                           |
| **collect(Collector<T, A, R> collector)** | 스트림의 요소를 컬렉션으로 수집                    |
| **reduce(BinaryOperator<T> accumulator)** | 스트림의 요소를 하나로 결합                        |
| **count()**                               | 요소의 개수 반환                                  |
| **anyMatch(Predicate<T> predicate)**      | 조건을 만족하는 요소가 있는지 여부 반환            |
| **allMatch(Predicate<T> predicate)**      | 모든 요소가 조건을 만족하는지 여부 반환            |
| **noneMatch(Predicate<T> predicate)**     | 모든 요소가 조건을 만족하지 않는지 여부 반환       |
| **findFirst()**                           | 첫 번째 요소 반환                                  |
| **findAny()**                             | 아무거나 하나의 요소 반환 (병렬 스트림에서 유용)   |



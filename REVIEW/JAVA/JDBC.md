### JDBC(Java Database Connectivity)
- 자바에서 데이터베이스에 연결하고 SQL 쿼리를 실행하기 위한 API
- 데이터베이스에 독립적인 방식으로 접근할 수 있게 해줌
- 주요 기능
  - 데이터베이스 연결
  - SQL 실행, 결과 처리
  - 트랜잭션 관리
  
![](https://velog.velcdn.com/images/hso07202/post/c1bd8c0e-9573-4d61-9f9c-99a3ec571152/image.png)

---

### 주요 클래스 및 인터페이스

#### DriverManager
- DB에 JDBC driver를 통해 커넥션을 만드는 역할을 함
  - 데이터베이스 드라이버를 로드하고, 데이터베이스 연결을 관리
- Class.forName() method를 통해 생성되어 메모리에 할당
  - Class.forName()에서 Class 클래스는 클래스의 메타 정보를 가지고 있음
  - forName() 메소드에 풀클래스명을 작성하면 해당 클래스를 메모리에 올려 사용할 준비를 하도록 하는 것으로, 동적 로딩을 이용하여 DB driver를 로딩

##### <span style="color:indianred"> 주의사항 </span>
- 반드시 예외처리를 해야 함
- 직접 instance 생성이 불가하고, DriverManager 클래스의 getConnection() 메소드를 사용하여 Connection instance 생성 가능

```java
Connection connection = DriverManager.getConnection(url, user, password);
```

#### Connection
- 데이터베이스와의 연결을 나타내는 객체
- 쿼리문을 실행할 수 있는 Statement 또는 PreparedStatement 객체를 생성할 수 있는 기능 제공
  - Connection instance를 생성하고 createStatement() 메소드를 호출하여 Statement instance 생성 가능
  - SQL문 실행 전, Connection instance가 있어야 함

##### 활용
- Connection 객체 생성 시 생성 전에 설정한 데이터베이스 주소로 ping을 보내 연결이 정상일 경우에 객체를 생성
- 사용 후 반드시 반납해야 함


```java
public class JDBCTemplate {

    public static Connection getConnection() {
        Connection con = DriverManager.getConnection(url, user, password);
        
        return con;
    }

	public static void close(Connection con) {
        try {
            if(con != null & !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
```

#### Statement
- SQL 쿼리를 실행하기 위한 객체
  - SQL문을 저장하고 실행한 뒤 결과를 받아 반환해주는 메소드들이 묶여 있는 타입의 클래스
- Connection class의 createStatement() 메소드를 호출하여 Statement instance 생성
- 생성한 instance의  executeQuery() 메소드를 호출하여 SQL문 수행

```java
try {
	String query = "SELECT ID, LAST_NAME FROM EMP";
	stmt = conn.createStatement(); // conn = Connection 객체
	rset = stmt.executeQuery(query);
} catch (SQLException e) {
	e.printStackTrace();
}
```

#### PreparedStatement
- 파라미터화된 SQL 쿼리를 실행하기 위한 객체
- 완성된 쿼리문과 미완성된 쿼리문(= 위치홀더를 사용한 쿼리문)을 모두 사용 가능

##### 장점
- 수행 속도가 빠름
  - Statement는  SQL문 실행 시 쿼리문을 전달하므로, 매번 새로운 쿼리로 인식하기 때문에 조건값에 따라 컴파일을 새로 해야 함
  -  PreparedStatement는 조건값을 ?로 두고 쿼리를 준비시킨 뒤, 쿼리는 변경하지 않고 변경되지 않으므로 바인딩 되는 변수만 바꿔 조회
    <span style="color:indianred"> -> 한번 컴파일한 뒤 캐시에 담아두고 수행 </span>
- SQL injection 공격에 대하여 안전
  - Statement 사용 시 전달하는 조건 변수에 OR 1=1 조건을 작성하면 시스템이 제공하는 의도와 다르게 데이터가 조회될 수 있음
  - PreparedStatement와 위치홀더를 사용하면, 조건으로 세팅되는 값을 메소드의 지정 형식에 따라 알아서 처리함

```java
try {
	String query = "INSERT INTO MEMBER VALUES(?, ?)";
	pstmt = conn.preparedStatement(query);
	pstmt.setString(1, id);
	pstmt.setString(2, password);
	rset = pstmt.executeQuery();
} catch (SQLException e) {
	e.printStackTrace();
}
```

> 👾 SQL 인젝션
- 악의적으로 SQL문을 실행되게 하여 Database를 비정상적으로 조작하는 코드 주입 공격

#### ResultSet
- SELECT문 수행 성공 시 반환한 결과값을 받아오는 객체
- SQL문에 의해 생성된 결과 테이블을 담고 있음
- 커서로 특정 행에 대한 참조 조작을 할 수 있음

![](https://velog.velcdn.com/images/hso07202/post/2fbb5757-cc57-4085-97fe-879b0e42e3a0/image.png)

##### 메소드
- getString()
    - ResultSet의 현재 커서 위치에 존재하는 로우에서 인자로 전달한 컬럼의 결과 값을 가지고 옴
    - **get*자료형*(”*컬럼명*”)** 형식
- next()
    - ResultSet의 커서 위치를 하나 내리면서, 다음 행이 존재하면 true / 존재하지 않으면 false 반환
    
```java
while(rset.next()) {
    System.out.println(rset.getString("EMP_ID") + ", " + rset.getString("EMP_NAME"));
}
```

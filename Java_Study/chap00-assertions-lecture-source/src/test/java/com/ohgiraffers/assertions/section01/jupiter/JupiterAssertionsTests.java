package com.ohgiraffers.assertions.section01.jupiter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JupiterAssertionsTests {

    /* 수업목표. junit5에서 제공하는 Assertions에서 제공하는 메소드에 대해 이해하고 활용할 수 있다. */

    /* 목차 1. assertEquals */
    /* 필기. assertEquals(expected, actual) 메소드는 실제 값과 기대 값의 일치 여부를 동일성으로 판단한다. */
    @Test
    public void testAssertEquals(){

        /* 설명 1. given */
        int firstNum = 10;
        int secondNum = 20;
        int expected = 31;

        /* 설명 2. when */
        Calculator calculator = new Calculator();
        int result = calculator.plusTwoNums(firstNum, secondNum);

        /* 설명 3. then */
//        Assertions.assertEquals(expected, result);
//        Assertions.assertEquals(expected, result, 2);          // delta -> 오차범위
        Assertions.assertEquals(expected, result,"정확해야 함!.!");
    }

    /* 목차 2. assertNotEquals */
    /* 필기. assertNotEquals(expected, actual) 메소드는 실제 값과 기대 값의 불일치 여부를 동일성으로 판단한다.  */
    @Test
    @DisplayName("인스턴스 동일성 비교 테스트")
    void testAssertNotEqualsWithInstance(){

        //given
        Object obj1 = new Object();

        //when
        Object obj2 = new Object();

        //then
        Assertions.assertNotEquals(obj1, obj2);

        /* 설명. equals()와 hashCode()가 오버라이딩 되어 있다면 동등비교로 판단한다. */
    }

    /* 목차 3. assertNotNull */
    @Test
    @DisplayName("null인지 테스트")
    void testAssertNUll(){
        String str;
        str = null;

        Assertions.assertNull(str);
    }

    /* 목차 4. assertNotNull */
    @Test
    @DisplayName("null 아닌지 테스트")
    void testAssertNotNUll(){
        String str;
        str = "java";

        Assertions.assertNotNull(str);
    }

    /* 목차 5. 자주 쓰는 나머지 간단한 단정문 */
    /* 설명. assertTrue(), assertFalse() */

    /* 목차 6. assertAll */
    @Test
    @DisplayName("동시에 여러 가지 값에 대한 검증을 수행하는 경우 테스트")
    void testAssertAll(){

        //given
        String firstName = "길동";
        String lastName = "홍";

        // when
        Person person = new Person(firstName, lastName);

        // then
        Assertions.assertAll(
                "그룹화된 테스트의 이름(테스트 실패 시 보여짐)",
                () -> Assertions.assertEquals(firstName, person.getFirstName(), () -> "firstName 잘못됨"),
                () -> Assertions.assertEquals(lastName, person.getLastName(), () -> "lastName 잘못됨")
        );
    }

    /* 목차 7. assertThrows */
    @Test
    @DisplayName("void 메소드의 경우 exception이 발생하는지 테스트")
    void testAssertThrows(){

        int firstNum = 10;
        int secondNum = 0;
        String expectedErrorMsg = "0으로 나눌 수 없습니다.";

        PositiveNumberValidator validator = new PositiveNumberValidator();
        Exception exception = Assertions.assertThrows(
                Exception.class,
                () -> validator.checkDividableNumbers(firstNum, secondNum)
        );

        Assertions.assertAll(
                () -> Assertions.assertInstanceOf(IllegalArgumentException.class, exception, ()->"예외타입 일치X"),
                () -> Assertions.assertEquals(expectedErrorMsg, exception.getMessage(), () -> "예외메시지 일치X")
        );
    }
}

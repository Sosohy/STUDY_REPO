package com.ohgiraffers.section02.variable;

public class Application3 {
    public static void main(String[] args) {

        /* 수업목표. 변수의 명명 규칙에 대해 이해할 수 있다. */
        /* 필기
         *  변수의 명명 규칙
         *  변수의 이름을 지을 때 아무거나 짓는 것이 아닌 정해진 규칙이 있다.
         *  실무적으로는 굉장히 중요하기 때문에 반드시 숙지 필요
         *  또한 규칙에 맞는 올바른 변수명을 짓는 것이 좋은 프로그래밍을 하는 첫 단계
        * */

        /* 목차 1. 컴파일 에러를 발생시키는 규칙 */
        /* 1-1. 동일한 범위 내에서 동일한 변수명을 가질 수 없다. */
        int age = 20;
        // int age; -> 같은 지역 내에서 같은 변수명 사용 불가

        /* 1-2. 예약어는 사용이 불가능하다. */
        // int true = 1;               // -> 이미 문법으로 존재하므로 에러남
        // int for;

        /* 1-3. 변수명은 대소문자를 구분한다. */
        int aGe = 20;

        /* 1-4. 변수명은 숫자로 시작할 수 없다. */
        // int 3age = 20;
        int age3 = 20;

        /* 1-5. 특수기호로는 '_', '$'만 사용 가능 */
        int _age = 20;
        int $harp = 20;
        //int #age;                    // 이외 문자는 실행 안됨

        /* 목차 2. 컴파일 에러를 발생시키지는 않지만 개발자들 간의 암묵적인 규칙(관례상 규칙) */

        /* 2-1. 변수명의 길이 제한은 없는데 적당히 하기~ */
        int qwertyuiosdfghjkzxcvbnmnbvcxzasdf;

        /* 2-2. 변수명이 합성어로 이루어진 경우 -> 첫 단어는 소문자, 두번째 시작 단어는 대문자로 시작 */
        int maxAge = 60;              // 낙타봉 표기법(camel case)
        int minAge = 10;
        // int max_age;

        /* 2-3. 한글로 변수명을 짓는 것은 가능하지만, 권장하지 않는다. */
        int 나이 = 19;

        /* 2-4. 변수 안에 저장될 값을 고려하여 의미있고 명확한 이름으로 작성한다. */
        // String s;
        String name = "hansohye";

        /* 2-5. 명사형으로 작성할 수 있도록 한다. */
        //String goHome;
        String home;

        /* 2-6. boolean 자료형은 긍정의문문 형태로 작성 */
        boolean isAlive = true;
        boolean isDead = false;
        
    }
}

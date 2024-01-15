package com.ohgiraffers.section02.looping;

public class Application {

    public static void main(String[] args) {

        A_for aClass = new A_for();

        /* 필기. 단독 for문 */
//        aClass.testSimpleForStatement();

        /* 필기. 반복문을 사용하는 예제(반복문 필요성)  */
//        aClass.testForExample1();
//        aClass.testForExample2();

        B_nestedFor bClass = new B_nestedFor();

        /* 필기. 중첩 반복문 사용 예제 */
//        bClass.printGugudanFromTwoToNine();
//        bClass.printUpgradeGugudan();

        /* 별찍기 관련 예제 */
//        bClass.printStars();

        C_While cClass = new C_While();

        /* 필기. 단독 while문 */
//        cClass.testSimpleWhileStatement();

        /* while문 사용하는 예제 */
//        cClass.testWhileExample();

        /* do-while */
        D_doWhile dClass = new D_doWhile();

        /* 필기. 단독 do-while문 */
//        dClass.testSimpleDoWhileStatement();

        /* do-while문 사용 예제 */
        dClass.testDoWhileExample();
    }
}

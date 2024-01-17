package com.ohgiraffers.section05.parameter;

import java.util.Arrays;

public class ParameterTest {


    public void testPrimitiveTypeParameter(int num) {
        System.out.println("매개변수로 전달받은 값 : " + num);
        num = 10;
    }

    public void testPrimitiveTypeArrayParameter(int[] iArr) {
        iArr[0] = 100;
    }

    public void testClassTypeParameter(Rectangle r) {

        /* 전달받은 객체의 사각형 넓이와 둘레 출력 */
        System.out.println("변경 전");
        r.calRound();
        r.calArea();

        /* 전달받은 객체의 사각형 너비와 높이 변경 */
        r.setHeight(40);
        r.setWidth(20);

        /* 변경 후 사각형의 넓이와 둘레 출력 */
        System.out.println("변경 후");
        r.calRound();
        r.calArea();
    }

    public void testVariableLengthArrayParameter(String... str) {   // String... 가변인자
        System.out.println(Arrays.toString(str));
    }
}

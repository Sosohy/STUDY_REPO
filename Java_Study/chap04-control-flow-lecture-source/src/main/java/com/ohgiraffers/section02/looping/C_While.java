package com.ohgiraffers.section02.looping;

import java.util.Scanner;

public class C_While {
    public void testSimpleWhileStatement() {

        /* 수업목표. while문 단독 사용에 대한 흐름을 이해하고 적용할 수 있다. */
        int i = 1;
        while(i <= 10){
            System.out.println(i);
            i++;
        }

    }

    public void testWhileExample() {

        /* 수업목표. 사용자가 'y'라고 입력할 때까지 반복해서 확인하는 예제 */
        Scanner sc = new Scanner(System.in);

        char user = '\u0000';              // while 조건식에 활용하기 위해 변수를 미리 선언(char 초기값 설정)
        while(!(user == 'y' || user == 'Y')){
            System.out.print("y 또는 Y 입력 시, 프로그램 종료 : ");
            user = sc.next().charAt(0);
        }
        System.out.println("-------프로그램 종료-------");
    }
}

package com.ohgiraffers.section02.encapsulation.problem1;

public class Application {

    public static void main(String[] args) {

        /* 수업목표. 필드에 직접 접근하는 경우 발생할수 있는 문제점을 이해할 수 있다. */

        /* 1번 몬스터 생성 */
        Monster monster1 = new Monster();
        monster1.name = "두치";         // 참조연산자(.) 통해 값 대입
        monster1.hp = 200;

        /* 1번 몬스터 정보 출력 */
        System.out.println("몬스터 이름 : " + monster1.name);
        System.out.println("몬스터 체력 : " + monster1.hp);

        /* 2번 몬스터 생성(문제점 확인)*/
        Monster monster2 = new Monster();
        monster2.name = "뿌꾸";
        monster2.hp = -200;       // 마이너스 세팅 되면 안되는데 할당했음

        System.out.println("몬스터 이름 : " + monster2.name);
        System.out.println("몬스터 체력 : " + monster2.hp);

        /* 3번 몬스터 생성(setter를 통한 접근) */
        Monster monster3 = new Monster();
        monster3.name = "드라큘라";
        monster3.setHp(100);      // monster3의 hp공간에 100이 할당.

        /* 4번 몬스터 생성 */
        Monster monster4 = new Monster();
        monster4.name = "프랑켄슈타인";
        monster4.setHp(-100);

        monster1.print();
        monster2.print();
        monster3.print();
        monster4.print();
    }
}
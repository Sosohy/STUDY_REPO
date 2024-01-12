package com.ohgiraffers.section04.scanner;
import java.util.Scanner;

public class Application1 {

    public static void main(String[] args) {

        /* 수업목표. java.uitl.Scanner를 이용한 다양한 자료형 값 입력 받기 */
        Scanner sc = new Scanner(System.in);

        /* 목차 1. 문자열 입력받기 */
        System.out.print("이름 입력 : ");
        String str1 = sc.next();                  // 공백이나 개행 전까지 문자열 반환
        String str2 = sc.nextLine();              // 공백이나 개행을 포함한 한 줄의 문자열 모두 반환
        System.out.println("이름 : " + str1);

        /* 목차 2. 정수형 입력받기 */
        System.out.print("나이 입력 : ");
        int inum = sc.nextInt();
        System.out.println("나이 : " + inum);

        /* 목차 3. 실수형 입력받기 */
        System.out.print("키 입력 : ");
        double dnum = sc.nextDouble();
        System.out.println("키 : " + dnum);

        /* 목차 4. 논리형 입력받기 */
        System.out.print("true 또는 false 입력 : ");
        boolean isTrue = sc.nextBoolean();
        System.out.println("논리값 : " + isTrue);

//        sc.nextLine();                            // 뒤에 nextLine() 쓸거면 중간에 버퍼에 남은 공백 및 개행 제거용 nextLine()

        /* 목차 5. 문자형 입력받기 */
        System.out.print("문자 입력 : ");
        // 메소드 체이닝 방식으로 사용자의 입력 값에서 인덱스번째의 문자를 char형으로 반환
        char ch = sc.next().charAt(0);            // nextLine()쓰면 버퍼에서 사라지지 않은 엔터가 적용돼서 입력값 없음
        System.out.println(ch);
    }
}

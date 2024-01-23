package com.ohgiraffers.section01.list.run;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Application3 {

    public static void main(String[] args) {

        /* 수업목표. LinkedList에 대해 이해하고 활용할 수 있다. */
        List<String> linkedList = new LinkedList<>();
        linkedList.add("apple");
        linkedList.add("orange");
        linkedList.add("banana");
        linkedList.add("mango");
        linkedList.add("grape");

        /* 설명. List계열 출력하는 4가지 방법 */
        /* 1. toString() 활용하기 */
        System.out.println(linkedList);
        System.out.println("==================");

        /* 2. for문 활용 */
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
        System.out.println("==================");

        /* 3. for-each문 활용 */
        for(String str : linkedList){
            System.out.println(str);
        }
        System.out.println("==================");

        /* 4. iterator 활용 */
        /* 반복문 안에서 next() 두번 이상 사용하게 될 경우 의도한 것이 아니라면 유의한다.(변수 활용) */
        Iterator<String> iter = linkedList.iterator();
        while (iter.hasNext()){
            String fruit = iter.next();            // 커서 옮기기까지 포함
            System.out.println(fruit);
        }

        linkedList.set(1, "pineapple");
        System.out.println(linkedList);

        /* 설명. list가 관리하는 요소들 제거 */
        linkedList.clear();                        // null과는 다름 -> 요소만 없는 것
        System.out.println(linkedList);

        /* 설명. 요소가 없는 list객체에 대해 boolean값으로 확인 */
        System.out.println(linkedList.isEmpty());  // 객체는 생성 되는데 비어있음
    }
}

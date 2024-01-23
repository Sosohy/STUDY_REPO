package com.ohgiraffers.section02.set.run;

import java.util.*;

public class Application3 {

    public static void main(String[] args) {

        /* 수업목표. TreeSet에 대해 이해하고 활용할 수 있다. */
        Set<String> tSet = new TreeSet<>();   // 중복제거 및 정렬
        tSet.add("ramen");
        tSet.add("pork");
        tSet.add("kimchi");
        tSet.add("friedEgg");
        tSet.add("chicken");
        
        System.out.println("tSet = " + tSet);

        /* 설명. 중복되지 않는 번호를 발생시켜 로또 번호 발생기 만들기(treeSet 사용X) */
        int[] dup = new int[46];
//        List<Integer> dup = new ArrayList<>();
        int[] lottoArr = new int[6];
        int idx = 0;
        while(idx < 6){
            int n =  (int)(Math.random()*45)+1;
//            if(dup.indexOf(n) == -1){
//                lottoArr[idx++] = n;
//                dup.add(n);
//            }
            if(dup[n] == 0) {
                lottoArr[idx++] = n;
                dup[n] = 1;
            }
        }
        Arrays.sort(lottoArr);
        System.out.println("lottoArr = " + Arrays.toString(lottoArr));


        Set<Integer> lotto = new TreeSet<>();

        /* 설명. 1-45까지의 6자리 중복되지 않는 난수를 발생하여 값 저장 */
        while (lotto.size() < 6){
            lotto.add((int)(Math.random()*45)+1);
        }
        /* 설명. 출력 시에는 오름차순으로 출력 되도록 작성 */
        System.out.println("lotto = " + lotto);

    }
}

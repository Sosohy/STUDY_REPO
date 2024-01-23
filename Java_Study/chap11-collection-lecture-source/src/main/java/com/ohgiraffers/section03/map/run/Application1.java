package com.ohgiraffers.section03.map.run;

import java.util.*;

public class Application1 {

    public static void main(String[] args) {

        /* 수업목표. Map의 자료구조에 대해 이해하고 HashMap을 이용할 수 있다.  */
        Map<Object, Object> hMap = new HashMap<>();
        hMap.put("one", new Date());
        hMap.put(12, "red apple");
        hMap.put(33, 123);

        System.out.println("Key가 \"one\"인 value : " + hMap.get("one"));
        System.out.println("map toString() : " + hMap);

        /* 설명. 키 값은 중복되면 이후 put 되는 키와 밸류가 덮어씌운다. **주의** */
        hMap.put(12, "purple Banana");
        System.out.println(hMap.get(12));

        /* 설명. value 중복 상관없음 */
        hMap.put(77, "purple Banana");
        System.out.println(hMap);

        System.out.println("map이 지닌 enrtry의 수 : " + hMap.size());

        System.out.println("77번 키와 관련된 entry 삭제 : " + hMap.remove(77));
        System.out.println("삭제 후 enrtry의 수 : " + hMap.size());
        System.out.println("===========================");

        /* 필기. Map을 반복하여 각 entry들(키와 value)을 활용 */
        HashMap<String, String> hMap2 = new HashMap<>();

        hMap2.put("one", "java17");
        hMap2.put("two", "DB10");
        hMap2.put("three", "servlet/jsp");
        hMap2.put("four", "springBoot3.0");
        hMap2.put("five", "vue.js");

        /* 목차 1. keySet()을 활용한 iterator 활용 */
        Set<String> keys = hMap2.keySet();
        Iterator<String> iter1 = keys.iterator();
        while (iter1.hasNext()){
            String key = iter1.next();
            System.out.println( key + " : " + hMap2.get(key));
        }
        System.out.println("---------------------------");

        /* 목차 2. entrySet()을 활용한 iterator 활용 */
        Set<Map.Entry<String, String>> set = hMap2.entrySet();
        Iterator<Map.Entry<String, String>> iterEntry = set.iterator();
        while (iterEntry.hasNext()){
            Map.Entry<String, String> entry = iterEntry.next();
            System.out.println(entry.getKey() + " : " + entry.getValue() );
        }
    }
}

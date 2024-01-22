package com.ohgiraffers.section06.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Application5 {

    public static void main(String[] args) {

        /* 수업목표. time 패키지의 클래스들에 포매팅을 적용하여 출력할 수 있다. */
        /* 문자열을 time 패키지 자료형으로 파싱할 수 있다. 자동인식 가능한 문자열 패턴 */
        String timeNow = "14:05:10";
        String dateNow = "2022-10-23";

        LocalTime localTime = LocalTime.parse(timeNow);
        LocalDate localDate = LocalDate.parse(dateNow);
        LocalDateTime localDateTime = LocalDateTime.parse(dateNow + "T" + timeNow);

        System.out.println("localTime = " + localTime);
        System.out.println("localDate = " + localDate);
        System.out.println("localDateTime = " + localDateTime);

        /* 설명. 기본 패턴이 아닌 경우 */
        /* 기본 패턴이 아닌 문자열을 time 패키지 자료형에 인식 시키기 */
        String timeNow2 = "14-05-10";
        String dateNow2 = "221005";

        LocalTime localTime2 = LocalTime.parse(timeNow2, DateTimeFormatter.ofPattern("HH-mm-ss"));
        LocalDate localDate2 = LocalDate.parse(dateNow2, DateTimeFormatter.ofPattern("yyMMdd"));

        System.out.println("localTime2 = " + localTime2);
        System.out.println("localDate2 = " + localDate2);

        /* 설명. time 패키지가 인식한 날짜 및 시간을 원하는 문자열로 변환하기 */
        String timeFormat = localTime2.format(DateTimeFormatter.ofPattern("HH mm"));
        String dateFormat = localDate2.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        System.out.println("timeFormat = " + timeFormat);
        System.out.println("dateFormat = " + dateFormat);

    }
}

package com.ohgiraffers.section05.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Application2 {

    public static void main(String[] args) {

        /* 수업목표. java.util.Calender 클래스 사용법을 이해하고 사용할 수 있다. */
        /* 필기.
         *  Date형 대비 개선점
         *  1. timezone과 관련된 기능 추가
         *  2. 윤년 관련 기능이 내부적으로 추가
         *  3. 날짜 및 시간 필드개념을 추가해 불필요한 메소드명 줄임
        * */

        /* 설명. Calendar 자료형은 생성자를 통해 객체를 생성할 수 없다. */
        Calendar cal = Calendar.getInstance();
        System.out.println("cal = " + cal);

        Calendar cal2 = new GregorianCalendar();
        System.out.println("GregorianCalendar = " + cal2);

        int year = 1998;
        int month = 9;    // 입력하고자 하는 월 - 1 -> index 0부터 시작
        int dayOfMonth = 23;
        int hour = 15;
        int minute = 13;
        int second = 14;

        Calendar birthday = new GregorianCalendar(year, month, dayOfMonth, hour, minute, second);
        System.out.println("birthday = " + birthday);

        /* 설명. GregorianCalendar 객체가 가진 값 확인 */
        System.out.println("year : " + birthday.get(1));
        System.out.println("year : " + birthday.get(Calendar.YEAR));
        System.out.println("month : " + (birthday.get(2)+1));     // get() 메소드로 반환받은 값에 +1 해줘야 우리가 생각하는 월의 개념이 된다.
        System.out.println("month : " + (birthday.get(Calendar.MONTH)+1));
        System.out.println("dayOfMonth : " + birthday.get(5));
        System.out.println("dayOfMonth : " + birthday.get(Calendar.DAY_OF_MONTH));
        
        /* 설명. 요일에 대해 알아보기 */
        String day = "";
        switch (birthday.get(Calendar.DAY_OF_WEEK)){
            case Calendar.SUNDAY: day = "일"; break;
            case Calendar.MONDAY: day = "월"; break;
            case Calendar.TUESDAY: day = "화"; break;
            case Calendar.WEDNESDAY: day = "수"; break;
            case Calendar.THURSDAY: day = "목"; break;
            case Calendar.FRIDAY: day = "금"; break;
            case Calendar.SATURDAY: day = "토";
        }
        System.out.println(day + "요일");

        /* 설명. 하나씩 불러와 보자 */
        System.out.println("AM/PM : " + birthday.get(Calendar.AM_PM));             // 0은 오전, 1은 오후
        System.out.println("hourOfDay: " + birthday.get(Calendar.HOUR_OF_DAY));    // 24시간 체계
        System.out.println("hour: " + birthday.get(Calendar.HOUR));                // 12시간 체계
        System.out.println("min: " + birthday.get(Calendar.MINUTE));
        System.out.println("sec: " + birthday.get(Calendar.SECOND));

        /* 설명. SimpleDateFormat 활용하기 (java.util.Date 형으로 변환 후 활용) */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss E요일");
        String birthdayStr = sdf.format(new Date(birthday.getTimeInMillis()));
        System.out.println(birthdayStr);
    }
}

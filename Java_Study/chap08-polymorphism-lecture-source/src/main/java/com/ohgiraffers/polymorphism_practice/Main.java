package com.ohgiraffers.polymorphism_practice;

public class Main {

    public static void main(String[] args) {

//        Cook cook = new Cook("요리1", new String[]{"재료1", "재료2"}, 30);

        Steak steak1 = new Steak("스테이크1", new String[]{"부채살", "소금", "후추", "올리브유"}, 30, 1);
        Cook steak2 = new Steak("Cook() 스테이크2", new String[]{"안심", "소금", "후추", "올리브유"}, 30, 2);

        Pasta pasta1 = new Pasta("알리오올리오", new String[]{"면", "올리브유", "마늘"}, 30);
        Cook pasta2 = new Pasta("Cook() 봉골레", new String[]{"면", "올리브유", "조개", "화이트와인"}, 30);

        System.out.println("===========================");

        System.out.println(steak1);
        System.out.println(steak2);
        System.out.println(pasta1);
        System.out.println(pasta2);

        System.out.println("===========================");
        Cook[] cooks = new Cook[4];
        cooks[0] = steak2;
        cooks[1] = pasta1;
        cooks[2] = steak1;
        cooks[3] = pasta2;

        for(Cook cook : cooks){

            if(cook instanceof Steak)
                ((Steak)cook).prepareMeat();   //steak2.prepareMeat();
            else if (cook instanceof Pasta) {
                ((Pasta)cook).prepareNoodles();
                ((Pasta)cook).choiceSource();
            }
            cook.cooking();
            cook.setDish();
            cook.eat();

            System.out.println("-----------------");
        }

    }
}

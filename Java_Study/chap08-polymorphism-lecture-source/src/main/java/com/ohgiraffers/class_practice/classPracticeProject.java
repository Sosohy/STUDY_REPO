package com.ohgiraffers.class_practice;

import java.util.Random;

public class classPracticeProject {

    public static void main(String[] args) {
        Rectangle r = Rectangle.getInstance();
        r.setTriangle(10, 20);
        System.out.println(r.toString());

        Triangle[] tSet = new Triangle[5];
        Random random = new Random();
        for (int i = 0; i < tSet.length; i++) {
            tSet[i] = new Triangle(random.nextInt(10)+1, random.nextInt(10)+1);
        }
        r.setTriangles(tSet);

        Triangle[] getT = r.getTriangles();
        r.arrayToString();
        System.out.println("-----------------------------");
        for (int i = 0; i < getT.length; i++) {
            System.out.println(getT[i]);
        }
        System.out.println(r.oneToString());

        System.out.println("-----------------------------");
        System.out.println(Rectangle.getWidth(6));
        System.out.println(Rectangle.getWidth(6, 8));


    }
}

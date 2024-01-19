package com.ohgiraffers.class_practice;

import java.util.Arrays;

public class Rectangle {

    private static Rectangle rectangle;
    private Triangle triangle;

    private Triangle[] triangles;
    public Rectangle() {
    }

    public static Rectangle getInstance(){
        if(rectangle == null)
            rectangle = new Rectangle();
        return rectangle;
    }

    public Triangle getTriangle() {
        return triangle;
    }

    public void setTriangle(int w, int h) {
        if(triangle == null){
            triangle = new Triangle(w, h);
            System.out.println("삼각형 할당 완료 : " + w + " " + h);
        }else
            System.out.println("삼각형이 이미 생성되었습니다.");
    }

    public Triangle[] getTriangles() {
        return triangles;
    }

    public void setTriangles(Triangle[] triangles) {
        if(this.triangles == null) {
            this.triangles = triangles;
            System.out.println("배열 할당 완료");
        }else
            System.out.println("삼각형 배열이 이미 생성되었습니다.");
    }

    public String oneToString() {
        System.out.println("oneToString");
        return triangle.toString();
    }

    public void arrayToString(){
        System.out.println("arrayToString");
        for (int i = 0; i < triangles.length; i++) {
            System.out.println(triangles[i]);
        }
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "triangle=" + triangle +
                ", triangles=" + Arrays.toString(triangles) +
                '}';
    }

    public static int getWidth(int w, int h){
        return (w*h)/2;
    }

    public static int getWidth(int n){
        return (n*n)/2;
    }
}

package com.ohgiraffers.section01.method;

public class Calculator {
    public int plusNum(int first, int second){
        return first + second;
    }

    public int subNum(int first, int second){
        return first - second;
    }

    public int multiNum(int first, int second){
        return first * second;
    }

    public double divideNum(int first, int second){
        return first / (double)second;
    }

    public static int maxNum(int first, int second){
        return (first > second) ? first : second;
    }

    private int minNum(int first, int second){
        return (first > second) ? second : first;
    }
}

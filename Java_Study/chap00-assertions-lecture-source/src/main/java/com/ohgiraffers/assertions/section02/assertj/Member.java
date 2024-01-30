package com.ohgiraffers.assertions.section02.assertj;

public class Member {

    private int idx;
    private String id;
    private String name;
    private int age;

    public Member(int idx, String id, String name, int age) {
        this.idx = idx;
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getIdx() {
        return idx;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "idx=" + idx +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

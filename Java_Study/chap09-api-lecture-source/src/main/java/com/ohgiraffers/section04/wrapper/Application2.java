package com.ohgiraffers.section04.wrapper;

public class Application2 {

    public static void main(String[] args) {
        byte b = Byte.parseByte("1");          // Byte.valueOf("1"); : parse자료형 -> valueOf 가능
        short s = Short.parseShort("2");
        int i = Integer.parseInt("4");
        long l = Long.parseLong("8");
        float f = Float.parseFloat("4.0");
        double d = Double.parseDouble("8.0");
        boolean bl = Boolean.parseBoolean("true");
        char c = "abc".charAt(0);
    }
}

package com.ohgiraffers.section02.reflection;

import java.lang.reflect.*;

public class Application {
    public static void main(String[] args) {

        /* 설명 1. Class 타입의 Class 메타정보 추출 */
        System.out.println("------ 클래스 정보 ------");
        Class class1 = Account.class;
        System.out.println("class1 = " + class1);

        Class class2 = new Account().getClass();
        System.out.println("class2 = " + class2);

        try {
            Class class3 = Class.forName("com.ohgiraffers.section02.reflection.Account");
            System.out.println("class3 = " + class3);

            Class class4 = Class.forName("[D");
            Class class5 = double[].class;

            System.out.println("class4 = " + class4);
            System.out.println("class5 = " + class5);

            Class class6 = Class.forName("[Ljava.lang.String;");
            Class class7 = String[].class;

            System.out.println("class6 = " + class6);
            System.out.println("class7 = " + class7);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        /* 설명 2. 필드 정보 추출 */
        System.out.println("------ 필드 정보 ------");
        Field[] fields = Account.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("modifiers : " + Modifier.toString(field.getModifiers())
                             + " | type : " + field.getType()
                             + " | name : " + field.getName());
        }

        /* 설명 3. 생성자 정보 추출 */
        System.out.println("------ 생성자 정보 ------");
        Constructor[] constructors = Account.class.getConstructors();    // 생성자들이 배열로 담김
        for (Constructor constructor : constructors) {
            System.out.println("constructor.getName() = " + constructor.getName());
            
            Class[] params = constructor.getParameterTypes();
            for (Class param : params) {
                System.out.println("param.getTypeName() = " + param.getTypeName());
            }
        }

        try {
            Account acc = (Account) constructors[0].newInstance("20", "110-1234-56778", "1234", 10000);
            System.out.println(acc.getBalance());
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        /* 설명 4. 메소드 정보 추출 */
        System.out.println("------ 메소드 정보 ------");
        Method[] methods = Account.class.getMethods();
        Method getBalanceMethod = null;
        for (Method method : methods) {
            System.out.println(Modifier.toString(method.getModifiers()) + " "
                             + method.getReturnType().getSimpleName() + " "
                             + method.getName());
            if("getBalance".equals(method.getName())){
                getBalanceMethod = method;
            }
        }

        try {
            System.out.println(getBalanceMethod.invoke(((Account)constructors[2].newInstance())));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }

    }
}

package com.ohgiraffers.section03.filterstream;

import com.ohgiraffers.section03.filterstream.dto.MemberDTO;

import java.io.*;

public class Application4 {

    public static void main(String[] args) {

        /* 수업목표. 객체 단위의 입출력 보조 스트림을 이해하고 활용할 수 있다. */
        MemberDTO[] memArr = new MemberDTO[100];
        memArr[0] = new MemberDTO("user01", "pw01", "홍길동", "hong@gmail.com", 20, '남');
        memArr[1] = new MemberDTO("user02", "pw02", "유관순", "yoo@gmail.com", 25, '여');
        memArr[2] = new MemberDTO("user03", "pw03", "강감찬", "gang@gmail.com", 30, '남');

        /* 설명.
         *  1. 기존에 파일이 해당 위치에 없다면, 기존  ObjectOutputStream으로 처음 데이터 넣기
         *  2. 기존에 파일이 해당 위치에 있다면, 우리가 만든 MyOutput으로 데이터 이어서 넣기
        * */

        File file = new File("src/main/java/com/ohgiraffers/section03/filterstream/testObject.txt");
        System.out.println("file.exists() : " + file.exists());

        ObjectOutputStream objOut = null;

        try {
            if(!file.exists()){          // 해당 위치에 파일 존재X
                objOut = new ObjectOutputStream(
                            new BufferedOutputStream(
                                new FileOutputStream("src/main/java/com/ohgiraffers/section03/filterstream/testObject.txt")));

            }else{
                objOut = new MyOutput(   // 해당 위치에 파일 존재
                            new BufferedOutputStream(
                                new FileOutputStream("src/main/java/com/ohgiraffers/section03/filterstream/testObject.txt", true)));

            }

            for (int i = 0; i < memArr.length; i++) {
                if(memArr[i] == null)   // 배열의 크기로 인한 문제 해결용 break문
                    break;
                objOut.writeObject(memArr[i]);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(objOut != null)
                    objOut.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /* 설명. 출력이 된 객체를 입력받아 확인하기 위한 새로운 MemberDTO[] 생성 */
        MemberDTO[] inputMembers = new MemberDTO[memArr.length];

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream("src/main/java/com/ohgiraffers/section03/filterstream/testObject.txt")));

            int i = 0;
           while (true){
               inputMembers[i++] = (MemberDTO)(ois.readObject());
           }
        } catch (EOFException e){
            System.out.println("파일 입력 완료");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(ois != null)
                    ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /* 설명. 입력받아 새로운 MemberDTO에 저장된 회원들 확인 */
        for (MemberDTO m : inputMembers){
            if(m == null)
                break;
            System.out.println(m);
        }

    }
}

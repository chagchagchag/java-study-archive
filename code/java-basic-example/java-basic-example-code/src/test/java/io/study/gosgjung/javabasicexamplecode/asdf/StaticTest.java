package io.study.gosgjung.javabasicexamplecode.asdf;

import org.junit.jupiter.api.Test;

public class StaticTest {

    class Number{
        static int n1 = 0;
        int n2 = 0;
    }

    @Test
    public void STATIC_EX(){
        Number a = new Number();
        Number b = new Number();

        a.n1++; // static 변수 ++
        a.n2++; // 객체 변수 ++

        System.out.println(b.n1);
        System.out.println(b.n2);
    }

}

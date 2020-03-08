package com.example.assembly.configuration;

public class utils {
    public static void main(String[] args) {

        System.out.println(isOdd(9));
        idIncrease();
    }

    public static boolean isOdd(int i) {
        return i % 2 != 0;
    }

    public static void idIncrease(){
        System.out.println("====打印信息=====");
    }
}

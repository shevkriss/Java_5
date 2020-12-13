package com.company;

public class Main {

    public static void main(String[] args) {
        Injector injector = new Injector();
        Tmp tmp = injector.inject(new Tmp());
        tmp.test();
    }
}

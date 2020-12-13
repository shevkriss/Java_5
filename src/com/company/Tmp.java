package com.company;

public class Tmp {
    @AutoInjectable
    Test object;

    @AutoInjectable
    OtherTest object2;

    void test() {
        System.out.println(object.getValue());
        System.out.println(object2.getName());
    }
}

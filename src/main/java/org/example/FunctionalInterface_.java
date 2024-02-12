package org.example;

public class FunctionalInterface_ {
    public static void main(String[] args) {
        // Traditional Java way
        A a1 = new B();
        a1.show();

        // Traditional Java way using anonymous class
        A a2 = new A(){
            @Override
            public void show() {
                System.out.println("Show called by Traditional Java way using anonymous class!");
            }
        };
        a2.show();

        // New way using lambda expression
        A a3 = () -> System.out.println("Show called by New way using lambda expression!");
        a3.show();
    }
}


// Traditional Java way
@FunctionalInterface
interface A {
    void show();
}

class B implements A{

    @Override
    public void show() {
        System.out.println("Show called by Traditional Java way!");
    }
}
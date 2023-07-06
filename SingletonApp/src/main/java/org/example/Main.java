package org.example;

public class Main {

    public static void main(String[] args) {
        /*
        SingletonClass varSingleton = new SingletonClass(); Not possible
        */
        SinglentonClass singlenton1 = SinglentonClass.getInstance();
        SinglentonClass singlenton2 = SinglentonClass.getInstance();

        System.out.println("Singleton1: ");
        singlenton1.testState();
        System.out.println("Singleton2: ");
        singlenton2.testState();

    }
}
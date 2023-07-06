package org.example;

public class SinglentonClass {

    private static SinglentonClass varClass;

    private SinglentonClass() {}

    public static SinglentonClass getInstance(){
        if(varClass == null){
            varClass = new SinglentonClass();
        }
        return varClass;
    }

    public void testState() {
        System.out.println("Singlenton on line");
    }

}

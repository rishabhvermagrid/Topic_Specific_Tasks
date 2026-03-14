package Generics;

public class BoxDemo {
    public static void main(String[] args) {

        Box<Integer> intBox = new Box<>(123);
        Box<Integer> intBox2 = new Box<>(321);

        System.out.println(intBox.getValue() + intBox2.getValue());

        intBox.setValue(222);

        // ❌ compile-time error now
        // intBox.setValue("abc");

        System.out.println(intBox.getValue() + intBox2.getValue());
    }
}

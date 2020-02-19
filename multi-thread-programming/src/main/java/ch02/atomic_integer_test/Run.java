package ch02.atomic_integer_test;

public class Run {

    public static void main(String[] args) {

        AddCountThread addCountThread = new AddCountThread();
        new Thread(addCountThread).start();
        new Thread(addCountThread).start();
        new Thread(addCountThread).start();
        new Thread(addCountThread).start();
        new Thread(addCountThread).start();
    }
}

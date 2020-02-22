package ch03.wait_old;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");
        Add add = new Add(lock);
        Subtract subtract = new Subtract(lock);

        ThreadSubtract threadSubtract = new ThreadSubtract(subtract);
        threadSubtract.setName("subtractThread");
        threadSubtract.start();

        ThreadSubtract threadSubtract2 = new ThreadSubtract(subtract);
        threadSubtract2.setName("subtractThread2");
        threadSubtract2.start();

        Thread.sleep(1000);
        ThreadAdd threadAdd = new ThreadAdd(add);
        threadAdd.setName("addThread");
        threadAdd.start();
    }
}

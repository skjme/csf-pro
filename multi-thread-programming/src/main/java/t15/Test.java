package t15;

public class Test extends Thread {

    private SynchronizedObject object;

    public Test(SynchronizedObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        object.printString("b", "bb");
    }

    public static void main(String[] args) throws InterruptedException {

        SynchronizedObject object = new SynchronizedObject();
        Test t = new Test(object);
        t.start();
        Thread.sleep(500);
        t.stop();
        System.out.println(object.getUsername() + " " + object.getPassword());

    }
}

public class Test1 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() +" " + thread.getId()) ;
    }
}

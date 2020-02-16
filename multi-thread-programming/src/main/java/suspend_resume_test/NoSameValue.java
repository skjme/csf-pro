package suspend_resume_test;

public class NoSameValue {

    public static class MyObject{
        private String username = "1";
        private String pasword = "11";
        public void setValue(String u, String p){
            this.username = u;
            if(Thread.currentThread().getName().equals("a")){
                System.out.println("停止a线程");
                Thread.currentThread().suspend();
            }
            this.pasword = p;
        }

        public void printUsernamePasword(){
            System.out.println(username +" " + pasword);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final MyObject myObject = new MyObject();

        Thread t1 = new Thread(){
            @Override
            public void run() {
                myObject.setValue("A", "AA");
            }
        };
        t1.setName("a");
        t1.start();
        Thread.sleep(500);

        Thread t2 = new Thread(){
            @Override
            public void run() {
                super.run();
                myObject.printUsernamePasword();
            }
        };
        t2.start();
    }

}

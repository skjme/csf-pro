package ch02.t6;

public class Task {

    private String getData1;
    private String getData2;

    public void doLongTimeTask(){
        try{
            System.out.println("begin task");
            Thread.sleep(3000);

            String privateGetData1 = "长时间处理任务后从远程返回的值1 threadName=" + Thread.currentThread().getName();
            String privateGetData2 = "长时间处理任务后从远程返回的值2 threadName=" + Thread.currentThread().getName();

            synchronized (this){
                this.getData1 = privateGetData1;
                this.getData2 = privateGetData2;
            }

            System.out.println(getData1);
            System.out.println(getData2);

            System.out.println("end task");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package cn.chaseshu.bean;

public class MyTestBean {

    private String testStr = "testStr";
    private long time;

    public MyTestBean() {
        this.time = System.nanoTime();
    }

    public String getTestStr() {
        return testStr;
    }

    public void setTestStr(String testStr) {
        this.testStr = testStr;
    }
}

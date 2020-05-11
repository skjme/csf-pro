package cn.chaseshu.rocketmq.transacction;

public interface Snowflake {
    public Integer nextId();

    public String nextIdStr();
}

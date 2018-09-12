package com.example.demo.dp.template;

public abstract class Worker {

    /**
     * 定义算法骨架，具体算法步骤留给子类实现
     *  spring中大量使用 eg jdbcTemplate  redisTemplate kafkaTemplate
     */
    public void workTemplateMethod(){
        beforeWork();
        doingWork();
        afterWork();
    }
    public abstract void beforeWork();

    public abstract void doingWork();

    public abstract void afterWork();
}

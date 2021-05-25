package cn.chaseshu.kill15pid.config;

import org.springframework.beans.factory.annotation.Configurable;

import javax.annotation.PreDestroy;

@Configurable
public class DataBackupConfig {

    @PreDestroy
    public  void backData(){

        System.out.println("正在备份数据。。。。。。。。。。。");
    }
}

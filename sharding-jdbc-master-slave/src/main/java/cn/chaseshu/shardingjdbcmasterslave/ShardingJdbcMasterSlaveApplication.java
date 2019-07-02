package cn.chaseshu.shardingjdbcmasterslave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;


@ServletComponentScan
@SpringBootApplication
public class ShardingJdbcMasterSlaveApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShardingJdbcMasterSlaveApplication.class, args);
	}

}

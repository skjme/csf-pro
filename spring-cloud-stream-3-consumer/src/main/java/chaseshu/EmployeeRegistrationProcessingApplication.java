package chaseshu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  1 解决重复消费的问题?
 *  # 指定分组，同一组存在竞争关系，不会重复消费；不同组存在重复消费问题
 *
 *  2 持久化问题
 *  # 指定分组
 */
@SpringBootApplication
public class EmployeeRegistrationProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRegistrationProcessingApplication.class, args);
	}
}

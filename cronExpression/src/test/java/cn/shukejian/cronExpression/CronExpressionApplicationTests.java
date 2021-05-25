package cn.shukejian.cronExpression;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronExpression;

import java.time.LocalDateTime;

@SpringBootTest
class CronExpressionApplicationTests {

	@Test
	void contextLoads() {

		LocalDateTime now = LocalDateTime.now();
		System.out.println("当前运行时间：" + now);

		// 每小时执行一次
		CronExpression expression1 = CronExpression.parse("0 0 0/1 * * *");
		LocalDateTime nextTime = expression1.next(now);
		System.out.println("每小时执行一次 -> 下次自行时间：" + nextTime);

		// 每小时第十分执行一次
		CronExpression expression2 = CronExpression.parse("0 10 0/1 * * *");
		LocalDateTime nextTime2 = expression2.next(now);
		System.out.println("每小时第十分执行一次 -> 下次自行时间：" + nextTime2);

		hourly();


	}

	@Scheduled(cron = "@hourly")
	public void hourly(){
		LocalDateTime time = LocalDateTime.now();
		System.out.println(true);
	}

}

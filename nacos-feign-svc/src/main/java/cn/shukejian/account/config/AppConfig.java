package cn.shukejian.account.config;

import cn.shukejian.common.config.ShukejianRestConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
@Import(value = {ShukejianRestConfig.class})
@SuppressWarnings(value = "Duplicates")
public class AppConfig {

}
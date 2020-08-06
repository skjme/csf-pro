package cn.shukejian.common.config;

import cn.shukejian.common.error.GlobalExceptionTranslator;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Use this common config for Rest API
 */
@Configuration
@Import(value = {ShukejianConfig.class, SentryClientAspect.class, GlobalExceptionTranslator.class})
public class ShukejianRestConfig {

}

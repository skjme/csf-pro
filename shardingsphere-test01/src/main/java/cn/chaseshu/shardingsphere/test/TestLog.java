package cn.chaseshu.shardingsphere.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLog {

    private static final Logger logger
            = LoggerFactory.getLogger(TestLog.class);

    public static void main(String[] args) {
        logger.info("Example log from {}", TestLog.class.getSimpleName());
    }
}

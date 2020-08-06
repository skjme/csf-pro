package cn.shukejian.account.service;

import cn.shukejian.common.api.BaseResponse;
import cn.shukejian.common.error.ServiceException;
import com.github.structlog4j.ILogger;
import com.github.structlog4j.SLoggerFactory;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    static ILogger logger = SLoggerFactory.getLogger(AccountService.class);

    public BaseResponse hello(String name) {

        logger.debug("name", name);

        if (StringUtils.isBlank(name)) {
            throw new ServiceException("参数 Name Is Empty！");
        }

        return BaseResponse.builder().message("hello, " + name).build();
    }
}

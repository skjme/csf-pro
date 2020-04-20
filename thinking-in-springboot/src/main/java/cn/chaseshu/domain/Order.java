package cn.chaseshu.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Order {

    // 对日期格式要做特殊的处理，全局的格式化方式无法满足我们需求是，
    // 使用该方案是非常好的选择，通过 @JsonFormat 注解我们可以更为精准的为日期字段格式化，
    // 它也是优先级最高的
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime payTime;

    @JsonFormat(pattern="yyyy/MM/dd")
    private LocalDate payDate;

    public LocalDateTime getPayTime() {
        return payTime;
    }

    public void setPayTime(LocalDateTime payTime) {
        this.payTime = payTime;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }
}

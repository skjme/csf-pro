package cn.shukejian.oracle.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author chaseshu
 * @date 2022/4/12 10:38
 * @apiNote
 */
@Data
@EqualsAndHashCode()
@Accessors(chain = true)
@TableName("order_item")
public class Emp {
    
    @TableId(value = "empno", type = IdType.INPUT)
    private String empno;
    
    @TableField("ENAME")
    private String ename;
    
    @TableField("JOB")
    private String job;
    
    
}

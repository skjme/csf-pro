package cn.shukejian.oracle.dao;

import cn.shukejian.oracle.model.Emp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author chaseshu
 * @date 2022/4/12 11:10
 * @apiNote
 */
public interface EmpMapper extends BaseMapper<Emp> {
    public Emp findByEmpno(String empno);
}

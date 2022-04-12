package cn.shukejian.oracle.service;

import cn.shukejian.oracle.dao.EmpMapper;
import cn.shukejian.oracle.model.Emp;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author chaseshu
 * @date 2022/4/12 10:44
 * @apiNote
 */
@Service
public class EmpService extends ServiceImpl<EmpMapper, Emp> {
    
    public Emp findByEmpno(String empno){
        return this.baseMapper.findByEmpno(empno);
    }

}

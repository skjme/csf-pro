package cn.shukejian.oracle.controller;

import cn.shukejian.oracle.model.Emp;
import cn.shukejian.oracle.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping()
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@RequestMapping({"/getEmpno", "/"})
	public Emp getUserVO(String empno){
		Emp vo = empService.findByEmpno(empno);
		return vo;
	}
}
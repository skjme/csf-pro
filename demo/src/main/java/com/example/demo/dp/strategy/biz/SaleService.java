package com.example.demo.dp.strategy.biz;

import com.example.demo.dp.strategy.DabaojianSale;
//import com.example.demo.dp.strategy.VipStrategy;
//import com.example.demo.dp.strategy.VisitorStrategy;
//import com.example.demo.dp.template.DabaojianWorker;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 收银台服务
 */
@Service
public class SaleService {

// 1   改建前
//    @Autowired
//    private VipStrategy vipStrategy;
//
//    @Autowired
//    private VisitorStrategy visitorStrategy;
//
//    public void sale(String type, String name){
//        if("vip".equals(type)){
//            vipStrategy.sale(name);
//        } else if("visitor".equals(type)){
//            visitorStrategy.sale(name);
//        }
//    }

// 2   改建前 遵循关闭原则
    // 类型 -》 计算策略对象
    HashMap<String, DabaojianSale> saleMap = new HashMap<String, DabaojianSale>();

    // spring 构造函数直接注入一个接口的所有实现
    public SaleService(List<DabaojianSale> dabaojianSaleList){
        for (DabaojianSale s : dabaojianSaleList) {
            saleMap.put(s.type(), s);
        }
    }

    public void sale(String type, String name){
        saleMap.get(type).sale(name);
    }
}

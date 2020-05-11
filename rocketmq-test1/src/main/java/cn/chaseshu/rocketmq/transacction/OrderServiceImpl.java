package cn.chaseshu.rocketmq.transacction;

import org.apache.rocketmq.client.exception.MQClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 在订单业务服务类中，我们有两个方法。一个用于向RocketMQ发送事务消息，一个用于真正的业务数据落库。
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    TransactionLogMapper transactionLogMapper;

    @Autowired
    TransactionProducer producer;

    Snowflake snowflake ;//= new Snowflake(1,1);
    Logger logger = LoggerFactory.getLogger(this.getClass());

    //执行本地事务时调用，将订单数据和事务日志写入本地数据库
   // @Transactional
    @Override
    public void createOrder(OrderDTO orderDTO, String transactionId){

        //1.创建订单
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO,order);
        orderMapper.createOrder(order);

        //2.写入事务日志
        TransactionLog log = new TransactionLog();
        log.setId(transactionId);
        log.setBusiness("order");
        log.setForeignKey(String.valueOf(order.getId()));
        transactionLogMapper.insert(log);

        logger.info("订单创建完成。{}",orderDTO);
    }

    //前端调用，只用于向RocketMQ发送事务消息
    @Override
    public void createOrder(OrderDTO order) {
        order.setId(snowflake.nextId());
        order.setOrderNo(snowflake.nextIdStr());
       // producer.send(JSON.toJSONString(order),"order");
    }
}

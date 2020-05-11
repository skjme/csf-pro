package cn.chaseshu.rocketmq.transacction;

public interface OrderService {

    public void createOrder(OrderDTO orderDTO,String transactionId);

    public void createOrder(OrderDTO order);
}

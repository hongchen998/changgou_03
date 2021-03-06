package com.changgou.order.service;

import com.changgou.order.pojo.Order;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:传智播客
 * @Description:Order业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface OrderService {
    /**
     * @author hongchen
     * @Description 通过用户名查找订单列表
     * @Date 12:09 2020/4/29
     * @param username
     * @return java.util.List<com.changgou.order.pojo.Order>
     **/
    List<Order> findByUsername(String username);
    /**
     * @param orderId
     * @return void
     * @author hongchen
     * @Description 支付失败，删除订单（更新订单）
     * @Date 23:19 2020/4/19
     **/
    void deleteOrder(String orderId);

    /**
     * @param orderId       订单id
     * @param transactionId 第三方生成的交易流水号
     * @return void
     * @author hongchen
     * @Description 支付成功，更新订单状态
     * @Date 23:09 2020/4/19
     **/
    void updateStatus(String orderId, String transactionId);

    /***
     * Order多条件分页查询
     * @param order
     * @param page
     * @param size
     * @return
     */
    PageInfo<Order> findPage(Order order, int page, int size);

    /***
     * Order分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Order> findPage(int page, int size);

    /***
     * Order多条件搜索方法
     * @param order
     * @return
     */
    List<Order> findList(Order order);

    /***
     * 删除Order
     * @param id
     */
    void delete(String id);

    /***
     * 修改Order数据
     * @param order
     */
    void update(Order order);

    /***
     * 新增Order
     * @param order
     */
    void add(Order order);

    /**
     * 根据ID查询Order
     *
     * @param id
     * @return
     */
    Order findById(String id);

    /***
     * 查询所有Order
     * @return
     */
    List<Order> findAll();
}

package com.changgou.order.controller;

import com.changgou.order.pojo.Order;
import com.changgou.order.service.OrderService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;

import entity.TokenDecode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:传智播客
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private TokenDecode tokenDecode;

    /**
     * @author hongchen
     * @Description 通过用户名查找订单列表
     * @Date 12:09 2020/4/29
     * @param username
     * @return java.util.List<com.changgou.order.pojo.Order>
     **/
    @GetMapping("/findByUsername/{username}")
    public Result<List<Order>> findByUsername(@PathVariable(value = "username") String username) {
        List<Order> list = orderService.findByUsername(username);
        return new Result(true, StatusCode.OK, "查询用户订单列表成功", list);
    }

    /***
     * Order分页条件搜索实现
     * @param order
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo> findPage(@RequestBody(required = false) Order order, @PathVariable int page, @PathVariable int size) {
        //调用OrderService实现分页条件查询Order
        PageInfo<Order> pageInfo = orderService.findPage(order, page, size);
        return new Result(true, StatusCode.OK, "查询成功", pageInfo);
    }

    /***
     * Order分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size) {
        //调用OrderService实现分页查询Order
        PageInfo<Order> pageInfo = orderService.findPage(page, size);
        return new Result<PageInfo>(true, StatusCode.OK, "查询成功", pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param order
     * @return
     */
    @PostMapping(value = "/search")
    public Result<List<Order>> findList(@RequestBody(required = false) Order order) {
        //调用OrderService实现条件查询Order
        List<Order> list = orderService.findList(order);
        return new Result<List<Order>>(true, StatusCode.OK, "查询成功", list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable String id) {
        //调用OrderService实现根据主键删除
        orderService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /***
     * 修改Order数据
     * @param order
     * @param id
     * @return
     */
    @PutMapping(value = "/{id}")
    public Result update(@RequestBody Order order, @PathVariable String id) {
        //设置主键值
        order.setId(id);
        //调用OrderService实现修改Order
        orderService.update(order);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /***
     * 新增Order数据
     * @param order
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Order order) {
        // 获取当前登录的用户信息
        String username = tokenDecode.getUserInfo().get("username");
        order.setUsername(username);

        //调用OrderService实现添加Order
        orderService.add(order);
        return new Result(true, StatusCode.OK, "提交订单成功", order);
    }

    /***
     * 根据ID查询Order数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<Order> findById(@PathVariable String id) {
        //调用OrderService实现根据主键查询Order
        Order order = orderService.findById(id);
        return new Result<Order>(true, StatusCode.OK, "查询成功", order);
    }

    /***
     * 查询Order全部数据
     * @return
     */
    @GetMapping
    public Result<List<Order>> findAll() {
        //调用OrderService实现查询所有Order
        List<Order> list = orderService.findAll();
        return new Result<List<Order>>(true, StatusCode.OK, "查询成功", list);
    }
}

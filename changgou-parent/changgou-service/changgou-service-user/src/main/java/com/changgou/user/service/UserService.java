package com.changgou.user.service;

import com.changgou.user.pojo.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:传智播客
 * @Description:User业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface UserService {
/**
 * @author hongchen
 * @Description 添加用户积分
 * @Date 1:10 2020/4/19
 * @param username
 * @param points
 * @return void
 **/
    void incrUserPoints(String username, Integer points);

    /***
     * User多条件分页查询
     * @param user
     * @param page
     * @param size
     * @return
     */
    PageInfo<User> findPage(User user, int page, int size);

    /***
     * User分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<User> findPage(int page, int size);

    /***
     * User多条件搜索方法
     * @param user
     * @return
     */
    List<User> findList(User user);

    /***
     * 删除User
     * @param id
     */
    void delete(String id);

    /***
     * 修改User数据
     * @param user
     */
    void update(User user);

    /***
     * 新增User
     * @param user
     */
    void add(User user);

    /**
     * 根据ID查询User
     *
     * @param id
     * @return
     */
    User findById(String id);

    /***
     * 查询所有User
     * @return
     */
    List<User> findAll();
}

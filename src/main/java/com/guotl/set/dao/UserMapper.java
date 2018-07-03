package com.guotl.set.dao;

import com.guotl.set.entity.sys.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 用户中心
 * @author GuoTL
 * @date 17:42 2018/5/25
 **/
@Repository
public interface UserMapper {
    //登录验证
  User loginvalidate(Map<String, Object> map);

    /***
     * 注册账号
     * @param u
     */
    int init(User u);

    /**
     * 查询用户
     */
//    List<User> getUserAll();


}
package com.guotl.set.service.sys;

import com.guotl.set.entity.sys.User;

import java.util.List;

/**
 * 用户Service接口
 * @author GuoTL
 * @date 17:38 2018/5/25
 **/
public interface UserService {

    User loginvalidate(String username, String pwd);

    /**
     * 注册账号
     * @param
     */
    int init(String data);

    /**
     * 验证账号
     * @param username
     * @return
     */
    User findByName(String username,String pwd);

    /**
     *菜单树
     * @param id
     */
    String getztree(int id);

    /**
     * 用户查询
     * @return
     */
//    List<User> getUserAll();

}
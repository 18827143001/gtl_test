package com.guotl.set.service.sys.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.guotl.set.dao.PermissionMapper;
import com.guotl.set.dao.RoleMapper;
import com.guotl.set.dao.UserMapper;
import com.guotl.set.entity.base.MenuZtree;
import com.guotl.set.entity.sys.User;
import com.guotl.set.entity.sys.permission;
import com.guotl.set.service.sys.UserService;
import com.guotl.set.util.AppMD5Util;
import com.guotl.set.util.UserUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 用户Service实现
 * @author GuoTL
 * @date 17:39 2018/5/25
 **/
@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;


    /**
     * 注册账号
     * @param
     * @return
     */
    @Override
    public int init(String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        User u=new User();
        Map<String,Object> m=new HashMap<String,Object>();
        for(Map.Entry<String,Object> entry: jsonObject.entrySet()){
            if (entry.getKey().equals("nickname")) {
                u.setUsername((String) entry.getValue());
            } else if (entry.getKey().equals("password")) {
                String pwd=AppMD5Util.getMD5((String) entry.getValue());
                u.setPassword(pwd);
            }else if (entry.getKey().equals("cellphone")) {
                u.setAccount((String) entry.getValue());
                m.put("account",(String) entry.getValue());
            }
        }
         try {
                userMapper.init(u);
                return 1;
            }catch (Exception e){
                return 99;
            }
    }

    /**
     * 登录的方法
     * @param username
     * @param pwd
     * @return
     */
    @Override
    public User findByName(String username,String pwd) {
        try{
            UsernamePasswordToken token = new UsernamePasswordToken(username, pwd);
            SecurityUtils.getSubject().login(token);
        }catch (Exception e){
            e.printStackTrace();
        }
        User u=UserUtil.getUserFromSession();
        return u;
    }

    /**
     * 根据用户id查询相对应的权限菜单
     * @param id    用户ID
     * @return
     */
    @Override
    public String getztree(int id) {
        List<permission> list=permissionMapper.getperid(id);
        List<MenuZtree> menu=new ArrayList<>();
        for (permission p:list) {
            if (p.getPid()==0){
            MenuZtree m1 = new MenuZtree();
            m1.setId(String.valueOf(p.getId()));
            m1.setP_id(String.valueOf(p.getPid()));
            m1.setTitle(p.getName());
            m1.setSpread(false);
            m1.setIcon(p.getIcon());
            m1.setUrl(p.getUrl());
            menu.add(m1);
            }
        }
        // 为一级菜单设置子菜单，getChild是递归调用的
        for (MenuZtree m : menu) {
            m.setChildren(childnode(String.valueOf(m.getId()), list));
        }
        System.out.println(JSON.toJSONString(menu));
        return JSON.toJSONString(menu);
    }

    /**
     * 用户查询
     * @return
     */
 /*   public List<User> getUserAll() {
        List<User>  list=userMapper.getUserAll();


        return null;
    }*/

    /**
     * 递归查询子菜单
     * @param id    父节点id
     * @param permissions    所有的数据
     * @return
     */
    public List<MenuZtree> childnode(String id,List<permission> permissions){
        List<MenuZtree> m=new ArrayList<>();
        for (permission p: permissions) {
            //便利所有的数据然后在于传过来的父节点id进行比较
            //这里是个主键所以可以去掉这一层判断
            if(StringUtils.isNoneBlank(String.valueOf(p.getId()))){
                if(id.equals(String.valueOf(p.getPid()))){
                    MenuZtree m1 = new MenuZtree();
                    m1.setId(String.valueOf(p.getId()));
                    m1.setP_id(String.valueOf(p.getPid()));
                    m1.setTitle(p.getName());
                    m1.setSpread(false);
                    m1.setIcon(p.getIcon());
                    m1.setUrl(p.getUrl());
                    m.add(m1);
                }
            }
        }
        // 递归退出条件
        if (m.size() == 0) {
            return null;
        }
        return m;
    }

    /**
     * 验证账号密码
     * @param username
     * @param pwd
     * @return
     */
    @Override
    public User loginvalidate(String username, String pwd) {
        String ps = AppMD5Util.getMD5(pwd);
        Map<String,Object> m=new HashMap<String,Object>();
        m.put("username",username);
        m.put("pwd",ps);
        User u=userMapper.loginvalidate(m);
        return u;
    }
}
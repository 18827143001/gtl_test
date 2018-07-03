package com.guotl.set.service.sys.impl;

import com.guotl.set.dao.RoleMapper;
import com.guotl.set.entity.sys.Role;
import com.guotl.set.service.sys.User_RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GuoTL
 * @date 20:19 2018/5/28
 **/
@Service
public class User_RoleServiceimpl implements User_RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findRoleByUid(int id) {
        Map<String,Object> m=new HashMap<>();
        m.put("key","id");
        m.put("value",id);
        return roleMapper.finbyone(m);
    }

}
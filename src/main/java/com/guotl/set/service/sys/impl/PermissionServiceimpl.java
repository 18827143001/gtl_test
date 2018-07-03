package com.guotl.set.service.sys.impl;

import com.guotl.set.dao.PermissionMapper;
import com.guotl.set.entity.sys.permission;
import com.guotl.set.service.sys.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author GuoTL
 * @date 9:33 2018/5/29
 **/
@Service
public class PermissionServiceimpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;
    /**
     * 获取用户的权限
     * @param id
     * @return
     */
    @Override
    public List<permission> findPermissionByUid(int id) {
        Map<String,Object> m=new HashMap<>();
        m.put("key","id");
        m.put("value",id);
        return permissionMapper.finbyone(m);
    }
}
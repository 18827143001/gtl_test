package com.guotl.set.service.sys;

import com.guotl.set.entity.sys.Role;
import com.guotl.set.entity.sys.User;

import java.util.List;

/**
 * 用户角色关系
 * @author GuoTL
 * @date 20:18 2018/5/28
 **/
public interface User_RoleService {
    /**
     * 根据用户获取角色
     * @param id
     * @return
     */
    List<Role> findRoleByUid(int id);

}

package com.guotl.set.service.sys;

import com.guotl.set.entity.sys.permission;

import java.util.List;

/**
 * 权限
 * @author GuoTL
 * @date 9:33 2018/5/29
 **/
public interface PermissionService {
    /**
     * 获取用户的权限
     * @param id
     * @return
     */
    List<permission> findPermissionByUid(int id);
}

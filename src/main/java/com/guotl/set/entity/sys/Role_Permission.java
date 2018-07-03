package com.guotl.set.entity.sys;

/**
 * 权限角色关系表
 * @author GuoTL
 * @date 20:54 2018/5/28
 **/
public class Role_Permission {
    private int role_id;
    private int permission_id;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(int permission_id) {
        this.permission_id = permission_id;
    }
}
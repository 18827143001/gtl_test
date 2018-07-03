package com.guotl.set.entity.sys;

/**
 * 角色表
 * @author GuoTL
 * @date 20:47 2018/5/28
 **/
public class Role {
    private int id;
    //角色标识
    private String role;
    //角色名字
    private String description;
    //备注
    private String remarks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
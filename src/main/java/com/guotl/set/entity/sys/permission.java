package com.guotl.set.entity.sys;

/**
 * 权限表
 * @author GuoTL
 * @date 20:52 2018/5/28
 **/
public class permission {
    private int id;
    //名字
    private String name;
    //类型菜单还是按钮，0属于菜单，1属于按钮
    private String resourceType;
    //访问地址
    private String url;
    //权限标识
    private String permission;
    //上级编号
    private int  pid;
    //图标
    private String  icon;
    //状态 0是关闭1是开启
    private String  state;
    //0true,1false是否是一级菜单
    private int  belong;
    //备注
    private String  remarks;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getBelong() {
        return belong;
    }

    public void setBelong(int belong) {
        this.belong = belong;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
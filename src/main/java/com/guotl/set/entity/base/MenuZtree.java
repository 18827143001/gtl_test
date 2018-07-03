package com.guotl.set.entity.base;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuoTL
 * @date 9:40 2018/6/7
 **/
@SuppressWarnings("serial")
public class MenuZtree implements Serializable {
    private String id;
    private String title;
    private String icon;
    private String p_id;
    private boolean spread = false;
    private String url;
    private List<MenuZtree> Children;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<MenuZtree> getChildren() {
        return Children;
    }

    public void setChildren(List<MenuZtree> children) {
        Children = children;
    }
}
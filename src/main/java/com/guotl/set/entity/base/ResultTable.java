package com.guotl.set.entity.base;

import java.util.List;

/**
 * 用户json类
 */
public class ResultTable<T> {
    private Integer code = 0;// 状态码，0代表成功，其它失败
    private String msg = "";// 状态信息，一般可为空
    private Integer count;// 数据总量
    private List<T> data;// 数据，字段是任意的

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}

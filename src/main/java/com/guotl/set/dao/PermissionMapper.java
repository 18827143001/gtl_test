package com.guotl.set.dao;

import com.guotl.set.entity.sys.permission;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author GuoTL
 * @date 10:37 2018/5/29
 **/
@Repository
public interface PermissionMapper {
    /**
     * 单个条件查询，任何字段均可
     * @param m
     * @return
     */
    List<permission> finbyone(Map<String, Object> m);

    List<permission> getperid(int id);
}

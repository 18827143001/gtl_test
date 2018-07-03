package com.guotl.set.dao;

import com.guotl.set.entity.sys.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author GuoTL
 * @date 9:47 2018/5/29
 **/
@Repository
public interface RoleMapper {

    //单条验证（单条条件调用）
    List<Role> finbyone(Map<String, Object> map);

}

package com.guotl.set.controller.sys;

import com.guotl.set.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户管理类
 * @author GuoTL
 * @date 15:19 2018/7/2
 **/
@Controller
@RequestMapping("/menu")
public class SysController {

    @Autowired
    private UserService userservice;

    //查询用户
 /*   @RequestMapping(value = "index")
    public String homepage(){
        return "sys/permission/index";

    }*/

}

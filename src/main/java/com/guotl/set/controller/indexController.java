package com.guotl.set.controller;

import com.guotl.set.entity.sys.User;
import com.guotl.set.util.UserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author GuoTL
 * @date 16:32 2018/5/24
 **/
@Controller
public class indexController {

    /**
     * 进入初始界面
     * @return
     */
    @RequestMapping("/*")
    public String index(){
      return "login";
     }



}
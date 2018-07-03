package com.guotl.set.controller.sys;

import com.guotl.set.entity.sys.User;
import com.guotl.set.service.sys.UserService;
import com.guotl.set.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * @author GuoTL
 * @date 17:57 2018/5/25
 **/
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userservice;

    /**
     * 登录方法验证
     */
    @RequestMapping(value = "/log")
    @ResponseBody
    public int login(Map<String,Object> map, HttpServletRequest request, HttpSession session){
        String username = request.getParameter("username");
        String userpass = request.getParameter("pwd");
       User u= userservice.findByName(username,userpass);
       if(u!=null){
           session.setAttribute("username",u.getUsername());
           session.setAttribute("userids",u.getId());
           return 1;
       }else{
           return 0;
       }

    }

    /**
     * 进入注册界面
     * @return
     */
    @RequestMapping(value = "/showreg")
    public String ok(){
        return "register";
    }

    /**
     * 主页
     * @param
     * @return
     */
    @RequestMapping("/index")
    public String index(Map<String,Object> map){
        //要在界面上获取到用户信息所以这里给他传过去
        User u=UserUtil.getUserFromSession();
        map.put("user",u);
        return "index";
    }


    /**
     * 注册账号
     * @param data 账号信息
     * @return
     */
    @RequestMapping(value = "/regoster")
    @ResponseBody
    public int regoster(String data){
         int r=userservice.init(data);
             return r;
    }

    /**
     * 初始化内容
     * @return
     */
    @RequestMapping(value = "/main")
    public String main(){
        return "main";
    }

    /**
     * 菜单初始化
     * @param request 前台向后台传参的对象
     * @param response  后台像前台传参的对象
     */
    @RequestMapping(value = "/ztree")
    public void ztree(HttpServletRequest request,HttpServletResponse response){
        User u=UserUtil.getUserFromSession();
        String s=userservice.getztree(u.getId());
        response.setContentType("text/html; charset=utf-8");
        try {
            response.getWriter().print(s);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
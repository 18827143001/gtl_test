package com.guotl.set.controller.sys;

import com.guotl.set.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 菜单控制器
 * @author GuoTL
 * @date 15:19 2018/6/7
 **/
@Controller
@RequestMapping("/menu")
public class ResourceController extends BaseController {
    /**
     * 初始化内容：如果是在login界面进来的话需要重新返回主界面，需要在数据库中的路径中修改
     * 如：之前menu/index我数据库路径是这样写的，因为从login进来的所有他跳转的时候前面会自动带上login的路径，会导致找不到报错：报错路径为http://localhost:8881/login/menu/index。
     * 修改数据库路径之后为../menu/index返回跟目录，也就是说我从根目录开始找我跳转的方法，正确路径为：http://localhost:8881/menu/index
     * @return
     */
    @RequestMapping(value = "index")
    public String homepage(){
        return "sys/permission/index";
    }




}
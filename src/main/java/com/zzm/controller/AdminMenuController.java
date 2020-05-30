package com.zzm.controller;

import com.zzm.domain.AdminMenu;
import com.zzm.util.MenuUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class AdminMenuController {

    @ResponseBody
    @GetMapping("/adminMenu")
    public Map getMenuInfo(HttpServletRequest request){
        List<AdminMenu> userMenus = (List<AdminMenu>)request.getSession().getAttribute("userMenus");
        Map menuList = new HashMap();
        menuList.put("admin",request.getSession().getAttribute("admin"));
        menuList.put("role",request.getSession().getAttribute("role"));
        menuList.put("topMenuList", MenuUtil.getAllTopMenu(userMenus));
        menuList.put("secondMenuList", MenuUtil.getAllSecondMenu(userMenus));
        return menuList;
    }
}

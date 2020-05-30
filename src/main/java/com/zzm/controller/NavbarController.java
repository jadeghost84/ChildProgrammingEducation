package com.zzm.controller;

import com.zzm.domain.User;
import com.zzm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class NavbarController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/navbar")
    public Map getNavbarInfo(HttpServletRequest request){
        Map result = new HashMap();
        if("yes".equals(request.getSession().getAttribute("isLogin"))){
            Integer u_id = (Integer) request.getSession().getAttribute("u_id");
            result.put("flag",1);
            User user = userService.findUserById(u_id);
            result.put("u_name", user.getU_name());
            result.put("headImgName",user.getHeadImgName());
            return result;
        }
//        Integer u_id = userService.isLogin(request.getSession().getId());
        result.put("flag",0);
        return result;
    }
}

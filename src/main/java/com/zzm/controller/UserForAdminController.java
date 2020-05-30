package com.zzm.controller;

import com.zzm.domain.User;
import com.zzm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserForAdminController {
    @Autowired
    private UserService userService;

    @GetMapping("/usersForAdmin")
    @ResponseBody
    public Map getAllUser(){
        Map result = new HashMap();
        List<User> users = userService.findAll();

        result.put("code",0);
        result.put("msg","查找成功");
        result.put("count",users.size());
        result.put("data",users);
        return result;
    }
}

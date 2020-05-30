package com.zzm.controller;

import com.zzm.util.QiNiuYunUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommonController {
    @ResponseBody
    @GetMapping("/getToken")
    public String getToken(){
        return QiNiuYunUtil.getToken();
    }
}

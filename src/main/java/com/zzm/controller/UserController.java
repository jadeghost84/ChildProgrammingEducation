package com.zzm.controller;


import com.zzm.domain.Course;
import com.zzm.domain.User;
import com.zzm.service.CourseService;
import com.zzm.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller()
public class UserController {

    @Autowired
    public UserService userService;
    @Autowired
    public CourseService courseService;

    //验证码发送处理
    @GetMapping("/users/{phone}")
    public void getCheckCode(@PathVariable String phone){
//        System.out.println(phone);
        userService.getCheckCode(phone);
    }
    //用户注册
    @PostMapping("/users")
    @ResponseBody
    public Map register(@RequestBody User user,
                        @RequestParam("checkCode") String checkCode){
        Integer flag = userService.saveUser(user,checkCode);
        String message;
        if(flag == 1){
            message = "注册成功";
        }else if(flag == 0){
            message = "验证码错误";
        }else {
            message = "创建用户失败，请重试";
        }
        Map result = new HashMap();
        result.put("flag",flag);
        result.put("message",message);
        return result;
    }

    //用户登录
    @PostMapping("/users/{phone}")
    @ResponseBody
    public Map login(@RequestBody User _user, HttpServletRequest request){

        User user = userService.login(_user.getPhone(), _user.getU_password(),request.getSession().getId());
        Map result = new HashMap();
        if(user==null){
            result.put("flag", 0);
            result.put("message","手机或密码错误");
        }else {
            result.put("flag",1);
            result.put("message", "登录成功");
            result.put("u_id",user.getU_id());
            request.getSession().setAttribute("isLogin","yes");
            request.getSession().setAttribute("u_id",user.getU_id());
        }
        return result;
    }
    //请求用户信息
    @ResponseBody
    @GetMapping("/users")
    public User getUserInfo(HttpServletRequest request){
        if(request.isRequestedSessionIdValid()){
            if("yes".equals(request.getSession().getAttribute("isLogin"))){
                return userService.getUserInfo((Integer)request.getSession().getAttribute("u_id"));
            }
        }
        return new User();
    }
    //退出登录
    @DeleteMapping("/users")
    @ResponseBody
    public void exitLogin(HttpServletRequest request){
        if(request.isRequestedSessionIdValid()){
            String isLogin = (String)request.getSession().getAttribute("isLogin");
            if(isLogin!=null&&isLogin.equals("yes")){
                request.getSession().removeAttribute("isLogin");
            }
        }
    }
    @GetMapping("/users/space")
    @ResponseBody
    public Map getUserIndexInfo(HttpServletRequest request){
        Integer u_id = (Integer) request.getSession().getAttribute("u_id");
        Map result = new HashMap();
        //获得加入学习空间的课程
        List<Course> courses = courseService.getCourseByUId(u_id);


        result.put("courses",courses);
        System.out.println(request);
        return result;
    }
}

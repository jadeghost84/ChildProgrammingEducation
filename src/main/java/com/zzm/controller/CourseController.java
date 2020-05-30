package com.zzm.controller;

import com.zzm.domain.Course;
import com.zzm.domain.CourseSection;
import com.zzm.domain.CourseType;
import com.zzm.service.CourseService;
import com.zzm.service.UserService;
import com.zzm.util.QiNiuYunUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CourseController {

    @Autowired
    CourseService courseService;
    @Autowired
    UserService userService;


    @GetMapping("/course/{c_id}")
    @ResponseBody
    public Course getCourse(@PathVariable String c_id){
        Course course = courseService.findCourseAllInfoById(c_id);
        return course;
    }
    //上传课程前先在数据库创建课程，返回课程id，解决七牛云key唯一性问题
    @PostMapping("/courses")
    @ResponseBody
    public Integer createCourse(@RequestBody Course course, HttpServletRequest request){
        //判断是否已登陆，登录返回u_id
        if("yes".equals(request.getSession().getAttribute("isLogin"))){
            Integer u_id = (Integer) request.getSession().getAttribute("u_id");
            course.setUpid(u_id);
            Integer c_id = courseService.saveCourse(course);
            return c_id;
        }
        return 0;
    }
    //上传课程的章节
    @ResponseBody
    @PostMapping("/course/{c_id}")
    public void addCourseSection(@RequestBody CourseSection courseSection,@PathVariable String c_id){
        courseSection.setC_id(Integer.parseInt(c_id));
        //给url添加域名
        courseSection.setUrl(QiNiuYunUtil.getAreaName()+courseSection.getUrl());
        courseService.saveCourseSection(courseSection);
    }
    //
}

package com.zzm.controller;

import com.zzm.domain.Course;
import com.zzm.domain.User;
import com.zzm.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CourseForAdminController {
    @Autowired
    private CourseService courseService;

    @GetMapping("courseForAdmin")
    @ResponseBody
    public Map getAllCourse(){

        Map result = new HashMap();
        List<Course> courses = courseService.findAll();

        result.put("code",0);
        result.put("msg","查找成功");
        result.put("count",courses.size());
        result.put("data",courses);
        return result;
    }
}

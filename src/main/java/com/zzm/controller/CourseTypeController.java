package com.zzm.controller;

import com.zzm.domain.Course;
import com.zzm.domain.CourseType;
import com.zzm.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CourseTypeController {
    @Autowired
    CourseService courseService;

    @GetMapping("/courseTypes")
    @ResponseBody
    public List<CourseType> getCourseType(){
        List<CourseType> type = courseService.findAllType();
        return type;
    }
    @GetMapping("/courseTypes/{c_t_id}")
    @ResponseBody
    public List<Course> getCourseByType(@PathVariable String c_t_id){
        List<Course> courses = courseService.findTopCourseByTypeId(c_t_id);
        return courses;
    }
}

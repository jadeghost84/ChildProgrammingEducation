package com.zzm.service;

import com.zzm.domain.Course;
import com.zzm.domain.CourseSection;
import com.zzm.domain.CourseType;

import java.util.List;
import java.util.Map;

public interface CourseService {


    public List<CourseType> findAllType();
    public List<Course> findTopCourseByTypeId(String c_t_id);
    public Course findCourseAllInfoById(String c_id);
    public Integer saveCourse(Course course);
    public void saveCourseSection(CourseSection courseSection);
    public List<Course> getCourseByUId(Integer u_id);
    public List<Course> findAll();
}

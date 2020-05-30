package com.zzm.dao;

import com.zzm.domain.Course;
import com.zzm.domain.CourseSection;
import com.zzm.domain.CourseType;
import com.zzm.domain.User;

import java.util.List;

public interface CourseDao {
    public List<CourseType> findAllType();
    public List<Course> findTopCourseByTypeId(Integer c_t_id);
    public Course findCourseById(Integer c_id);
    public List<Course> findAll();
    public void saveCourse(Course course);
    public void saveCourseSection(CourseSection courseSection);
    //通过用户u_id找到所有加入学习的课程
    public List<Course> getCourseByUId(Integer u_id);
}

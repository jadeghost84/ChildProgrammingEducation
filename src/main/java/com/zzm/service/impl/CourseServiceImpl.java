package com.zzm.service.impl;

import com.zzm.dao.CourseDao;
import com.zzm.domain.Course;
import com.zzm.domain.CourseSection;
import com.zzm.domain.CourseType;
import com.zzm.service.CourseService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<CourseType> findAllType() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
        return courseDao.findAllType();
    }

    @Override
    public List<Course> findTopCourseByTypeId(String c_t_id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
        return courseDao.findTopCourseByTypeId(Integer.parseInt(c_t_id));
    }

    @Override
    public Course findCourseAllInfoById(String c_id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
        Course course = courseDao.findCourseById(Integer.parseInt(c_id));
        return course;
    }

    @Override
    public Integer saveCourse(Course course) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
        //mybatis写回last_insert_id
        courseDao.saveCourse(course);
        return course.getC_id();
    }

    @Override
    public void saveCourseSection(CourseSection courseSection) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
        courseDao.saveCourseSection(courseSection);
    }

    @Override
    public List<Course> getCourseByUId(Integer u_id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
        return courseDao.getCourseByUId(u_id);
    }

    @Override
    public List<Course> findAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
        return courseDao.findAll();
    }
}

package com.zzm.programmingedu;

import com.zzm.dao.UserDao;
import com.zzm.domain.Article;
import com.zzm.domain.Course;
import com.zzm.domain.User;
import com.zzm.service.ArticleService;
import com.zzm.service.CourseService;
import com.zzm.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import javax.sql.DataSource;
import java.io.InputStream;
import java.util.List;


@SpringBootTest
class ProgrammingeduApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private ArticleService articleService;

    @Test
    void findAllTest() throws Exception{

        List<User> users = userService.findAll();
        for( User user:users) {
            System.out.println(user);
        }

    }
    @Test
    void findUserByPhoneAndPasswordTest(){
        User user = userService.login("17744829952", "123","1221");
        System.out.println(user);

    }
    @Test
    void findCourseByIdTest(){
        Course course = courseService.findCourseAllInfoById("10");
        System.out.println(course);
    }


    @Test
    void saveCourseTest(){
        Course course = new Course();
        course.setC_name("shit");
        course.setC_t_id(4);
        course.setC_abstract("sadjas");
        course.setUpid(15);
        Integer c_id = courseService.saveCourse(course);
        System.out.println(c_id);
    }

    @Test
    void findArticleByLikeTest(){
        List<Article> articles = articleService.findArticleByWeekHot();
        System.out.println(articles);

    }
    @Test
    void findArticleByNewTest(){
        List<Article> articles = articleService.findArticleByNew();
        System.out.println(articles);

    }
    @Test
    void getCourseByUIdTest(){
        List<Course> courses = courseService.getCourseByUId(13);
        System.out.println(courses);

    }

}

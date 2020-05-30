package com.zzm.service.impl;

import com.zzm.dao.CourseDao;
import com.zzm.dao.ExerciseDao;
import com.zzm.domain.Exercise;
import com.zzm.service.ExerciseService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("exerciseService")
@Transactional
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Override
    public List<Exercise> findExerciseByTime() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ExerciseDao exerciseDao = sqlSession.getMapper(ExerciseDao.class);
        return exerciseDao.findExerciseByTime();
    }
}

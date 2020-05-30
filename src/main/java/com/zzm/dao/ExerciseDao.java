package com.zzm.dao;

import com.zzm.domain.Exercise;

import java.util.List;

public interface ExerciseDao {
    public List<Exercise> findExerciseByTime();
}

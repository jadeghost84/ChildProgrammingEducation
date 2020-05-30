package com.zzm.controller;

import com.zzm.domain.Exercise;
import com.zzm.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ExerciseController {
    @Autowired
    public ExerciseService exerciseService;

    @GetMapping("/exercises")
    @ResponseBody
    public Map getExercises(@RequestParam("tab") String tab){
        Map result = new HashMap();
        if("1".equals(tab)){
            List<Exercise> exercises = exerciseService.findExerciseByTime();
            result.put("exercises",exercises);
        }


        return result;
    }
}

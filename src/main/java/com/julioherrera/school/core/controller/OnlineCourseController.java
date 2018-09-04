package com.julioherrera.school.core.controller;

import com.julioherrera.school.core.bs.dao.CourseRepository;
import com.julioherrera.school.core.eis.bo.Course;
import com.julioherrera.school.core.eis.bo.OnlineCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/onlineCourse", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class OnlineCourseController {
    @Autowired
    private CourseRepository courseRepository;
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Course> getAll() {
        return courseRepository.findAll();
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public Object save(@PathVariable("id") Long id, @RequestBody(required = true) OnlineCourse onlineCourse) {
        onlineCourse.setCourseId(id);
        return courseRepository.save(onlineCourse);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        courseRepository.deleteById(id);
    }
}

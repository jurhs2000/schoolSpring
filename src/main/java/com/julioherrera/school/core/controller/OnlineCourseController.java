package com.julioherrera.school.core.controller;

import com.julioherrera.school.core.bs.dao.CourseRepository;
import com.julioherrera.school.core.bs.dao.DepartmentRepository;
import com.julioherrera.school.core.bs.dao.OnlineCourseRepository;
import com.julioherrera.school.core.eis.bo.Course;
import com.julioherrera.school.core.eis.bo.Department;
import com.julioherrera.school.core.eis.bo.OnlineCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/onlineCourse", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class OnlineCourseController {
    @Autowired
    private OnlineCourseRepository onlineCourseRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<OnlineCourse> getAll() {
        return onlineCourseRepository.findAll();
    }
    @RequestMapping(method = RequestMethod.POST)
    public Object save(@RequestBody(required = true) OnlineCourse onlineCourse) {
        return onlineCourseRepository.save(onlineCourse);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public Object update(@PathVariable("id") Long id, @RequestBody(required = true) OnlineCourse onlineCourse) {
        onlineCourse.setCourseId(id);
        return onlineCourseRepository.save(onlineCourse);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        onlineCourseRepository.deleteById(id);
    }
}

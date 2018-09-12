package com.julioherrera.school.core.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.julioherrera.school.core.bs.dao.CourseRepository;
import com.julioherrera.school.core.bs.dao.DepartmentRepository;
import com.julioherrera.school.core.bs.dao.OnlineCourseRepository;
import com.julioherrera.school.core.eis.bo.Course;
import com.julioherrera.school.core.eis.bo.Department;
import com.julioherrera.school.core.eis.bo.OnlineCourse;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/online-course", produces = MediaType.APPLICATION_JSON_VALUE)
public class OnlineCourseController {
    @Autowired
    private OnlineCourseRepository onlineCourseRepository;
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<OnlineCourse> getAll(
            @RequestParam(value = "pageable", required = false) Boolean pageable,
            @RequestParam(value = "size", required = false) Integer size,
            @RequestParam(value = "page", required = false) Integer page
    ) {
        if(pageable) {
            return onlineCourseRepository.findAll(new PageRequest(page, size));
        } else {
            return onlineCourseRepository.findAll();
        }
    }
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Object getOne(@PathVariable("id") Long id) {
        return onlineCourseRepository.findOne(id);
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
            onlineCourseRepository.delete(id);
    }
}

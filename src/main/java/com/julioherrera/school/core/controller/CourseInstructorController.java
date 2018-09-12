package com.julioherrera.school.core.controller;

import com.julioherrera.school.core.bs.dao.CourseInstructorRepository;
import com.julioherrera.school.core.eis.bo.Course;
import com.julioherrera.school.core.eis.bo.CourseInstructor;
import com.julioherrera.school.core.eis.bo.CourseInstructorId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/course-instructor", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class CourseInstructorController {
    @Autowired
    private CourseInstructorRepository courseInstructorRepository;
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<CourseInstructor> getAll(
            @RequestParam(value = "pageable", required = false) boolean pageable,
            @RequestParam(value = "size", required = false) int size,
            @RequestParam(value = "page", required = false) int page
    ) {
        if(pageable) {
            return courseInstructorRepository.findAll(new PageRequest(page, size));
        } else {
            return courseInstructorRepository.findAll();
        }
    }
    @RequestMapping(method = RequestMethod.POST)
    public Object save(@RequestBody(required = true) CourseInstructor courseInstructor) {
        return courseInstructorRepository.save(courseInstructor);
    }
    @RequestMapping(method = RequestMethod.PATCH)
    public Object update(@RequestBody(required = true) CourseInstructor courseInstructor) {
        return courseInstructorRepository.save(courseInstructor);
    }
    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody(required = true) CourseInstructor courseInstructor) {
        courseInstructorRepository.delete(courseInstructor);
    }
}

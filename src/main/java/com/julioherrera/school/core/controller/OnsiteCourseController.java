package com.julioherrera.school.core.controller;

import com.julioherrera.school.core.bs.dao.OnsiteCourseRepository;
import com.julioherrera.school.core.eis.bo.OnsiteCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/onsiteCourse", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class OnsiteCourseController {
    @Autowired
    private OnsiteCourseRepository onsiteCourseRepository;
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<OnsiteCourse> getAll() {
        return onsiteCourseRepository.findAll();
    }
    @RequestMapping(method = RequestMethod.POST)
    public Object save(@RequestBody(required = true) OnsiteCourse onsiteCourse) {
        return onsiteCourseRepository.save(onsiteCourse);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public Object update(@PathVariable("id") Long id, @RequestBody(required = true) OnsiteCourse onsiteCourse) {
        onsiteCourse.setCourseId(id);
        return onsiteCourseRepository.save(onsiteCourse);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        onsiteCourseRepository.delete(id);
    }
}

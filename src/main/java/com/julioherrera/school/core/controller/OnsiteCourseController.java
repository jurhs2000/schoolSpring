package com.julioherrera.school.core.controller;

import com.julioherrera.school.core.bs.dao.OnsiteCourseRepository;
import com.julioherrera.school.core.eis.bo.OnsiteCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/onsite-course", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class OnsiteCourseController {
    @Autowired
    private OnsiteCourseRepository onsiteCourseRepository;
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<OnsiteCourse> getAll(
            @RequestParam(value = "pageable", required = false) boolean pageable,
            @RequestParam(value = "size", required = false) int size,
            @RequestParam(value = "page", required = false) int page
    ) {
        if(pageable) {
            return onsiteCourseRepository.findAll(new PageRequest(page, size));
        }else {
            return onsiteCourseRepository.findAll();
        }
    }
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Object getOne(@PathVariable("id") Long id) {
        return onsiteCourseRepository.findOne(id);
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

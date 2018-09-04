package com.julioherrera.school.core.controller;

import com.julioherrera.school.core.bs.dao.StudentGradeRepository;
import com.julioherrera.school.core.eis.bo.StudentGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/studentGrade", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class StudentGradeController {
    @Autowired
    private StudentGradeRepository studentGradeRepository;
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<StudentGrade> getAll() {
        return studentGradeRepository.findAll();
    }
    @RequestMapping(method = RequestMethod.POST)
    public Object save(@RequestBody(required = true) StudentGrade studentGrade) {
        return studentGradeRepository.save(studentGrade);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public Object update(@PathVariable("id") Long id, @RequestBody(required = true) StudentGrade studentGrade) {
        studentGrade.setEnrollmentId(id);
        return studentGradeRepository.save(studentGrade);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        studentGradeRepository.deleteById(id);
    }
}

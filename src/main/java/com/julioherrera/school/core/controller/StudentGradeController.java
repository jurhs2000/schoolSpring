package com.julioherrera.school.core.controller;

import com.julioherrera.school.core.bs.dao.PersonRepository;
import com.julioherrera.school.core.bs.dao.StudentGradeRepository;
import com.julioherrera.school.core.eis.bo.Person;
import com.julioherrera.school.core.eis.bo.StudentGrade;
import com.julioherrera.school.core.utils.NewResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1/student-grade", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class StudentGradeController {
    @Autowired
    private StudentGradeRepository studentGradeRepository;
    @Autowired
    private PersonRepository personRepository;
    NewResponseEntity newResponseEntity = new NewResponseEntity();
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<StudentGrade> getAll(
            @RequestParam(value = "pageable", required = false) boolean pageable,
            @RequestParam(value = "size", required = false) int size,
            @RequestParam(value = "page", required = false) int page
    ) {
        if(pageable) {
            return studentGradeRepository.findAll(new PageRequest(page, size));
        }else {
            return studentGradeRepository.findAll();
        }
    }
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Object getOne(@PathVariable("id") Long id) {
        return studentGradeRepository.findOne(id);
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody(required = true) StudentGrade studentGrade) {
        Person personExists = personRepository.findOne(studentGrade.getPerson().getPersonId());
        if (personExists == null) {
            studentGrade.setPerson(personRepository.save(studentGrade.getPerson()));
            studentGradeRepository.save(studentGrade);
        } else {
            StudentGrade newStudentGrade = studentGradeRepository.save(studentGrade);
            newStudentGrade.setPerson(studentGrade.getPerson());
            studentGradeRepository.save(newStudentGrade);
        }
        return newResponseEntity.json("saved successfully", HttpStatus.OK);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public Object update(@PathVariable("id") Long id, @RequestBody(required = true) StudentGrade studentGrade) {
        studentGrade.setEnrollmentId(id);
        return studentGradeRepository.save(studentGrade);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        studentGradeRepository.delete(id);
    }
}

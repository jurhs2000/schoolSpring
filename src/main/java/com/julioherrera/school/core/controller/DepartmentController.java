package com.julioherrera.school.core.controller;

import com.julioherrera.school.core.bs.dao.DepartmentRepository;
import com.julioherrera.school.core.eis.bo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/department", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Department> getAll() {
        return departmentRepository.findAll();
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public Object save(@PathVariable("id") Long id, @RequestBody(required = true) Department department) {
        department.setDepartmentID(id);
        return departmentRepository.save(department);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        departmentRepository.deleteById(id);
    }
}

package com.julioherrera.school.core.controller;

import com.julioherrera.school.core.bs.dao.DepartmentRepository;
import com.julioherrera.school.core.eis.bo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/department", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Department> getAll(
            @RequestParam(value = "pageable", required = false) boolean pageable,
            @RequestParam(value = "size", required = false) int size,
            @RequestParam(value = "page", required = false) int page
    ) {
        if(pageable) {
            return departmentRepository.findAll(new PageRequest(page, size));
        }else {
            return departmentRepository.findAll();
        }
    }
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Object getOne(@PathVariable("id") Long id) {
        return departmentRepository.findOne(id);
    }
    @RequestMapping(method = RequestMethod.POST)
    public Object save(@RequestBody(required = true) Department department) {
        return departmentRepository.save(department);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public Object update(@PathVariable("id") Long id, @RequestBody(required = true) Department department) {
        department.setDepartmentId(id);
        return departmentRepository.save(department);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        departmentRepository.delete(id);
    }
}

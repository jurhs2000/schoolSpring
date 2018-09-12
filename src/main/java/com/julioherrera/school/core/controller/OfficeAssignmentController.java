package com.julioherrera.school.core.controller;

import com.julioherrera.school.core.bs.dao.OfficeAssignmentRepository;
import com.julioherrera.school.core.eis.bo.OfficeAssignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/office-assignment", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class OfficeAssignmentController {
    @Autowired
    private OfficeAssignmentRepository officeAssignmentRepository;
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<OfficeAssignment> getAll(
            @RequestParam(value = "pageable", required = false) boolean pageable,
            @RequestParam(value = "size", required = false) int size,
            @RequestParam(value = "page", required = false) int page
    ) {
        if(pageable) {
            return officeAssignmentRepository.findAll(new PageRequest(page, size));
        } else {
            return officeAssignmentRepository.findAll();
        }
    }
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Object getOne(@PathVariable("id") Long id) {
        return officeAssignmentRepository.findOne(id);
    }
    @RequestMapping(method = RequestMethod.POST)
    public Object save(@RequestBody(required = true) OfficeAssignment officeAssignment) {
        return officeAssignmentRepository.save(officeAssignment);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public Object update(@PathVariable("id") Long id, @RequestBody(required = true) OfficeAssignment officeAssignment) {
        officeAssignment.setInstructorId(id);
        return officeAssignmentRepository.save(officeAssignment);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        officeAssignmentRepository.delete(id);
    }
}

package com.example.springbootjpaexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    // Save operation
    @PostMapping("/departments")
    public Department saveDepartment(
            @RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    // Read operation
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        return departmentService.fetchDepartmentList();
    }

    // Read operation
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentList(@PathVariable("id") Long departmentId) {
        Optional<Department> optionalDept = departmentService.fetchDepartment(departmentId);
        if(optionalDept.isPresent()) {
            return optionalDept.get();
        }
        else{
            return new Department();
        }
    }

    // Update operation
    @PutMapping("/departments/{id}")
    public Department
    updateDepartment(@RequestBody Department department,
                     @PathVariable("id") Long departmentId) {
        return departmentService.updateDepartment(
                department, departmentId);
    }

    // Delete operation
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id")
                                       Long departmentId) {
        departmentService.deleteDepartmentById(
                departmentId);

        return "Deleted Successfully";
    }

}

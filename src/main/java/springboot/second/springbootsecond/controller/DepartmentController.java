package springboot.second.springbootsecond.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.second.springbootsecond.entity.Department;
import springboot.second.springbootsecond.service.DepartmentService;
import springboot.second.springbootsecond.service.DepartmentServiceImpl;

@RestController
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        return departmentService.fetchDepartmentList();
    }
    
    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments/{departmentId}")
    public Department fetchDepartmentById(@PathVariable("departmentId") Long departmentId) {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{departmentId}")
    public String deleteDepartmentById(@PathVariable("departmentId") Long departmentId) {
        return departmentService.deleteDepartmentById(departmentId);
    }
}

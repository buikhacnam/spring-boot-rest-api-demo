package springboot.second.springbootsecond.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.second.springbootsecond.entity.Department;
import springboot.second.springbootsecond.service.DepartmentService;
import springboot.second.springbootsecond.error.DepartmentNotFoundException;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments/{departmentId}")
    public ResponseEntity<Department> fetchDepartmentById(@PathVariable("departmentId") Long departmentId) {
        LOGGER.info("Inside fetchDepartmentById of DepartmentController");
        Department departmentFound = departmentService.fetchDepartmentById(departmentId);
        // test response
        return ResponseEntity.status(999).body(departmentFound);
    }

    @DeleteMapping("/departments/{departmentId}")
    public String deleteDepartmentById(@PathVariable("departmentId") Long departmentId) {
        LOGGER.info("Inside deleteDepartmentById of DepartmentController");
        return departmentService.deleteDepartmentById(departmentId);
    }

    @PutMapping("/departments/{departmentId}") 
    // test custom exception with response
    public Department updateDepartmentById(@PathVariable("departmentId") Long departmentId,
            @RequestBody Department department) throws DepartmentNotFoundException {
                return departmentService.updateDepartmentById(departmentId, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }


    // getting welcomeMessage from application.properties file (welcome.message)
    @Value("${welcome.message}")
    private String welcomeMessage;

    @GetMapping("/test")
    public ResponseEntity<Map<String, Object>> testResponse() {
        Map<String, Object> res = new HashMap<>();
        int[] arr = {1,2,3};
        res.put("Nice", true);
        res.put("message", welcomeMessage);
        res.put("arr", arr);
        return ResponseEntity.ok(res);
    }
}

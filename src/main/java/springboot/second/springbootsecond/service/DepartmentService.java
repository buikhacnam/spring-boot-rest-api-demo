package springboot.second.springbootsecond.service;

import java.util.List;

import org.springframework.stereotype.Service;
import springboot.second.springbootsecond.entity.Department;

@Service
public interface DepartmentService {

    public List<Department> fetchDepartmentList();

    public Department saveDepartment(Department department);

    public Department fetchDepartmentById(Long departmentId);

    public String deleteDepartmentById(Long departmentId);

}

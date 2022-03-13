package springboot.second.springbootsecond.service;

import java.util.List;

import springboot.second.springbootsecond.entity.Department;
import springboot.second.springbootsecond.error.DepartmentNotFoundException;

public interface DepartmentService {

    public List<Department> fetchDepartmentList();

    public Department saveDepartment(Department department);

    public Department fetchDepartmentById(Long departmentId);

    public String deleteDepartmentById(Long departmentId);

    public Department updateDepartmentById(Long departmentId, Department department) throws DepartmentNotFoundException;

    public Department fetchDepartmentByName(String departmentName);

}

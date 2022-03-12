package springboot.second.springbootsecond.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.second.springbootsecond.entity.Department;
import springboot.second.springbootsecond.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    
    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public String deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);

        return "department delelted";
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {
        Department d = departmentRepository.findById(departmentId).get();

        if(
            Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())
            &&
            Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())
            &&
            Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())
        ) {
            d.setDepartmentName(department.getDepartmentName());
            d.setDepartmentCode(department.getDepartmentCode());
            d.setDepartmentAddress(department.getDepartmentAddress());
        } else {
            System.out.println("not all fields have value");
            return null;
        }

        return departmentRepository.save(d);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }
}

package by.tunyakin.service;

import by.tunyakin.model.Department;
import by.tunyakin.model.User;
import by.tunyakin.service.api.IDepartmentService;
import by.tunyakin.storage.IDepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {

    private final IDepartmentRepository departmentRepository;

    public DepartmentService (IDepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getDepartmentsByName(String name) {
        return null;
    }

    @Override
    public List<Department> getAllDepartments() {
        final List<Department> departmentList = this.departmentRepository.findAll();
        return departmentList;
    }

    @Override
    public Department getDepartmentByName(String name) {
        Department department;
        department = this.departmentRepository.getByName(name);
        return department;
    }
}

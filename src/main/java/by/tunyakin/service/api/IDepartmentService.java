package by.tunyakin.service.api;

import by.tunyakin.model.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> getDepartmentsByName(String name);
    List<Department> getAllDepartments ();
    Department getDepartmentByName(String name);
}

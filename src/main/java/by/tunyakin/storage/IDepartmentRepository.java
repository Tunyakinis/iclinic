package by.tunyakin.storage;

import by.tunyakin.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
    List<Department> findByName(String name);

    Department getByName(String name);

    @Query(value ="SELECT name FROM iclinic_project.departments ORDER BY id", nativeQuery = true)
    List<String> findAllDepartmentNames ();
}

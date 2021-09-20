package by.tunyakin.controller;

import by.tunyakin.service.api.IDepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/departments")
public class DepartmentsController {

    private IDepartmentService departmentsService;

    public DepartmentsController(IDepartmentService departmentsService) {
        this.departmentsService = departmentsService;
    }

    @GetMapping
    public String getDepartmentPage(Model model) {
        model.addAttribute("departmentList", departmentsService.getAllDepartments());
        return "departments";
    }
}

package by.tunyakin.controller;

import by.tunyakin.model.enums.Role;
import by.tunyakin.service.api.IUserService;
import by.tunyakin.storage.IDepartmentRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private IUserService userService;
    private IDepartmentRepository departmentRepository;

    public AdminController(IUserService userService, IDepartmentRepository departmentRepository) {
        this.userService = userService;
        this.departmentRepository = departmentRepository;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getUserProfileList(Model model) {
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("roleList", Role.values());
        model.addAttribute("departmentList", departmentRepository.findAllDepartmentNames());
        return "admin";
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String updateUserSettings(@RequestParam(name = "role") Role role,
                               @RequestParam(name = "department") String department,
                               @RequestParam(name = "login") String login,
                               Model model) {
        userService.updateUserRoleAndDepartment(role, department, login);
        return "admin";
    }
}

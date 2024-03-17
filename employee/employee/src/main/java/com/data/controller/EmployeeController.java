package com.data.controller;

import com.data.entity.Employee;
import com.data.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }
    @GetMapping("/employees")
    public String dashboardEmployees() {
        return "dashboard";
    }
    // expose "/employees" and return list of employees
    @GetMapping("/employees/list")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAllEmployee());
        return "all-employees";
    }
    @GetMapping("/employees/new")
    public String createEmployeeForm(Model model) {
        // create employee object to hold employee form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create-employee";
    }
    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees/list";
    }
    @GetMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        // delete the employee
        employeeService.deleteById(id);
        // redirect to /employees/list
        return "redirect:/employees/list";
    }
}











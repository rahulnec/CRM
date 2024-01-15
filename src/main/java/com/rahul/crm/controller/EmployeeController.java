package com.rahul.crm.controller;

import com.rahul.crm.model.Employee;
import com.rahul.crm.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/crm/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostConstruct
    private void loadData() {
    }

    @GetMapping("/list")
    public String findAllEmployee(Model model) {
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employees", employeeList);
        return "employees/list-employee";
    }

    @GetMapping("/addEmployee")
    public String addEmployee(Model model){
        // create model attribute to bind the data
        Employee employee = new Employee();

        model.addAttribute("employee",employee);

        return "employees/employee-form";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int id,Model model){
        employeeService.delete(id);
        return "redirect:/crm/employees/list";
    }
    @GetMapping("/updateEmployee")
    public String update(@RequestParam("employeeId") int id,Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return "redirect:/crm/employees/list";
    }
}

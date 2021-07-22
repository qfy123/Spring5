package com.qfy.springmvc_crud.controller;

import com.qfy.springmvc_crud.dao.DepartmentDao;
import com.qfy.springmvc_crud.dao.EmployeeDao;
import com.qfy.springmvc_crud.entity.Department;
import com.qfy.springmvc_crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author QFY
 * @Description
 * @create 2021-07-17 10:40
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    //查询所有员工
    @RequestMapping("/emps")
    public String getEmps(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        return "list";
    }

    /**
     * 去员工添加页面，在此之前需要查出所有部门信息并展示
     * @return
     */
    @RequestMapping("/emps/toaddpage")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        model.addAttribute("employee",new Employee());
        return "add";
    }
    @RequestMapping(value = "/emp",method= RequestMethod.POST)
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 查询员工，来到修改页面并回显
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/emps/{id}",method=RequestMethod.GET)
    public String getEmp(@PathVariable("id")Integer id,Model model){
        //查询员工信息
        Employee employee = employeeDao.get(id);
        //放在请求域中
        model.addAttribute("employee",employee);
        //查出部门信息放在隐含模型中
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "edit";
    }
    @RequestMapping(value = "/emps/{id}",method = RequestMethod.PUT)
    public String updateEmp(@ModelAttribute("employee")Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @ModelAttribute
    public void myModelAttribute(@RequestParam(value = "id",required = false)Integer id,Model model){
        if (id != null) {
            Employee employee = employeeDao.get(id);
            model.addAttribute("employee",employee);
        }
    }
    @RequestMapping(value = "/emps/{id}",method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}

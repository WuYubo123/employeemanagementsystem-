package com.wyb.springboot03web.controller;

import com.wyb.springboot03web.mapper.DepartmentMapper;
import com.wyb.springboot03web.mapper.EmployeeMapper;
import com.wyb.springboot03web.pojo.Department;
import com.wyb.springboot03web.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeMapper employeeDao;
    @Autowired
    DepartmentMapper departmentDao;
    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employeeDaoAll = employeeDao.getAll();
        model.addAttribute("emps",employeeDaoAll);
        return "/emp/list";

    }

    @GetMapping("/toAddEmp")//限定死了，只能有get方式提交过来
    public String toAddEmps(Model model){
        //查出所有部门的信
        Collection<Department> allDepartment = departmentDao.getAllDepartment();
        model.addAttribute("departments",allDepartment);

        return "/emp/add";

    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);//保存信息
        System.out.println(employee);
        //添加成功走该请求跳转至首页刷新列表
        return "redirect:/emps";
    }
    @GetMapping("/emp/{id}")//以链接形式传参，用getMapping
    public String toUpdateEmp(@PathVariable("id")Integer id,Model model){
        //查出原来的数据
        Employee employee = employeeDao.getEmployeeById(id);
        Collection<Department> allDepartment = departmentDao.getAllDepartment();

        //查出的数据返回到前端
        model.addAttribute("emp",employee);
        model.addAttribute("departments",departmentDao.getAllDepartment());

        return "emp/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        System.out.println("updateEmp===>"+employee);
        employeeDao.updateEmp(employee);
        return "redirect:/emps";

    }

    @GetMapping("/deleEmp/{id}")//以链接形式传参，用getMapping
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}

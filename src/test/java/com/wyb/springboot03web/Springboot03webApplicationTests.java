package com.wyb.springboot03web;

import com.wyb.springboot03web.mapper.DepartmentMapper;
import com.wyb.springboot03web.mapper.EmployeeMapper;
import com.wyb.springboot03web.pojo.Department;
import com.wyb.springboot03web.pojo.Employee;
import com.wyb.springboot03web.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class Springboot03webApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    UserService userService;


    @Test
    void contextLoads() throws SQLException {
        System.out.println(userService.queryUserByName("wuwu"));
    }

}

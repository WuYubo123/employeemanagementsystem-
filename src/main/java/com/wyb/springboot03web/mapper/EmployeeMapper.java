package com.wyb.springboot03web.mapper;

import com.wyb.springboot03web.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;
@Mapper
@Repository
public interface EmployeeMapper {

    void save(Employee employee);

    List<Employee> getAll();

    Employee getEmployeeById(Integer id);

    void delete(Integer id);

    void updateEmp(Employee employee);
}

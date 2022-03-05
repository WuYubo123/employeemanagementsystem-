package com.wyb.springboot03web.mapper;

import com.wyb.springboot03web.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {

    //获取所有部门信息
    List<Department> getAllDepartment();

    //通过id得到部门
    Department getDepartmentById(Integer id);

}

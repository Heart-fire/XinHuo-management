package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {

    /**
     * 员工信息查询
     * 用到动态SQL 直接用XML配置文件
     * @return 1
     */
    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除
     * @param ids ids
     */
    void delete(List<Integer> ids);

    /**
     * 添加用户
     * @param emp emp
     */
    void insert(Emp emp);

    /**
     * 根据用户ID查询信息
     * @param id id
     * @return emp
     */
    Emp findById(Integer id);

    /**
     * 更新用户
     * @param emp emp
     */
    void update(Emp emp);

    Emp getByUsernameAndPassword(Emp emp);
}

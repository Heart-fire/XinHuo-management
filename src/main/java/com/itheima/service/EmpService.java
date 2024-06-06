package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {
    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    /**
     * 批量删除
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 新增员工
     * @param emp
     */
    void save(Emp emp);

    Emp getById(Integer id);

    /**
     * 更新员工
     * @param emp
     */
    void update(Emp emp);

    /**
     * 用户登录
     * @param emp
     * @return
     */
    Emp login(Emp emp);

//            <!--PageHelper依赖-->
//        <dependency>
//            <groupId>com.github.pagehelper</groupId>
//            <artifactId>pagehelper-spring-boot-starter</artifactId>
//            <version>1.4.3</version>
//        </dependency>
}

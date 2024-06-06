package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Override
    public PageBean page(Integer page, Integer pageSize,String name, Short gender,LocalDate begin,LocalDate end) {
        //1. 设置分页参数
        PageHelper.startPage(page,pageSize);
        //2. 执行查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;
        //3. 封装PageBean对象
        PageBean pageBean = new PageBean(p.getResult(),p.getTotal());
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    /**
     * 新增员工
     * @param emp emp
     */
    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setEntrydate(LocalDate.now());
        empMapper.insert(emp);
    }

    /**
     * 根据用户ID查询信息
     * @param id id
     * @return emp
     */
    @Override
    public Emp getById(Integer id) {
        return empMapper.findById(id);
    }

    /**
     * 更新用户
     * @param emp emp
     */
    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    /**
     * 用户登录
     * @param emp
     * @return
     */
    @Override
    public Emp login(Emp emp) {
        //调用dao层功能：登录
        Emp loginEmp = empMapper.getByUsernameAndPassword(emp);
        //返回查询结果给Controller
        return loginEmp;
    }
}

package com.huwenkang.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.huwenkang.reggie.common.R;
import com.huwenkang.reggie.entity.Employee;
import com.huwenkang.reggie.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public R<Employee> login(@RequestBody Employee employee, HttpServletRequest httpServletRequest) {

        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        LambdaQueryWrapper<Employee> employeeLambdaQueryWrapper = new LambdaQueryWrapper<>();
        employeeLambdaQueryWrapper.eq(Employee::getUsername, employee.getUsername());
        Employee emp = employeeService.getOne(employeeLambdaQueryWrapper);

        if (emp == null) {
            return R.error("登录失败");
        }

        if (!password.equals(emp.getPassword())) {
            return R.error("登录失败");
        }

        if (emp.getStatus() == 0) {
            return R.error("账号已禁用");
        }

        httpServletRequest.getSession().setAttribute("employee", emp.getId());

        return R.success(emp);
    }

    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest httpServletRequest) {
        httpServletRequest.removeAttribute("employee");
        return R.success("退出成功");
    }

    @PostMapping
    public R<String> save(HttpServletRequest httpServletRequest, @RequestBody Employee employee) {

        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));

        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());

        Long userId = (Long) httpServletRequest.getSession().getAttribute("employee");
        employee.setCreateUser(userId);
        employee.setUpdateUser(userId);

        employeeService.save(employee);

        return R.success("新增员工成功");
    }

    @GetMapping("/page")
    public R<Page<Employee>> page(int page, int pageSize, String name) {
        Page<Employee> pageInfo = new Page<>();

        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(name), Employee::getName, name);

        queryWrapper.orderByDesc(Employee::getUpdateTime);

        employeeService.page(pageInfo);

        return R.success(pageInfo);
    }
}

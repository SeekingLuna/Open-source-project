package com.li.service.impl;

import com.li.dao.EmpDao;
import com.li.dao.impl.EmpDaoA;
import com.li.domain.Emp;
import com.li.service.Empservice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpserviceA implements Empservice {
    EmpDao empDao = new EmpDaoA();


    @Override
    public List<Emp> listEmp() {
        List<Emp> empList = empDao.listEmp();

        //2.对数据进行处理-gender和job
        empList.stream().forEach(emp -> {
            String gender = emp.getGender();
            if ("1".equals(gender)) {

                emp.setGender("男");


            } else if ("2".equals(gender)) {
                emp.setGender("女");

            }
            String job = emp.getJob();
            if ("1".equals(job)) {
                emp.setJob("讲师");
            } else if ("2".equals(job)) {
                emp.setJob("班主任");

            } else if ("3".equals(job)) {
                emp.setJob("就业指导");

            }

        });
        return empList;
    }
}

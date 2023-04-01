package com.li.dao.impl;

import com.li.dao.EmpDao;
import com.li.domain.Emp;
import com.li.utils.XmlParserUtils;

import java.util.List;

public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        //1.加载并解析emp.xml
        String filePath = "D:\\JavaDevelop\\MyProject\\li-web\\src\\main\\resources\\emp.xml";
        System.out.println(filePath);
        List<Emp> empList = XmlParserUtils.parse(filePath, Emp.class);
        return empList;
    }
}

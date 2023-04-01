package com.li.controller;

import com.li.domain.Emp;
import com.li.domain.Result;
import com.li.service.Empservice;
import com.li.service.impl.EmpserviceA;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    private Empservice empservice = new EmpserviceA();

    @RequestMapping(value = "/listEmp", method = {RequestMethod.GET, RequestMethod.POST})
    public Result list() {
        List<Emp> empList = empservice.listEmp();
        return new Result(0, "success", empList);
    }

//      //1.加载并解析emp.xml
//       String filePath="D:\\JavaDevelop\\MyProject\\li-web\\src\\main\\resources\\emp.xml";
//        System.out.println(filePath);
//        List<Emp> empList=  XmlParserUtils.parse(filePath, Emp.class);
//
//        //2.对数据进行处理-gender和job
//        empList.stream().forEach(emp ->{
//            String gender= emp.getGender();
//            if ("1".equals(gender)){
//
//                emp.setGender("男");
//
//
//            }else if ("2".equals(gender)){
//                emp.setGender("女");
//
//            }
//        String job= emp.getJob();
//            if ("1".equals(job)){
//                emp.setJob("讲师");
//            }else if ("2".equals(job)){
//                emp.setJob("班主任");
//
//            } else if ("3".equals(job)) {
//                emp.setJob("就业指导");
//
//            }
//
//        } );


}

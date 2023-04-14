package com.li.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Controller(value = "/")
@RestController("/")
public class Controller01 {


    @RequestMapping(value = "/abc", method = {RequestMethod.GET, RequestMethod.POST})
    public String abc() {

        return "李哥yyds";
    }


//    @RequestMapping(value = "/cbd", method = {RequestMethod.GET, RequestMethod.POST})
//    public Model cbd() {
//        Model model = new Model();
//        Model model1 = model.addAttribute("李哥万岁万岁万万岁");
//        return model1;
//    }
}

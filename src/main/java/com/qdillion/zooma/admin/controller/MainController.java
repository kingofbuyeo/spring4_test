package com.qdillion.zooma.admin.controller;

import com.qdillion.zooma.admin.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kimyongchul
 * Created on 2017. 11. 16.
 */
@Controller
@RequestMapping("/")
@Slf4j
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping("test/{name}")
    public ModelAndView main(
            Model model,
            @PathVariable String name
    ){
        ModelAndView modelAndView       = new ModelAndView();

        model.addAttribute("users", userService.selectUserList());

        ParentClass parentClass         = new ChildOneClass();
        log.debug("Parent Class : " + parentClass.process());
        parentClass                     = new ChildTwoClass();
        log.debug("Parent Class : " + parentClass.process());

        model.addAttribute("name", name);
        modelAndView.setViewName("main");

        return modelAndView;
    }

    @RequestMapping(value="/json")
    @ResponseBody
    public Object getJsonCheck(
            Model model
    ){
        model.addAttribute("test", "test");
        model.addAttribute("test1", "test1");
        model.addAttribute("test2", "test2");
        Map<String, Object> result  = new HashMap<>();
        result.put("test", "test");
        result.put("test1", "test1");
        result.put("test2", "test2");
        return result;
    }

    @RequestMapping(value="test/test/url")
    @ResponseBody
    public Object loginUrlCheckTest(
            Model model
    ){
        Map<String, Object> result  = new HashMap<>();
        result.put("test", "test");
        result.put("test1", "test1");
        result.put("test2", "test2");
        return result;
    }
}

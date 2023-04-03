package com.springboot.controller;


import com.springboot.entity.Discuss;
import com.springboot.form.DiscussForm;
import com.springboot.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2023-03-30
 */
@RestController
@RequestMapping("/discuss")
public class DiscussController {
    @Autowired
    DiscussService discussService;

    @GetMapping ("/getdiscuss")
    public List getdiscuss(String classname){
        List list = this.discussService.getdiscuss(classname);
        return list;
    }

    @GetMapping("/getmydiscuss")
    public List  getmydiscuss(String username){
        List list = this.discussService.getmydiscuss(username);
        return  list;
    }

    @PostMapping("/submit")
    public String subdiscuss(@RequestBody Discuss discuss){
        boolean save = this.discussService.save(discuss);
        String res;
        if(!save){
            res = "add失败";
        }else {
            res = "add成功";
        }
        return res;
    }

}


package com.springboot.controller;


import com.springboot.form.RuleForm;
import com.springboot.service.SysAdminService;
import com.springboot.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2023-03-20
 */
@RestController
@RequestMapping("/sysAdmin")
public class SysAdminController {
    @Autowired
    SysAdminService sysAdminService;

    @GetMapping("/login")
    public ResultVO login(RuleForm ruleForm){
        ResultVO resultVO = this.sysAdminService.login(ruleForm);
        return resultVO;
    }

}


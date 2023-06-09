package com.springboot.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.springboot.entity.UserAdmin;
import com.springboot.form.ChangepasswordForm;
import com.springboot.form.RuleForm;
import com.springboot.mapper.UserAdminMapper;
import com.springboot.service.UserAdminService;
import com.springboot.util.ResultVOUtil;
import com.springboot.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2023-03-20
 */
@RestController
@RequestMapping("/userAdmin")
public class UserAdminController {
    @Autowired
    private UserAdminService userAdminService;


    @GetMapping("/login")
    public ResultVO login(RuleForm ruleForm){
        ResultVO resultVO = this.userAdminService.login(ruleForm);
        return resultVO;
    }
    @Autowired
    private UserAdminMapper userAdminMapper;
    @PostMapping("/tijiao")
    public ResultVO tijiao(@RequestBody UserAdmin userAdmin){
        QueryWrapper<UserAdmin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",userAdmin.getUserName());
        UserAdmin userAdmin1 = this.userAdminMapper.selectOne(queryWrapper);
        if(userAdmin1 == null) {
            //判断账号是否已经存在
            boolean save = this.userAdminService.save(userAdmin);
            if (!save) return ResultVOUtil.fail1();
            //未知错误导致账号add失败，返回-1
            return ResultVOUtil.success(null);
        }else{
            //账号已存在，返回-2
            return ResultVOUtil.fail2();
        }
    }
    @Autowired
    private UserAdminMapper userAdminMapper1;
    @GetMapping("/changepassword")
    public ResultVO changepassword(ChangepasswordForm changepasswordForm){
//        queryWrapper.eq("user_name",changepasswordForm.getUsername());
//        UserAdmin userAdmin1 = this.userAdminMapper1.selectOne(queryWrapper);
        userAdminService.update(Wrappers.<UserAdmin>update().lambda().set(UserAdmin::getUserPassword,changepasswordForm.getNewpassword()).eq( UserAdmin::getUserName,changepasswordForm.getUsername()));
        QueryWrapper<UserAdmin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",changepasswordForm.getUsername());
        UserAdmin userAdmin1 = this.userAdminMapper1.selectOne(queryWrapper);
        if( userAdmin1.getUserPassword()!= changepasswordForm.getOldpassword()){
            return ResultVOUtil.success(null);
        }else{
            System.out.println(userAdmin1.getUserPassword()+"...."+ changepasswordForm.getOldpassword());
            return ResultVOUtil.fail1();

        }

    }
    @GetMapping("/test")
    public String login(){

        return "yes";

    }

}


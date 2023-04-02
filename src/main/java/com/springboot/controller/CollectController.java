package com.springboot.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.springboot.entity.Collect;
import com.springboot.entity.UserAdmin;
import com.springboot.form.Mycollect;
import com.springboot.mapper.CollectMapper;
import com.springboot.service.CollectService;
import com.springboot.util.ResultVOUtil;
import com.springboot.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.sql.Wrapper;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2023-04-02
 */
@RestController
@RequestMapping("/collect")
public class CollectController {
    @Autowired
    private CollectService collectService;

    @Autowired
    private CollectMapper collectMapper;

    @PostMapping("/addcollect")
    public ResultVO addcollect(@RequestBody Collect collect){
        boolean save = this.collectService.save(collect);
        if(!save){
            return ResultVOUtil.fail1();
        }else {
            return ResultVOUtil.success(null);
        }
    }

    @PostMapping("/delcollect")
    public ResultVO delcollect(@RequestBody Mycollect mycollect){
        collectService.remove(Wrappers.<Collect>query().lambda().eq(Collect::getUsername,mycollect.getUsername()).eq(Collect::getClassname,mycollect.getClassname()));
        QueryWrapper<Collect> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",mycollect.getUsername()).eq("classname",mycollect.getClassname());
        Collect collect = this.collectMapper.selectOne(queryWrapper);
        if(collect == null){
            return  ResultVOUtil.success(null);
        }else {
            return ResultVOUtil.fail1();
        }
        
    }

    @PostMapping("iscollect")
    public ResultVO iscollect(@RequestBody Mycollect mycollect){
        ResultVO resultVO = this.collectService.iscollect(mycollect);
        return  resultVO;
    }


}


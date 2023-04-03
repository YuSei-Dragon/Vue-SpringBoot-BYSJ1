package com.springboot.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.springboot.entity.States;
import com.springboot.form.Mystate;
import com.springboot.mapper.StatesMapper;
import com.springboot.service.StatesService;
import com.springboot.util.ResultVOUtil;
import com.springboot.vo.ResultVO;
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
 * @since 2023-04-03
 */
@RestController
@RequestMapping("/states")
public class StatesController {
    @Autowired
    private StatesService statesService;

    @GetMapping("/getmystates")
    public List getmystates( String username){
        List list = this.statesService.getmystates(username);
        return  list;
    }

    @Autowired
    private StatesMapper statesMapper;

    @PostMapping("/addmystates")
    public ResultVO addmystates(@RequestBody States states){
        QueryWrapper<States> wrapper = new QueryWrapper();
        wrapper.eq("username",states.getUsername()).eq("classes",states.getClasses());
        States states1 = this.statesMapper.selectOne(wrapper);
        if(states1 == null){
            //并无相应记录，可添加
            boolean save = this.statesService.save(states);
            if(!save){
                return ResultVOUtil.fail2();
            }else {
                return ResultVOUtil.success(null);
            }
        }
        else {
            return ResultVOUtil.fail1();
            //已有记录，增加出错
        }
    }
    @PostMapping("/delmystates")
    public ResultVO delmystates(@RequestBody States states){
        statesService.remove(Wrappers.<States>query().lambda().eq(States::getUsername,states.getUsername()).eq(States::getClasses,states.getClasses()));
        QueryWrapper<States> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",states.getUsername()).eq("classes",states.getClasses());
        States states1 = this.statesMapper.selectOne(queryWrapper);
        if(states1==null){
            return ResultVOUtil.success(null);
        }else {
            return ResultVOUtil.fail1();
        }

    }

    @PostMapping("/ismystates")
    public ResultVO ismystates(@RequestBody States states){
        ResultVO resultVO = this.statesService.ismystates(states);
        return resultVO;
    }

}


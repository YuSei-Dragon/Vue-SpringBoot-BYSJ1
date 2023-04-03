package com.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.springboot.entity.States;
import com.springboot.mapper.StatesMapper;
import com.springboot.service.StatesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2023-04-03
 */
@Service
public class StatesServiceImpl extends ServiceImpl<StatesMapper, States> implements StatesService {

    @Autowired
    private StatesMapper statesMapper;

    @Override
    public List getmystates(String username){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username",username);
        List<States> list = statesMapper.selectList(wrapper);
        return list;
    }

    @Override
    public ResultVO ismystates(States states){
        QueryWrapper<States> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",states.getUsername()).eq("classes",states.getClasses());
        States states1 = this.statesMapper.selectOne(queryWrapper);
        ResultVO resultVO = new ResultVO();
        if(states1 == null){
            resultVO.setCode(-1);
            //未完成
        }else {
            resultVO.setCode(0);
            //已完成
        }
        return resultVO;
    }
}

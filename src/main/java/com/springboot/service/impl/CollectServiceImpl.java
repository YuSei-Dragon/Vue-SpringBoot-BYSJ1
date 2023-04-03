package com.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.entity.Collect;
import com.springboot.entity.UserAdmin;
import com.springboot.form.Mycollect;
import com.springboot.mapper.CollectMapper;
import com.springboot.service.CollectService;
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
 * @since 2023-04-02
 */
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public ResultVO iscollect(Mycollect mycollect){
        QueryWrapper<Collect> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",mycollect.getUsername()).eq("classname",mycollect.getClassname());
        Collect collect = this.collectMapper.selectOne(queryWrapper);
        ResultVO resultVO = new ResultVO();
        if(collect == null){
            resultVO.setCode(0);
            //没发现已经收藏，所以可以收藏
        }else {
            resultVO.setCode(-1);
            //已经有相应记录
        }
        return resultVO;

    }

    @Override
    public List getcollect(String username){
        QueryWrapper<Collect> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        List list = collectMapper.selectList(queryWrapper);
        return list;
    }
}

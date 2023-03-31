package com.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.entity.Discuss;
import com.springboot.form.DiscussForm;
import com.springboot.mapper.DiscussMapper;
import com.springboot.service.DiscussService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2023-03-30
 */
@Service
public class DiscussServiceImpl extends ServiceImpl<DiscussMapper, Discuss> implements DiscussService {

    @Autowired
    private DiscussMapper discussMapper;


    @Override
    public List getdiscuss(String classname){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("classes",classname);
        List<DiscussForm> list = discussMapper.selectList(wrapper);
        return list;
    }

}

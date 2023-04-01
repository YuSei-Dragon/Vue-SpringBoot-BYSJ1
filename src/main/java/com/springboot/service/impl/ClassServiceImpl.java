package com.springboot.service.impl;

import com.springboot.entity.Class;
import com.springboot.form.myclass;
import com.springboot.mapper.ClassMapper;
import com.springboot.mapper.DiscussMapper;
import com.springboot.service.ClassService;
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
 * @since 2023-03-29
 */
@Service
public class ClassServiceImpl extends ServiceImpl<ClassMapper, Class> implements ClassService {
    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private DiscussMapper discussMapper;

    @Override
    public List search(){
        List list = classMapper.selectList(null);
        return list;
    }
    @Override
    public List echart(){
        List alldiscuss = discussMapper.selectList(null);

        List allclasses = classMapper.selectList(null);

//        System.out.println("stop!!!!!!!!!!!!!!!!!!");
//        System.out.println(alldiscuss.toString());
//        System.out.println("stop!!!!!!!!!!!!!!!!!!");
        return alldiscuss;
    }

}

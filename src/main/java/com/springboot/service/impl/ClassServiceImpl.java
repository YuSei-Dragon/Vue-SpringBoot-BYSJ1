package com.springboot.service.impl;

import com.springboot.entity.Class;
import com.springboot.form.SearchForm;
import com.springboot.mapper.ClassMapper;
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

    @Override
    public List search(){
        List list = classMapper.selectList(null);
        return list;
    }

}

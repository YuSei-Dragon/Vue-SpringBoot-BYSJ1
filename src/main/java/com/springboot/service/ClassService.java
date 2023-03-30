package com.springboot.service;

import com.springboot.entity.Class;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.form.SearchForm;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2023-03-29
 */
public interface ClassService extends IService<Class> {

    public List search();
}

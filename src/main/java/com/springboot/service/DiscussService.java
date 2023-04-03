package com.springboot.service;

import com.springboot.entity.Discuss;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.form.DiscussForm;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2023-03-30
 */
public interface DiscussService extends IService<Discuss> {

    public List getdiscuss(String classname);

    public List getmydiscuss(String username);
}

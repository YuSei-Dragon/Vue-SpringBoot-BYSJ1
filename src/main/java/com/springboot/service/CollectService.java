package com.springboot.service;

import com.springboot.entity.Collect;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.form.Mycollect;
import com.springboot.vo.ResultVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2023-04-02
 */
public interface CollectService extends IService<Collect> {

    public ResultVO iscollect(Mycollect mycollect);

    public List getcollect(String name);
}

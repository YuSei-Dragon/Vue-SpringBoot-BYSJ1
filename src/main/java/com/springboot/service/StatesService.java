package com.springboot.service;

import com.springboot.entity.Discuss;
import com.springboot.entity.States;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.vo.ResultVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2023-04-03
 */
public interface StatesService extends IService<States> {
    public List getmystates(String username);

    public ResultVO ismystates(States states);
}

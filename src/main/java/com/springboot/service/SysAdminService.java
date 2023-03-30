package com.springboot.service;

import com.springboot.entity.SysAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.form.RuleForm;
import com.springboot.vo.ResultVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2023-03-20
 */
public interface SysAdminService extends IService<SysAdmin> {
    public ResultVO login(RuleForm ruleForm);
}

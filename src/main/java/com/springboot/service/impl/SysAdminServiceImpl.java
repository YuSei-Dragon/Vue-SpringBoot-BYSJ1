package com.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.entity.SysAdmin;
import com.springboot.entity.UserAdmin;
import com.springboot.form.RuleForm;
import com.springboot.mapper.SysAdminMapper;
import com.springboot.service.SysAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2023-03-20
 */
@Service
public class SysAdminServiceImpl extends ServiceImpl<SysAdminMapper, SysAdmin> implements SysAdminService {

    @Autowired
    private SysAdminMapper sysAdminMapper;
    @Override
    public ResultVO login(RuleForm ruleForm){
        //1.判断用户是否存在
        QueryWrapper<SysAdmin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sys_name",ruleForm.getUsername());
        SysAdmin sysAdmin = this.sysAdminMapper.selectOne(queryWrapper);

        ResultVO resultVO = new ResultVO();
        if(sysAdmin == null){
            resultVO.setCode(-1);
        }else{
            //2.判断密码是否正确
            if(!sysAdmin.getSysPassword().equals(ruleForm.getPassword())){
                resultVO.setCode(-2);
            }else {
                resultVO.setCode(0);
                resultVO.setData(sysAdmin);
            }
        }
        return resultVO;

    }
}

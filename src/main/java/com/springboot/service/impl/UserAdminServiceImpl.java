package com.springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.entity.UserAdmin;
import com.springboot.form.RuleForm;
import com.springboot.mapper.UserAdminMapper;
import com.springboot.service.UserAdminService;
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
public class UserAdminServiceImpl extends ServiceImpl<UserAdminMapper, UserAdmin> implements UserAdminService {

    @Autowired
    private UserAdminMapper userAdminMapper;

    @Override
    public ResultVO login(RuleForm ruleForm){
        //1.判断用户是否存在
        QueryWrapper<UserAdmin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",ruleForm.getUsername());
        UserAdmin userAdmin = this.userAdminMapper.selectOne(queryWrapper);

        ResultVO resultVO = new ResultVO();
        if(userAdmin == null){
            resultVO.setCode(-1);
        }else{
            //2.判断密码是否正确
            if(!userAdmin.getUserPassword().equals(ruleForm.getPassword())){
                resultVO.setCode(-2);
            }else {
                resultVO.setCode(0);
                resultVO.setData(userAdmin);
            }
        }
        return resultVO;

    }

}

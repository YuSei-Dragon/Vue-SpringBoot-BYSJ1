package com.springboot.util;

import com.springboot.vo.ResultVO;

public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO fail1(){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(-1);
        return resultVO;
    }
    public static ResultVO fail2(){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(-2);
        return resultVO;
    }
}

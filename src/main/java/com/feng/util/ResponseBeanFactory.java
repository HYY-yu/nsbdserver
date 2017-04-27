package com.feng.util;

import com.feng.bean.ResponseBean;

import java.util.List;

/**
 * Created by feng on 2017/4/21.
 */
public class ResponseBeanFactory {

    public static <T> ResponseBean<T> success(ResponseCodeEnum codeEnum,List<T> datas) {
        ResponseBean tempBean = new ResponseBean<>();
        tempBean.setCode(codeEnum.getCode());
        tempBean.setMessage(codeEnum.getMessage());
        tempBean.setDatas(datas);
        return tempBean;
    }

    public static <T> ResponseBean<T> error(ResponseCodeEnum codeEnum){
        ResponseBean<T> tempBean = new ResponseBean<>();
        tempBean.setCode(codeEnum.getCode());
        tempBean.setMessage(codeEnum.getMessage());
        tempBean.setDatas(null);
        return tempBean;
    }
}

package com.feng.handler;

import com.feng.bean.ResponseBean;
import com.feng.util.ResponseBeanFactory;
import com.feng.util.ResponseCodeEnum;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by feng on 2017/4/21.
 */
@ControllerAdvice
public class ExceptionHandler {

    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseBean handleNullParameter() {
        return ResponseBeanFactory.error(ResponseCodeEnum.REQUEST_PARAMETER_NULL);
    }
}

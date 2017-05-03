package com.feng.controller;

import com.feng.bean.ResponseBean;
import com.feng.bean.UserBean;
import com.feng.dao.LoginRepository;
import com.feng.util.ResponseBeanFactory;
import com.feng.util.ResponseCodeEnum;
import org.apache.http.util.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by feng on 2017/4/21.
 */

@RestController
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private LoginRepository loginRepository;

    @RequestMapping(value = "/login")
    public ResponseBean<UserBean> login(@RequestParam("loginName") String username,
                                        @RequestParam("password") String password) {
        logger.info("收到请求 " + username);
        List<UserBean> datas = new ArrayList<UserBean>();

        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            return ResponseBeanFactory.error(ResponseCodeEnum.REQUEST_PARAMETER_ERROR);
        }

        // 查询数据库
        UserBean userBean = loginRepository.findByUsername(username);
        if (userBean == null) {
            return ResponseBeanFactory.error(ResponseCodeEnum.LOGIN_ERROR);
        }
        logger.info("查询到userBean : " + userBean.getDisplayName());

        if (!password.equals(userBean.getPassword())) {
            return ResponseBeanFactory.error(ResponseCodeEnum.LOGIN_ERROR);
        }

        userBean.setPassword(" "); //将密码置空,防止泄露
        datas.add(userBean);
        return ResponseBeanFactory.success(ResponseCodeEnum.SUCCESS, datas);
    }
}

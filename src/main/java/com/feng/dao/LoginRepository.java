package com.feng.dao;

import com.feng.bean.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by feng on 2017/4/21.
 */
public interface LoginRepository extends JpaRepository<UserBean,String>{

    UserBean findByUsername(String username);
}

package com.feng.dao;

import com.feng.bean.FSKBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by feng on 2017/5/3.
 */
public interface FSKRepository extends JpaRepository<FSKBean,Long> {
    List<FSKBean> findAllByJctimeEquals(Date time);

}

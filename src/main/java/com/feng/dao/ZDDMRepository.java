package com.feng.dao;

import com.feng.bean.ZDDM_StatisticsBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by feng on 2017/4/27.
 */
public interface ZDDMRepository extends JpaRepository<ZDDM_StatisticsBean,Integer> {
    List<ZDDM_StatisticsBean> findAllByDridEquals(String drString);
}

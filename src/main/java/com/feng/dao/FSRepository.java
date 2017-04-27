package com.feng.dao;

import com.feng.bean.FS_StatisticsBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by feng on 2017/4/27.
 */
public interface FSRepository extends JpaRepository<FS_StatisticsBean,String> {
    List<FS_StatisticsBean> findAllByDridEquals(String drString);
}

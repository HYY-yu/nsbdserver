package com.feng.dao;

import com.feng.bean.SluiceBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by feng on 2017/4/21.
 */
public interface SluiceRepository extends JpaRepository<SluiceBean, Integer> {

    List<SluiceBean> findAllByTimeEquals(Date time);

    List<SluiceBean> findAllBySluiceIDEqualsAndTimeBetween(int sluiceID, Date startTime, Date endTime);

}

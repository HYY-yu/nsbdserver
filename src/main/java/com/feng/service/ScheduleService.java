package com.feng.service;

import com.feng.bean.*;
import com.feng.dao.*;
import com.feng.util.DateUtil;
import com.feng.util.PageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by feng on 2017/4/21.
 */
@Service
public class ScheduleService {

    private final SluiceRepository sluiceRepository;

    private final LocalRepositoryImpl procedureRepository;

    private final FSRepository fsRepository;

    private final ZDDMRepository zddmRepository;

    @Autowired
    public ScheduleService(SluiceRepository sluiceRepository, LocalRepositoryImpl procedureRepository, FSRepository fsRepository, ZDDMRepository zddmRepository) {
        this.sluiceRepository = sluiceRepository;
        this.procedureRepository = procedureRepository;
        this.fsRepository = fsRepository;
        this.zddmRepository = zddmRepository;
    }

    public List<SluiceBean> overviewAllStationByTime(String time) throws ParseException {
        Date date = DateUtil.parse(time);
        List<SluiceBean> sluiceBeanList = sluiceRepository.findAllByTimeEquals(date);

        return sluiceBeanList;
    }

    public List<SluiceBean> queryOneStationByTimeRange(int sluiceID, String timeStartString, String timeEndString) throws ParseException {
        Date startTime = DateUtil.parse(timeStartString);
        Date endTime = DateUtil.parse(timeEndString);

        List<SluiceBean> sluiceBeanList = sluiceRepository
                .findAllBySluiceIDEqualsAndTimeBetween(sluiceID, startTime, endTime);

        return sluiceBeanList;
    }

    public List<AllLineSchedulingAnalysisBean> allLineSchedulingAnalysis(String timeString, int currentPage, int countPage) throws ParseException {
        Date time = DateUtil.parse(timeString);
        List<AllLineSchedulingAnalysisBean> analysisBeanList = procedureRepository.allLineSchedulingAnalysis(time, String.valueOf(1));

        for (AllLineSchedulingAnalysisBean bean :
                analysisBeanList) {
            bean.queryDate = time;
        }

        //在此处理分页逻辑：  countPage小于等于0 不分页
        if(currentPage <= 0){
            return analysisBeanList;
        }
        return PageManager.page(analysisBeanList, currentPage, countPage);
    }

    public List<AllLineWaterDepthBean> allLineWaterDepth(String datetimeString, int currentPage, int countPage) throws ParseException {

        Date time = DateUtil.parse(datetimeString);
        List<AllLineWaterDepthBean> analysisBeanList = procedureRepository.allLineWaterDepth(time, String.valueOf(1));

        for (AllLineWaterDepthBean bean :
                analysisBeanList) {
            bean.queryDate = time;
        }

        //在此处理分页逻辑：  countPage小于等于0 不分页
        if(currentPage <= 0){
            return analysisBeanList;
        }
        return PageManager.page(analysisBeanList, currentPage, countPage);

    }

    public List<AllLineFlowSpeedBean> allLineFLowSpeed(String datetimeString, int currentPage, int countPage) throws ParseException {
        Date time = DateUtil.parse(datetimeString);
        List<AllLineFlowSpeedBean> analysisBeanList = procedureRepository.allLineFLowSpeed(time, String.valueOf(1));

        for (AllLineFlowSpeedBean bean :
                analysisBeanList) {
            bean.queryDate = time;
        }

        //在此处理分页逻辑：  countPage小于等于0 不分页
        if(currentPage <= 0){
            return analysisBeanList;
        }
        return PageManager.page(analysisBeanList, currentPage, countPage);

    }

    public List<Hour24SluiceBean> hour24SluiceBeanList(String datetimeString, int jctid) throws ParseException {
        Date time = DateUtil.parse(datetimeString);

        List<Hour24SluiceBean> hour24SluiceBeanList = procedureRepository.hour24SluiceBeanList(time,jctid);

        //有可能列表中的24条数据均为空
        int nullNum = 0;
        for (Hour24SluiceBean bean :
                hour24SluiceBeanList) {
            if (bean == null) {
                nullNum ++;
            }
        }

        if (nullNum == 24) {
            return Collections.emptyList();
        }
        return hour24SluiceBeanList;
    }

    public List<FS_StatisticsBean> queryFSByTime(String timeS) {
        List<FS_StatisticsBean> fs_statisticsBeans =  fsRepository.findAllByDridEquals(timeS);
        return fs_statisticsBeans;
    }

    public List<ZDDM_StatisticsBean> quertZDDMBy(String time) {
        List<ZDDM_StatisticsBean> zddm_statisticsBeans =  zddmRepository.findAllByDridEquals(time);
        return zddm_statisticsBeans;
    }
}

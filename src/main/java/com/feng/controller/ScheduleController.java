package com.feng.controller;

import com.feng.bean.*;
import com.feng.service.ScheduleService;
import com.feng.util.ResponseBeanFactory;
import com.feng.util.ResponseCodeEnum;
import org.apache.http.util.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by feng on 2017/4/21.
 */
@RestController
@RequestMapping(value = "/schedule")
public class ScheduleController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @RequestMapping(value = "/overviewAllStationByTime")
    public ResponseBean<SluiceBean> overviewAllStationByTime(@RequestParam("time") String time) {
        logger.info("访问 -- " + time);

        if (TextUtils.isEmpty(time)) {
            return ResponseBeanFactory.error(ResponseCodeEnum.REQUEST_PARAMETER_ERROR);
        }

        List<SluiceBean> sluiceBeanList;
        try {
            sluiceBeanList = scheduleService.overviewAllStationByTime(time);
        } catch (ParseException e) {
            return ResponseBeanFactory.error(ResponseCodeEnum.TIME_FORMAT_ERROR);
        }
        return ResponseBeanFactory.success(ResponseCodeEnum.SUCCESS, sluiceBeanList);
    }

    @RequestMapping(value = "/queryOneStationByTimeRange")
    public ResponseBean<SluiceBean> queryOneStationByTimeRange(@RequestParam("sluiceID") int sluiceID,
                                                               @RequestParam("timeStartString") String timeStartString,
                                                               @RequestParam("timeEndString") String timeEndString) {
        logger.info("访问 -- id : " + sluiceID + "timeRange : " + timeStartString + " -- " + timeEndString);
        if (TextUtils.isEmpty(timeStartString) || TextUtils.isEmpty(timeEndString)) {
            return ResponseBeanFactory.error(ResponseCodeEnum.REQUEST_PARAMETER_ERROR);
        }

        List<SluiceBean> sluiceBeanList;
        try {
            sluiceBeanList = scheduleService.queryOneStationByTimeRange(sluiceID, timeStartString, timeEndString);
        } catch (ParseException e) {
            return ResponseBeanFactory.error(ResponseCodeEnum.TIME_FORMAT_ERROR);
        }
        return ResponseBeanFactory.success(ResponseCodeEnum.SUCCESS, sluiceBeanList);

    }

    @RequestMapping("/allScheduleAnalysis")
    public ResponseBean<AllLineSchedulingAnalysisBean> allScheduleAnalysis(
            @RequestParam("datetime") String datetimeString, @RequestParam("currentPage") int currentPage,
            @RequestParam("countPage") int countPage) {
        logger.info("访问 -- 全线调度辅助分析 : " + datetimeString + "PageRange : " + currentPage + " -- " + countPage);
        if (TextUtils.isEmpty(datetimeString)) {
            return ResponseBeanFactory.error(ResponseCodeEnum.REQUEST_PARAMETER_ERROR);
        }

        try {
            List<AllLineSchedulingAnalysisBean> schedulingAnalysisBeans;

            schedulingAnalysisBeans = scheduleService.allLineSchedulingAnalysis(datetimeString, currentPage, countPage);
            return ResponseBeanFactory.success(ResponseCodeEnum.SUCCESS, schedulingAnalysisBeans);

        } catch (ParseException e) {
            return ResponseBeanFactory.error(ResponseCodeEnum.TIME_FORMAT_ERROR);
        }
    }

    @RequestMapping("/allLineWaterDepth")
    public ResponseBean<AllLineWaterDepthBean> allLineWaterDepth(@RequestParam("datetime") String datetimeString, @RequestParam("currentPage") int currentPage,
                                                                 @RequestParam("countPage") int countPage) {
        logger.info("访问 -- 全线水深统计 : " + datetimeString + "PageRange : " + currentPage + " -- " + countPage);
        if (TextUtils.isEmpty(datetimeString)) {
            return ResponseBeanFactory.error(ResponseCodeEnum.REQUEST_PARAMETER_ERROR);
        }
        try {
            List<AllLineWaterDepthBean> waterDepthBeans;

            waterDepthBeans = scheduleService.allLineWaterDepth(datetimeString, currentPage, countPage);
            return ResponseBeanFactory.success(ResponseCodeEnum.SUCCESS, waterDepthBeans);

        } catch (ParseException e) {
            return ResponseBeanFactory.error(ResponseCodeEnum.TIME_FORMAT_ERROR);
        }
    }

    @RequestMapping("/allLineFLowSpeed")
    public ResponseBean<AllLineFlowSpeedBean> allLineFLowSpeed(@RequestParam("datetime") String datetimeString, @RequestParam("currentPage") int currentPage,
                                                               @RequestParam("countPage") int countPage) {
        logger.info("访问 -- 全线流速统计 : " + datetimeString + "PageRange : " + currentPage + " -- " + countPage);
        if (TextUtils.isEmpty(datetimeString)) {
            return ResponseBeanFactory.error(ResponseCodeEnum.REQUEST_PARAMETER_ERROR);
        }
        try {
            List<AllLineFlowSpeedBean> flowSpeedBeans;

            flowSpeedBeans = scheduleService.allLineFLowSpeed(datetimeString, currentPage, countPage);
            return ResponseBeanFactory.success(ResponseCodeEnum.SUCCESS, flowSpeedBeans);

        } catch (ParseException e) {
            return ResponseBeanFactory.error(ResponseCodeEnum.TIME_FORMAT_ERROR);
        }
    }


    @RequestMapping("/jzzFrontWLTrend")
    public ResponseBean jzzFrontWLTrend(@RequestParam("jctid") int jctid, @RequestParam("time") String time) {
        //24小时闸前水位趋势
        logger.info("访问 -- 24小时闸前水位趋势 : jctid:" + jctid + " time: " + time);
        if (TextUtils.isEmpty(time)) {
            return ResponseBeanFactory.error(ResponseCodeEnum.REQUEST_PARAMETER_ERROR);
        }
        try {
            List<Hour24SluiceBean> hour24SluiceBeanList = scheduleService.hour24SluiceBeanList(time, jctid);
            return ResponseBeanFactory.success(ResponseCodeEnum.SUCCESS, hour24SluiceBeanList);
        } catch (ParseException e) {
            return ResponseBeanFactory.error(ResponseCodeEnum.TIME_FORMAT_ERROR);
        }
    }

    @RequestMapping("/fsStatistics")
    public ResponseBean<FS_StatisticsBean> fsStatistics(@RequestParam("time") String time) {
        //时间格式必须为 : yyyy/MM/dd

        logger.info("访问 -- 分水统计 : +  time: " + time);
        if (TextUtils.isEmpty(time)) {
            return ResponseBeanFactory.error(ResponseCodeEnum.REQUEST_PARAMETER_ERROR);
        }
        try {
            String timenew = changeTimeType(time);
            List<FS_StatisticsBean> fs_statisticsBeans = scheduleService.queryFSByTime(timenew);
            return ResponseBeanFactory.success(ResponseCodeEnum.SUCCESS, fs_statisticsBeans);
        } catch (ParseException e) {
            return ResponseBeanFactory.error(ResponseCodeEnum.REQUEST_PARAMETER_ERROR);
        }
    }

    private String changeTimeType(String time) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = dateFormat.parse(time);
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyyMMdd");

        return dateFormat1.format(date);
    }

    @RequestMapping("/zddmStatistics")
    public ResponseBean<ZDDM_StatisticsBean> zddmStatistics(@RequestParam("time") String time) {
        //时间格式必须为 : yyyy/MM/dd

        logger.info("访问 -- 重点断面统计 : +  time: " + time);
        if (TextUtils.isEmpty(time)) {
            return ResponseBeanFactory.error(ResponseCodeEnum.REQUEST_PARAMETER_ERROR);
        }
        try {
            String timenew = changeTimeType(time);
            List<ZDDM_StatisticsBean> zddmStatisticsBeans = scheduleService.quertZDDMBy(timenew);
            return ResponseBeanFactory.success(ResponseCodeEnum.SUCCESS, zddmStatisticsBeans);
        } catch (ParseException e) {
            return ResponseBeanFactory.error(ResponseCodeEnum.REQUEST_PARAMETER_ERROR);
        }
    }
}
















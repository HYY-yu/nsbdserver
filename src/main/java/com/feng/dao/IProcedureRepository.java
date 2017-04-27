package com.feng.dao;

import com.feng.bean.AllLineSchedulingAnalysisBean;

import java.util.Date;
import java.util.List;

/**
 * Created by feng on 2017/4/25.
 */
public interface IProcedureRepository {

    List<AllLineSchedulingAnalysisBean> allLineSchedulingAnalysis(Date tm, String officeid);
}

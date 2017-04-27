package com.feng.dao;

import com.feng.bean.*;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by feng on 2017/4/25.
 */

@Repository
public class LocalRepositoryImpl implements IProcedureRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<AllLineSchedulingAnalysisBean> allLineSchedulingAnalysis(Date tm, String officeid) {

        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("Pro_AllLineSchedulingAnalysisNew", AllLineSchedulingAnalysisBean.class);

        storedProcedureQuery.registerStoredProcedureParameter(1, Date.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        storedProcedureQuery.setParameter(1, tm);
        storedProcedureQuery.setParameter(2, officeid);

        return (List<AllLineSchedulingAnalysisBean>) storedProcedureQuery.getResultList();
    }

    public List<AllLineWaterDepthBean> allLineWaterDepth(Date time, String officeid) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("Pro_AllLineWaterDepthStatisticsNew", AllLineWaterDepthBean.class);

        storedProcedureQuery.registerStoredProcedureParameter(1, Date.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        storedProcedureQuery.setParameter(1, time);
        storedProcedureQuery.setParameter(2, officeid);

        return (List<AllLineWaterDepthBean>) storedProcedureQuery.getResultList();
    }

    public List<AllLineFlowSpeedBean> allLineFLowSpeed(Date time, String officeid) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("Pro_AllLineFlowSpeedStatisticsNew", AllLineFlowSpeedBean.class);

        storedProcedureQuery.registerStoredProcedureParameter(1, Date.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        storedProcedureQuery.setParameter(1, time);
        storedProcedureQuery.setParameter(2, officeid);

        return (List<AllLineFlowSpeedBean>) storedProcedureQuery.getResultList();
    }

    public List<Hour24SluiceBean> hour24SluiceBeanList(Date time, int jctid) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("Pro_Gen24HourData", Hour24SluiceBean.class);

        storedProcedureQuery.registerStoredProcedureParameter(1, Date.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(2, Integer.class, ParameterMode.IN);
        storedProcedureQuery.setParameter(1, time);
        storedProcedureQuery.setParameter(2, jctid);

        return (List<Hour24SluiceBean>) storedProcedureQuery.getResultList();

    }
}

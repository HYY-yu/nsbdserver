package com.feng.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by feng on 2017/4/27.
 */
@Entity
@Table(name = "O_WATERDISPATCH_DR")
public class ZDDM_StatisticsBean {

    private String drid;
    @Id
    private int jctid;
    private Float flow;
    private Float curflow;
    private Float totalflow;

    public String getDrid() {
        return drid;
    }

    public void setDrid(String drid) {
        this.drid = drid;
    }

    public int getJctid() {
        return jctid;
    }

    public void setJctid(int jctid) {
        this.jctid = jctid;
    }

    public Float getFlow() {
        return flow;
    }

    public void setFlow(Float flow) {
        this.flow = flow;
    }

    public Float getCurflow() {
        return curflow;
    }

    public void setCurflow(Float curflow) {
        this.curflow = curflow;
    }

    public Float getTotalflow() {
        return totalflow;
    }

    public void setTotalflow(Float totalflow) {
        this.totalflow = totalflow;
    }
}

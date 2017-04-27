package com.feng.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by feng on 2017/4/27.
 */
@Entity
@Table(name = "O_PROJECTRUN_DR")
public class FS_StatisticsBean {

    private String drid;
    @Id
    private String fsknm;
    private Float flow;
    private Float curflow;
    private Float totalflow;

    public String getDrid() {
        return drid;
    }

    public void setDrid(String drid) {
        this.drid = drid;
    }

    public String getFsknm() {
        return fsknm;
    }

    public void setFsknm(String fsknm) {
        this.fsknm = fsknm;
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

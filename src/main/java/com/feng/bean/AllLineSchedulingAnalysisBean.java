package com.feng.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * 全线调度辅助分析
 * Created by feng on 2017/4/25.
 */

@Entity
public class AllLineSchedulingAnalysisBean {

    /*jctid int,					--节点编号
    jctname varchar(100),		--节制闸名称
    objectstage float,			--目标水位(m)
    designstage float,			--设计水位(m)
    currentstage float,			--当前水位(m)
    toobjectstage float,		--距目标水位(m)
    todesignstage float,		--距设计水位(m)Pro_AllLineSchedulingAnalysisNew
    rose2 float,				--2h涨幅(m)
    rose24 float,				--24h涨幅(m)
    trend24 float				--24h涨幅(m)*/

    @Id
    private int jctid;
    private String jctname;
    private Float objectstage;
    private Float designstage;
    private Float currentstage;
    private Float toobjectstage;
    private Float todesignstage;
    private Float rose2;
    private Float rose24;
    private Float trend24;

    @Transient
    public Date queryDate;

    public int getJctid() {
        return jctid;
    }

    public void setJctid(int jctid) {
        this.jctid = jctid;
    }

    public String getJctname() {
        return jctname;
    }

    public void setJctname(String jctname) {
        this.jctname = jctname;
    }

    public Float getObjectstage() {
        return objectstage;
    }

    public void setObjectstage(Float objectstage) {
        this.objectstage = objectstage;
    }

    public Float getDesignstage() {
        return designstage;
    }

    public void setDesignstage(Float designstage) {
        this.designstage = designstage;
    }

    public Float getCurrentstage() {
        return currentstage;
    }

    public void setCurrentstage(Float currentstage) {
        this.currentstage = currentstage;
    }

    public Float getToobjectstage() {
        return toobjectstage;
    }

    public void setToobjectstage(Float toobjectstage) {
        this.toobjectstage = toobjectstage;
    }

    public Float getTodesignstage() {
        return todesignstage;
    }

    public void setTodesignstage(Float todesignstage) {
        this.todesignstage = todesignstage;
    }

    public Float getRose2() {
        return rose2;
    }

    public void setRose2(Float rose2) {
        this.rose2 = rose2;
    }

    public Float getRose24() {
        return rose24;
    }

    public void setRose24(float rose24) {
        this.rose24 = rose24;
    }

    public Float getTrend24() {
        return trend24;
    }

    public void setTrend24(Float trend24) {
        this.trend24 = trend24;
    }

    @Override
    public String toString() {
        return "AllLineSchedulingAnalysisBean{" +
                "jctid=" + jctid +
                ", jctname='" + jctname + '\'' +
                ", objectstage=" + objectstage +
                ", designstage=" + designstage +
                ", currentstage=" + currentstage +
                ", toobjectstage=" + toobjectstage +
                ", todesignstage=" + todesignstage +
                ", rose2=" + rose2 +
                ", rose24=" + rose24 +
                ", trend24=" + trend24 +
                '}';
    }
}

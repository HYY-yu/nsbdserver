package com.feng.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by feng on 2017/5/2.
 */
@Entity
@Table(name = "R_FSKSSSJ")
public class FSKBean {
    @Id
    long fsksssjid;

    long jctid;
    Float hole1kd;
    Float instantflow1;
    Float totalflow;

    Date jctime;

    public long getFsksssjid() {
        return fsksssjid;
    }

    public void setFsksssjid(long fsksssjid) {
        this.fsksssjid = fsksssjid;
    }

    public long getJctid() {
        return jctid;
    }

    public void setJctid(long jctid) {
        this.jctid = jctid;
    }

    public Float getHole1kd() {
        return hole1kd;
    }

    public void setHole1kd(Float hole1kd) {
        this.hole1kd = hole1kd;
    }

    public Float getInstantflow1() {
        return instantflow1;
    }

    public void setInstantflow1(Float instantflow1) {
        this.instantflow1 = instantflow1;
    }

    public Float getTotalflow() {
        return totalflow;
    }

    public void setTotalflow(Float totalflow) {
        this.totalflow = totalflow;
    }

    public Date getJctime() {
        return jctime;
    }

    public void setJctime(Date jctime) {
        this.jctime = jctime;
    }
}

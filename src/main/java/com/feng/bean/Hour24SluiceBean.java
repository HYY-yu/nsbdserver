package com.feng.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by feng on 2017/4/26.
 */
@Entity
public class Hour24SluiceBean {

    private int jctid;
    private Float frontwl;
    @Id
    private Date jctime;

    public int getJctid() {
        return jctid;
    }

    public void setJctid(int jctid) {
        this.jctid = jctid;
    }

    public Float getFrontwl() {
        return frontwl;
    }

    public void setFrontwl(Float frontwl) {
        this.frontwl = frontwl;
    }

    public Date getJctime() {
        return jctime;
    }

    public void setJctime(Date jctime) {
        this.jctime = jctime;
    }
}

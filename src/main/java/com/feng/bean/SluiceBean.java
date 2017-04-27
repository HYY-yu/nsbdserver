package com.feng.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by feng on 2017/4/21.
 */
@Entity
@Table(name = "R_JZZSSSJ")
public class SluiceBean {

    @Id
    @GeneratedValue
    private Integer jzzsssjid;

    @Column(name = "jctid")
    private Integer sluiceID;         //闸编号
    @Column(name = "hole1leftkd")
    private Float sluiceOpening1;   //闸门开度
    @Column(name = "hole2leftkd")
    private Float sluiceOpening2;   //闸门开度
    @Column(name = "hole3leftkd")
    private Float sluiceOpening3;   //闸门开度
    @Column(name = "hole4leftkd")
    private Float sluiceOpening4;   //闸门开度
    @Column(name = "frontwl")
    private Float waterLevel_front; //闸前水位
    @Column(name = "backwl")
    private Float waterLevel_back;  //闸后水位
    @Column(name = "jctime")
    private Date time;   // 时间

    public Integer getSluiceID() {
        return sluiceID;
    }

    public void setSluiceID(Integer sluiceID) {
        this.sluiceID = sluiceID;
    }

    public Float getSluiceOpening1() {
        return sluiceOpening1;
    }

    public void setSluiceOpening1(Float sluiceOpening1) {
        this.sluiceOpening1 = sluiceOpening1;
    }

    public Float getSluiceOpening2() {
        return sluiceOpening2;
    }

    public void setSluiceOpening2(Float sluiceOpening2) {
        this.sluiceOpening2 = sluiceOpening2;
    }

    public Float getSluiceOpening3() {
        return sluiceOpening3;
    }

    public void setSluiceOpening3(Float sluiceOpening3) {
        this.sluiceOpening3 = sluiceOpening3;
    }

    public Float getSluiceOpening4() {
        return sluiceOpening4;
    }

    public void setSluiceOpening4(Float sluiceOpening4) {
        this.sluiceOpening4 = sluiceOpening4;
    }

    public Float getWaterLevel_front() {
        return waterLevel_front;
    }

    public void setWaterLevel_front(Float waterLevel_front) {
        this.waterLevel_front = waterLevel_front;
    }

    public Float getWaterLevel_back() {
        return waterLevel_back;
    }

    public void setWaterLevel_back(Float waterLevel_back) {
        this.waterLevel_back = waterLevel_back;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}

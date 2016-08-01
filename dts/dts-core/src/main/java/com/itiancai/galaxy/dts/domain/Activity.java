package com.itiancai.galaxy.dts.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lsp on 16/7/28.
 */
@Entity
@Table(name = "dts_activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * 主事务id
     */
    @Column(name = "tx_id", nullable = false)
    private Long txId;

    /**
     * 业务为号
     */
    @Column(name = "business_id", nullable = false)
    private String businessId;

    /**
     * 主事务状态(UNKNOWN,SUCCESS,FAIL)
     */
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status", nullable = false)
    private Status.Activity status;

    /**
     * 服务名称
     */
    @Column(name = "business_type", nullable = false)
    private String businessType;

    /**
     * 事务完成标识 0-未完成,1-完成
     */
    @Column(name = "finish", nullable = false)
    private int finish;

    /**
     * 数据创建时间
     */
    @Column(name = "c_time", nullable = false)
    private Date cTime;

    /**
     * 数据修改时间
     */
    @Column(name = "m_time", nullable = false)
    private Date mTime;

    /**
     * 请求参数
     */
    @Column(name = "time_out", nullable = false)
    private Long timeOut;

    public Activity(){}

    public Activity(Long txId, Status.Activity status, String businessType, Date cTime,Long timeOut,
                    Date mTime,Integer finish, String businessId){
        this.txId = txId;
        this.status = status;
        this.businessType = businessType;
        this.cTime = cTime;
        this.mTime = mTime;
        this.finish = finish;
        this.businessId = businessId;
        this.timeOut = timeOut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTxId() {
        return txId;
    }

    public void setTxId(Long txId) {
        this.txId = txId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public Status.Activity getStatus() {
        return status;
    }

    public void setStatus(Status.Activity status) {
        this.status = status;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public int getFinish() {
        return finish;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }

    public Date getmTime() {
        return mTime;
    }

    public void setmTime(Date mTime) {
        this.mTime = mTime;
    }

    public Long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Long timeOut) {
        this.timeOut = timeOut;
    }
}
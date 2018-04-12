package com.fullexception.entity;

import java.util.Date;

public class WebStatistics {
    private Integer webStatisticsId;

    private Integer userId;

    private String ip;

    private Date loginDate;

    public Integer getWebStatisticsId() {
        return webStatisticsId;
    }

    public void setWebStatisticsId(Integer webStatisticsId) {
        this.webStatisticsId = webStatisticsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
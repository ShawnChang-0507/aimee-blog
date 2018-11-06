package com.fullexception.entity;

import java.util.Date;

public class Info {
    private Integer infoId;

    private Integer visitorId;

    private Integer addressId;

    private String realName;

    private Integer sex;

    private Date birthday;

    private String email;

    private String qq;

    private String wecharPay;

    private String wecharFriend;

    private String aliPay;

    private String aliFriend;

    private String telphone;

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Integer visitorId) {
        this.visitorId = visitorId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWecharPay() {
        return wecharPay;
    }

    public void setWecharPay(String wecharPay) {
        this.wecharPay = wecharPay == null ? null : wecharPay.trim();
    }

    public String getWecharFriend() {
        return wecharFriend;
    }

    public void setWecharFriend(String wecharFriend) {
        this.wecharFriend = wecharFriend == null ? null : wecharFriend.trim();
    }

    public String getAliPay() {
        return aliPay;
    }

    public void setAliPay(String aliPay) {
        this.aliPay = aliPay == null ? null : aliPay.trim();
    }

    public String getAliFriend() {
        return aliFriend;
    }

    public void setAliFriend(String aliFriend) {
        this.aliFriend = aliFriend == null ? null : aliFriend.trim();
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }
}
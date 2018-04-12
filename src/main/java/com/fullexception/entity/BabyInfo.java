package com.fullexception.entity;

import java.util.Date;

public class BabyInfo {
    private Integer babyInfoId;

    private Integer parentId;

    private Integer starId;

    private String babyNickName;

    private Integer babySex;

    private Date babyBirthday;

    private String babyIntroduction;

    public Integer getBabyInfoId() {
        return babyInfoId;
    }

    public void setBabyInfoId(Integer babyInfoId) {
        this.babyInfoId = babyInfoId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getStarId() {
        return starId;
    }

    public void setStarId(Integer starId) {
        this.starId = starId;
    }

    public String getBabyNickName() {
        return babyNickName;
    }

    public void setBabyNickName(String babyNickName) {
        this.babyNickName = babyNickName == null ? null : babyNickName.trim();
    }

    public Integer getBabySex() {
        return babySex;
    }

    public void setBabySex(Integer babySex) {
        this.babySex = babySex;
    }

    public Date getBabyBirthday() {
        return babyBirthday;
    }

    public void setBabyBirthday(Date babyBirthday) {
        this.babyBirthday = babyBirthday;
    }

    public String getBabyIntroduction() {
        return babyIntroduction;
    }

    public void setBabyIntroduction(String babyIntroduction) {
        this.babyIntroduction = babyIntroduction == null ? null : babyIntroduction.trim();
    }
}
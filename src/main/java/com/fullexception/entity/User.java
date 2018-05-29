package com.fullexception.entity;

import java.util.Date;
import java.util.List;

public class User {
    private Integer userId;

    private Integer starId;

    private String loginName;

    private String loginPassword;

    private Date createTime;

    private String nickName;

    private Integer userState;

    private String title;

    private String secondTitle;

    private Integer publicOrPrivate;
    
    private List<Info> infos;
    
    private List<BabyInfo> babyInfos;
    
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStarId() {
        return starId;
    }

    public void setStarId(Integer starId) {
        this.starId = starId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSecondTitle() {
        return secondTitle;
    }

    public void setSecondTitle(String secondTitle) {
        this.secondTitle = secondTitle == null ? null : secondTitle.trim();
    }

    public Integer getPublicOrPrivate() {
        return publicOrPrivate;
    }

    public void setPublicOrPrivate(Integer publicOrPrivate) {
        this.publicOrPrivate = publicOrPrivate;
    }

	public List<Info> getInfos() {
		return infos;
	}

	public void setInfos(List<Info> infos) {
		this.infos = infos;
	}

	public List<BabyInfo> getBabyInfos() {
		return babyInfos;
	}

	public void setBabyInfos(List<BabyInfo> babyInfos) {
		this.babyInfos = babyInfos;
	}
}
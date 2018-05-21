package com.fullexception.entity;

import java.util.Date;

public class Article {
    private Integer articleId;

    private Integer hostId;

    private Integer sourceId;

    private Integer articleGroupId;

    private Integer parentArticleId;

    private String articleTitle;

    private Date createDate;

    private String weather;

    private Integer articleState;

    private Integer publicOrPrivate;

    private String articleContent;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getHostId() {
        return hostId;
    }

    public void setHostId(Integer hostId) {
        this.hostId = hostId;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getArticleGroupId() {
        return articleGroupId;
    }

    public void setArticleGroupId(Integer articleGroupId) {
        this.articleGroupId = articleGroupId;
    }

    public Integer getParentArticleId() {
        return parentArticleId;
    }

    public void setParentArticleId(Integer parentArticleId) {
        this.parentArticleId = parentArticleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather == null ? null : weather.trim();
    }

    public Integer getArticleState() {
        return articleState;
    }

    public void setArticleState(Integer articleState) {
        this.articleState = articleState;
    }

    public Integer getPublicOrPrivate() {
        return publicOrPrivate;
    }

    public void setPublicOrPrivate(Integer publicOrPrivate) {
        this.publicOrPrivate = publicOrPrivate;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }
}
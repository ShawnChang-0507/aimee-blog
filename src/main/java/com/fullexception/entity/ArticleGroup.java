package com.fullexception.entity;

import java.util.Date;

public class ArticleGroup {
    private Integer articleGroupId;

    private Integer visitorId;

    private String name;

    private Date createDate;

    public Integer getArticleGroupId() {
        return articleGroupId;
    }

    public void setArticleGroupId(Integer articleGroupId) {
        this.articleGroupId = articleGroupId;
    }

    public Integer getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Integer visitorId) {
        this.visitorId = visitorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

	@Override
	public String toString() {
		return "ArticleGroup [articleGroupId=" + articleGroupId + ", visitorId=" + visitorId + ", name=" + name + "]";
	}
}
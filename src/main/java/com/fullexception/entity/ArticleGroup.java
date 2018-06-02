package com.fullexception.entity;

import java.util.Date;

public class ArticleGroup {
    private Integer articleGroupId;

    private String articleGroupName;
    
    private Date createDate;

    public Integer getArticleGroupId() {
        return articleGroupId;
    }

    public void setArticleGroupId(Integer articleGroupId) {
        this.articleGroupId = articleGroupId;
    }

    public String getArticleGroupName() {
        return articleGroupName;
    }

    public void setArticleGroupName(String articleGroupName) {
        this.articleGroupName = articleGroupName == null ? null : articleGroupName.trim();
    }

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
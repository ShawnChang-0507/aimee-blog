package com.fullexception.entity;

import java.util.Date;

public class ReadLog {
    private Integer readLogId;

    private Integer articleId;

    private Integer visitorId;
    
    private Visitor visitor;

    private Date createDate;
    
    private String readerIp;

    public String getReaderIp() {
		return readerIp;
	}

	public void setReaderIp(String readerIp) {
		this.readerIp = readerIp;
	}

	public Integer getReadLogId() {
        return readLogId;
    }

    public void setReadLogId(Integer readLogId) {
        this.readLogId = readLogId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Integer visitorId) {
        this.visitorId = visitorId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

	public Visitor getVisitor() {
		return visitor;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}
}
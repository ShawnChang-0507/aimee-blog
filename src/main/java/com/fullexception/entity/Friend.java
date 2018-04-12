package com.fullexception.entity;

import java.util.Date;

public class Friend {
    private Integer friendId;

    private Integer hostId;

    private Integer hostFriendId;

    private Integer friendGroupId;

    private Date createDate;

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public Integer getHostId() {
        return hostId;
    }

    public void setHostId(Integer hostId) {
        this.hostId = hostId;
    }

    public Integer getHostFriendId() {
        return hostFriendId;
    }

    public void setHostFriendId(Integer hostFriendId) {
        this.hostFriendId = hostFriendId;
    }

    public Integer getFriendGroupId() {
        return friendGroupId;
    }

    public void setFriendGroupId(Integer friendGroupId) {
        this.friendGroupId = friendGroupId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
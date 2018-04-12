package com.fullexception.entity;

public class FriendGroup {
    private Integer friendGroupId;

    private String friendGroupName;

    public Integer getFriendGroupId() {
        return friendGroupId;
    }

    public void setFriendGroupId(Integer friendGroupId) {
        this.friendGroupId = friendGroupId;
    }

    public String getFriendGroupName() {
        return friendGroupName;
    }

    public void setFriendGroupName(String friendGroupName) {
        this.friendGroupName = friendGroupName == null ? null : friendGroupName.trim();
    }
}
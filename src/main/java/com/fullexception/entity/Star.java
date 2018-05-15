package com.fullexception.entity;

public class Star {
    private Integer starId;

    private String name;

    private String startTime;

    private String endTime;

    private String starFortune;

    private String starCharacter;

    public Integer getStarId() {
        return starId;
    }

    public void setStarId(Integer starId) {
        this.starId = starId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public String getStarFortune() {
        return starFortune;
    }

    public void setStarFortune(String starFortune) {
        this.starFortune = starFortune == null ? null : starFortune.trim();
    }

    public String getStarCharacter() {
        return starCharacter;
    }

    public void setStarCharacter(String starCharacter) {
        this.starCharacter = starCharacter == null ? null : starCharacter.trim();
    }
}
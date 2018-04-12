package com.fullexception.entity;

public class StarWithBLOBs extends Star {
    private String starFortune;

    private String starCharacter;

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
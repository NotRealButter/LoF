package com.notrealbutter.leaguefitness.lof.LeagueCntl;

import com.robrua.orianna.type.dto.matchlist.MatchList;

public class SummonerAccount {

    private String nameCollected;
    private int summonerIDCollected;
    private int summonerLevelCollected;
    public MatchList recentGamesCollected = null;

    public int killCount;
    public int deathCount;
    public int creepScore;
    public int gameDuration;
    public int assistCount;



    public SummonerAccount()
    {
        nameCollected = "none";
        summonerIDCollected = 0;
        summonerLevelCollected = 0;
        recentGamesCollected = new MatchList();

        killCount = 0;
        deathCount = 0;
        assistCount = 0;
        creepScore = 0;
        gameDuration = 0;
    }

    public String getSummonerName() {
        return getNameCollected();
    }

    public int getSummonerIDCollected() {
        return summonerIDCollected;
    }

    public String getNameCollected() {
        return nameCollected;
    }

    public void setNameCollected(String nameCollected) {
        this.nameCollected = nameCollected;
    }

    public void setSummonerIDCollected(int summonerIDCollected) {
        this.summonerIDCollected = summonerIDCollected;
    }

    public MatchList getRecentGamesCollected() {
        return recentGamesCollected;
    }

    public void setRecentGamesCollected(MatchList recentGamesCollected) {
        this.recentGamesCollected = recentGamesCollected;
    }

    public int getSummonerLevelCollected() {
        return summonerLevelCollected;
    }

    public void setSummonerLevelCollected(int summonerLevelCollected) {
        this.summonerLevelCollected = summonerLevelCollected;
    }

    public int getKillCount() {
        return killCount;
    }

    public void setKillCount(int killCount) {
        this.killCount = killCount;
    }

    public int getDeathCount() {
        return deathCount;
    }

    public void setDeathCount(int deathCount) {
        this.deathCount = deathCount;
    }

    public int getAssistCount() {
        return assistCount;
    }

    public void setAssistCount(int assistCount) {
        this.assistCount = assistCount;
    }

    public int getCreepScore() {
        return creepScore;
    }

    public void setCreepScore(int creepScore) {
        this.creepScore = creepScore;
    }

    public int getGameDuration() {
        return gameDuration;
    }

    public void setGameDuration(int gameDuration) {
        this.gameDuration = gameDuration;
    }


}




package com.notrealbutter.leaguefitness.lof.Model;

import android.support.annotation.NonNull;

import com.robrua.orianna.type.core.game.Game;
import com.robrua.orianna.type.dto.matchlist.MatchList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SummonerAccount {

    private String nameCollected;
    private int summonerIDCollected;
    private int summonerLevelCollected;



    public SummonerAccount()
    {
        nameCollected = "none";
        summonerIDCollected = 0;
        summonerLevelCollected = 0;
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

    public int getSummonerLevelCollected() {
        return summonerLevelCollected;
    }

    public void setSummonerLevelCollected(int summonerLevelCollected) {
        this.summonerLevelCollected = summonerLevelCollected;
    }
}
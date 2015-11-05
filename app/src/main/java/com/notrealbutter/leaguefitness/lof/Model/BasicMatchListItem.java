package com.notrealbutter.leaguefitness.lof.Model;

import com.robrua.orianna.type.core.staticdata.Champion;
import com.robrua.orianna.type.core.staticdata.Item;

public class BasicMatchListItem {
    public String champName;
    public String gameType;
    public Champion champion;
    public int kc;
    public int dc;
    public int ac;
    public int cs;
    public int gameDuration;
    public int goldCollected;
    public Item item0;
    public Item item1;
    public Item item2;
    public Item item3;
    public Item item4;
    public Item item5;
    public Item item6;


    public BasicMatchListItem(String champName, String gameType, Champion champion, int kc, int dc, int ac, int cs, int gameDuration, int goldCollected, Item item0, Item item1, Item item2, Item item3, Item item4, Item item5, Item item6) {
        this.champName = champName;
        this.gameType = gameType;
        this.champion = champion;
        this.kc = kc;
        this.dc = dc;
        this.ac = ac;
        this.cs = cs;
        this.gameDuration = gameDuration;
        this.goldCollected = goldCollected;

        this.item0 = item0;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
        this.item5 = item5;
        this.item6 = item6;
    }
}
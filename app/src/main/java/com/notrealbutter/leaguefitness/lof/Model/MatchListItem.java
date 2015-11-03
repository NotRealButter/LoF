package com.notrealbutter.leaguefitness.lof.Model;


public class MatchListItem {
    public String champName;
    public String gameType;
    public String championImageLocation;
    public int kc;
    public int dc;
    public int ac;
    public int cs;
    public int gameDuration;

    public MatchListItem(String champName,  String gameType, String championImageLocation, int kc, int dc, int ac, int cs, int gameDuration) {
        this.champName = champName;
        this.gameType = gameType;
        this.championImageLocation = "http://ddragon.leagueoflegends.com/cdn/5.2.1/img/champion/"+ championImageLocation;
        this.kc = kc;
        this.dc = dc;
        this.ac = ac;
        this.cs = cs;
        this.gameDuration = gameDuration;
    }
}


package com.notrealbutter.leaguefitness.lof.Model;


public class MatchListItem {
    String dataDragonLink =  "http://ddragon.leagueoflegends.com/cdn/5.22.3/img/";
    public String champName;
    public String gameType;
    public String championImageLocation;
    public String item0Location,item1Location,item2Location,item3Location,item4Location,item5Location,item6Location;
    public int kc;
    public int dc;
    public int ac;
    public int cs;
    public int goldEarned;
    public int gameDuration;

    public MatchListItem(String champName,  String gameType, String championImageLocation,
//                         String item0, String item1,String item2, String item3,String item4,String item5, String item6,
 int kc, int dc, int ac, int cs, int goldEarned, int gameDuration) {
        this.champName = champName;
        this.gameType = gameType;
        this.championImageLocation = dataDragonLink+ "champion/"+ championImageLocation;
//        this.item0Location =  dataDragonLink + "item/" + item0;
//        this.item1Location = dataDragonLink + "item/" +item1;
//        this.item2Location = dataDragonLink + "item/" +item2;
//        this.item3Location = dataDragonLink + "item/" +item3;
//        this.item4Location = dataDragonLink + "item/" +item4;
//        this.item5Location = dataDragonLink + "item/" + item5;
//        this.item6Location = dataDragonLink + "item/" +item6;
        this.kc = kc;
        this.dc = dc;
        this.ac = ac;
        this.cs = cs;
        this.goldEarned = goldEarned;
        this.gameDuration = gameDuration;
    }
}


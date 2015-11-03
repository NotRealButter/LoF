package com.notrealbutter.leaguefitness.lof.Control;

import com.notrealbutter.leaguefitness.lof.Model.Match;
import com.notrealbutter.leaguefitness.lof.Model.MatchListItem;
import com.notrealbutter.leaguefitness.lof.Model.SummonerAccount;
import com.robrua.orianna.api.core.AsyncRiotAPI;
import com.robrua.orianna.api.dto.BaseRiotAPI;
import com.robrua.orianna.type.api.Action;
import com.robrua.orianna.type.core.common.Region;
import com.robrua.orianna.type.core.game.Game;
import com.robrua.orianna.type.core.summoner.Summoner;
import com.robrua.orianna.type.exception.APIException;

import java.util.ArrayList;
import java.util.List;

public class RiotController
{
    public SummonerAccount summonerAccount;
    public Match match;
    private ArrayList<MatchListItem> matchListItems = new ArrayList<>();

    public RiotController(){
        summonerAccount = new SummonerAccount();
        match = new Match();
    }

    public void apiInit(){
        AsyncRiotAPI.setMirror(Region.NA);
        AsyncRiotAPI.setRegion(Region.NA);
        AsyncRiotAPI.setAPIKey("f206b7e6-8f2c-4a64-a1bd-79e26953b808");
        BaseRiotAPI.setMirror(Region.NA);
        BaseRiotAPI.setRegion(Region.NA);
        BaseRiotAPI.setAPIKey("f206b7e6-8f2c-4a64-a1bd-79e26953b808");
    }

    public void leagueInit(String name) {
        AsyncRiotAPI.getSummonerByName(new Action<Summoner>() {
            @Override
            public void perform(final Summoner summoner) {
                summonerAccount.setNameCollected(summoner.getName());
                summonerAccount.setSummonerIDCollected((int) summoner.getID());
                summonerAccount.setSummonerLevelCollected((int) summoner.getLevel());
            }

            public void handle(APIException e) {
                System.out.println("Couldn't get summoner");
            }
        }, name);
        AsyncRiotAPI.getRecentGames(new Action<List<Game>>() {
            @Override
            public void handle(APIException exception) {
                System.out.println("Could not load Summoner Games");
            }

            @Override
            public void perform(List<Game> responseData) {
                match.setRecentGamesCollected(responseData);
            }
        }, summonerAccount.getSummonerName());
    }

    public void initMatchList() {
        for (int i = 0; i < match.getRecentGamesCollected().size(); i++) {

            getMatchListItems().add(
                    new MatchListItem(
                            match.getRecentGamesCollected().get(i).getChampion().getName(),
                            match.getRecentGamesCollected().get(i).getMap().toString(),
                            match.getRecentGamesCollected().get(i).getChampion().getImage().getFull(),
                            match.getRecentGamesCollected().get(i).getStats().getKills(),
                            match.getRecentGamesCollected().get(i).getStats().getDeaths(),
                            match.getRecentGamesCollected().get(i).getStats().getAssists(),
                            match.getRecentGamesCollected().get(i).getStats().getMinionsKilled(),
                            ((int) match.getRecentGamesCollected().get(i).getStats().getTimePlayed())));
        }
    }

    public void setSummonerAccount(SummonerAccount acct){
        summonerAccount = acct;
    }

    public ArrayList<MatchListItem> getMatchListItems() {
        return matchListItems;
    }

    public void setMatchListItems(ArrayList<MatchListItem> matchListItems) {
        this.matchListItems = matchListItems;
    }



}
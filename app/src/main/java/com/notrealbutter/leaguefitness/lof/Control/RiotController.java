package com.notrealbutter.leaguefitness.lof.Control;

import com.notrealbutter.leaguefitness.lof.Model.Match;
import com.notrealbutter.leaguefitness.lof.Model.SummonerAccount;
import com.robrua.orianna.api.core.AsyncRiotAPI;
import com.robrua.orianna.api.dto.BaseRiotAPI;
import com.robrua.orianna.type.api.Action;
import com.robrua.orianna.type.core.common.Region;
import com.robrua.orianna.type.core.game.Game;
import com.robrua.orianna.type.core.summoner.Summoner;
import com.robrua.orianna.type.exception.APIException;

import java.util.List;
import java.util.ListIterator;

public class RiotController
{
    public SummonerAccount summonerAccount;
    public Match match;
    public ListIterator matchIterator;

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
                matchIterator = match.getRecentGamesCollected().listIterator();

                while(matchIterator.hasNext()) {
                   System.out.println(matchIterator.next());
//                    System.out.println(match.getRecentGamesCollected().get(matchIterator.previousIndex()).getID());
                }
            }
        },summonerAccount.getSummonerName());

    }

    public void setSummonerAccount(SummonerAccount acct){
        summonerAccount = acct;
    }
}
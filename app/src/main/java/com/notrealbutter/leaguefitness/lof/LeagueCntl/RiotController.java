package com.notrealbutter.leaguefitness.lof.LeagueCntl;

import com.robrua.orianna.api.core.AsyncRiotAPI;
import com.robrua.orianna.api.dto.BaseRiotAPI;
import com.robrua.orianna.type.api.Action;
import com.robrua.orianna.type.core.common.Region;
import com.robrua.orianna.type.core.summoner.Summoner;
import com.robrua.orianna.type.exception.APIException;

public class RiotController
{
    public SummonerAccount summonerAccount;

    public RiotController(){
        summonerAccount = new SummonerAccount();
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
    }


    public void setSummonerAccount(SummonerAccount acct){
        summonerAccount = acct;
    }
}

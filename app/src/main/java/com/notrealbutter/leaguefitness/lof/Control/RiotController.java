package com.notrealbutter.leaguefitness.lof.Control;

import com.notrealbutter.leaguefitness.lof.Model.BasicMatchListItem;
import com.notrealbutter.leaguefitness.lof.Model.Match;
import com.notrealbutter.leaguefitness.lof.Model.SummonerAccount;
import com.robrua.orianna.api.core.AsyncRiotAPI;
import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.api.dto.BaseRiotAPI;
import com.robrua.orianna.type.api.Action;
import com.robrua.orianna.type.core.common.Region;
import com.robrua.orianna.type.core.game.Game;
import com.robrua.orianna.type.core.staticdata.Item;
import com.robrua.orianna.type.core.summoner.Summoner;
import com.robrua.orianna.type.exception.APIException;
import com.robrua.orianna.type.exception.MissingDataException;

import java.util.ArrayList;
import java.util.List;

public class RiotController
{
    public SummonerAccount summonerAccount;
    public Match match;
    private ArrayList<BasicMatchListItem> basicMatchListItems = new ArrayList<>();
    Item placeholderItem;



    public RiotController(){
        summonerAccount = new SummonerAccount();
        match = new Match();
    }

    public void apiInit(){
        AsyncRiotAPI.setMirror(Region.NA);
        AsyncRiotAPI.setRegion(Region.NA);
        AsyncRiotAPI.setAPIKey("f206b7e6-8f2c-4a64-a1bd-79e26953b808");
        RiotAPI.setMirror(Region.NA);
        RiotAPI.setRegion(Region.NA);
        RiotAPI.setAPIKey("f206b7e6-8f2c-4a64-a1bd-79e26953b808");
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
            System.out.println("GETTING INFO HERE "+i );
            getBasicMatchListItems().add(
                    new BasicMatchListItem(
                            match.getRecentGamesCollected().get(i).getChampion().getName(),
                            match.getRecentGamesCollected().get(i).getMap().toString(),
                            match.getRecentGamesCollected().get(i).getChampion(),
                            match.getRecentGamesCollected().get(i).getStats().getKills(),
                            match.getRecentGamesCollected().get(i).getStats().getDeaths(),
                            match.getRecentGamesCollected().get(i).getStats().getAssists(),
                            match.getRecentGamesCollected().get(i).getStats().getMinionsKilled(),
                            ((int) match.getRecentGamesCollected().get(i).getStats().getTimePlayed()),
                            match.getRecentGamesCollected().get(i).getStats().getGoldEarned(),
                            getItem(i,0),
                            getItem(i,1),
                            getItem(i,2),
                            getItem(i,3),
                            getItem(i,4),
                            getItem(i,5),
                            getItem(i,6)
            ));
        }
    }

    public Item getItem(int i, int itemNumber ) {
        if (itemNumber == 0) {
            try {
                Item item = match.getRecentGamesCollected().get(i).getStats().getItem0();
                return item;
            } catch (MissingDataException e) {
                AsyncRiotAPI.getItem(new Action<Item>() {
                    @Override
                    public void handle(APIException exception) {
                        System.out.println("failed");
                    }

                    @Override
                    public void perform(Item responseData) {
                        placeholderItem = responseData;
                    }
                }, 3460);
                return placeholderItem;
            }
        }
        if (itemNumber == 1) {
            try {
                Item item = match.getRecentGamesCollected().get(i).getStats().getItem1();
                return item;
            } catch (MissingDataException e) {
                AsyncRiotAPI.getItem(new Action<Item>() {
                    @Override
                    public void handle(APIException exception) {
                        System.out.println("failed");
                    }

                    @Override
                    public void perform(Item responseData) {
                        placeholderItem = responseData;
                    }
                }, 3460);
                return placeholderItem;
            }
        }
        if (itemNumber == 2) {
            try {
                Item item = match.getRecentGamesCollected().get(i).getStats().getItem2();
                return item;
            } catch (MissingDataException e) {
                AsyncRiotAPI.getItem(new Action<Item>() {
                    @Override
                    public void handle(APIException exception) {
                        System.out.println("failed");
                    }

                    @Override
                    public void perform(Item responseData) {
                        placeholderItem = responseData;
                    }
                }, 3460);
                return placeholderItem;
            }
        }
        if (itemNumber == 3) {
            try {
                Item item = match.getRecentGamesCollected().get(i).getStats().getItem3();
                return item;
            } catch (MissingDataException e) {
                AsyncRiotAPI.getItem(new Action<Item>() {
                    @Override
                    public void handle(APIException exception) {
                        System.out.println("failed");
                    }

                    @Override
                    public void perform(Item responseData) {
                        placeholderItem = responseData;
                    }
                }, 3460);
                return placeholderItem;
            }
        }
        if (itemNumber == 4) {
            try {
                Item item = match.getRecentGamesCollected().get(i).getStats().getItem4();
                return item;
            } catch (MissingDataException e) {
                AsyncRiotAPI.getItem(new Action<Item>() {
                    @Override
                    public void handle(APIException exception) {
                        System.out.println("failed");
                    }

                    @Override
                    public void perform(Item responseData) {
                        placeholderItem = responseData;
                    }
                }, 3460);
                return placeholderItem;
            }
        }
        if (itemNumber == 5) {
            try {
                Item item = match.getRecentGamesCollected().get(i).getStats().getItem5();
                return item;
            } catch (MissingDataException e) {
                AsyncRiotAPI.getItem(new Action<Item>() {
                    @Override
                    public void handle(APIException exception) {
                        System.out.println("failed");
                    }

                    @Override
                    public void perform(Item responseData) {
                        placeholderItem = responseData;
                    }
                }, 3460);
                return placeholderItem;
            }
        }
        if (itemNumber == 6) {
            try {
                Item item = match.getRecentGamesCollected().get(i).getStats().getItem6();
                return item;
            } catch (MissingDataException e) {
                AsyncRiotAPI.getItem(new Action<Item>() {
                    @Override
                    public void handle(APIException exception) {
                        System.out.println("failed");
                    }

                    @Override
                    public void perform(Item responseData) {
                        placeholderItem = responseData;
                    }
                }, 3460);
                return placeholderItem;
            }
        } else {
            return null;
        }
    }

    public void setSummonerAccount(SummonerAccount acct){
        summonerAccount = acct;
    }

    public ArrayList<BasicMatchListItem> getBasicMatchListItems() {
        return basicMatchListItems;
    }

    public void setBasicMatchListItems(ArrayList<BasicMatchListItem> basicMatchListItems) {
        this.basicMatchListItems = basicMatchListItems;
    }

}
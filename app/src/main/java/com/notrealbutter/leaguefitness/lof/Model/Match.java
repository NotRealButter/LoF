package com.notrealbutter.leaguefitness.lof.Model;

import android.support.annotation.NonNull;

import com.robrua.orianna.type.core.game.Game;
import com.robrua.orianna.type.core.staticdata.Item;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Match {
    public List<Game> recentGamesCollected = null;
    public int killCount;
    public int deathCount;
    public int creepScore;
    public int gameDuration;
    public int assistCount;
    public ListIterator matchIterator;
    public Item item0;
    public Item item1;
    public Item item2;
    public Item item3;
    public Item item4;
    public Item item5;
    public Item item6;



    public Match() {
        this.recentGamesCollected = new List<Game>() {
            @Override
            public void add(int location, Game object) {
            }

            @Override
            public boolean add(Game object) {
                return false;
            }

            @Override
            public boolean addAll(int location, Collection<? extends Game> collection) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Game> collection) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean contains(Object object) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean equals(Object object) {
                return false;
            }

            @Override
            public Game get(int location) {
                return null;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public int indexOf(Object object) {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @NonNull
            @Override
            public Iterator<Game> iterator() {
                return null;
            }

            @Override
            public int lastIndexOf(Object object) {
                return 0;
            }

            @Override
            public ListIterator<Game> listIterator() {
                return null;
            }

            @NonNull
            @Override
            public ListIterator<Game> listIterator(int location) {
                return null;
            }

            @Override
            public Game remove(int location) {
                return null;
            }

            @Override
            public boolean remove(Object object) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> collection) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> collection) {
                return false;
            }

            @Override
            public Game set(int location, Game object) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @NonNull
            @Override
            public List<Game> subList(int start, int end) {
                return null;
            }

            @NonNull
            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @NonNull
            @Override
            public <T> T[] toArray(T[] array) {
                return null;
            }
        };
        killCount = 0;
        deathCount = 0;
        assistCount = 0;
        creepScore = 0;
        gameDuration = 0;
    }

    public List<Game> getRecentGamesCollected() {
        return recentGamesCollected;
    }

    public void setRecentGamesCollected(List<Game> recentGamesCollected) {
        this.recentGamesCollected = recentGamesCollected;
        matchIterator = getRecentGamesCollected().listIterator();
    }
}
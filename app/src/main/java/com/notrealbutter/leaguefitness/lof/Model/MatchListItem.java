package com.notrealbutter.leaguefitness.lof.Model;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.notrealbutter.leaguefitness.lof.R;
import com.robrua.orianna.type.core.staticdata.Image;

import java.sql.Time;
import java.util.ArrayList;

public class MatchListItem {
    String champName;
    String gameType;
    int kc;
    int dc;
    int ac;
    int cs;
    int gameDuration;

    public MatchListItem(String champName,  String gameType, int kc, int dc, int ac, int cs, int gameDuration) {
        this.champName = champName;
        this.gameType = gameType;
        this.kc = kc;
        this.dc = dc;
        this.ac = ac;
        this.cs = cs;
        this.gameDuration = gameDuration;
    }
}


package com.notrealbutter.leaguefitness.lof.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;
import com.notrealbutter.leaguefitness.lof.R;

import java.util.ArrayList;

public class MatchListAdapter extends BaseAdapter {

    Context mContext;
    public ArrayList<MatchListItem> gameList;
    int layoutResID;

    public int MINUTES_IN_AN_HOUR = 60;
    public int SECONDS_IN_A_MINUTE = 60;

    public MatchListAdapter(Context context, int layoutResourceID, ArrayList<MatchListItem> gameList) {
        this.mContext = context;
        this.gameList = gameList;
        this.layoutResID = layoutResourceID;
    }

    @Override
    public int getCount() {
        return gameList.size();
    }

    @Override
    public Object getItem(int position) {
        return gameList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public Object onItemClick(int position){
        return gameList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layoutResID,parent,false);
        } else {
            view = convertView;
        }

        TextView championNameBox = (TextView)view.findViewById(R.id.champion_name);
        TextView gameType = (TextView)view.findViewById(R.id.game_type);
        ImageView championFaceBox = (ImageView)view.findViewById(R.id.champion_face_box);
        TextView kcBox = (TextView)view.findViewById(R.id.kc_box);
        TextView dcBox = (TextView)view.findViewById(R.id.death_count_box);
        TextView acBox = (TextView)view.findViewById(R.id.assist_count_box);
        TextView csBox = (TextView)view.findViewById(R.id.cs_box);
        TextView gameDurationBox = (TextView)view.findViewById(R.id.game_duration_box);

        championNameBox.setText(gameList.get(position).champName);
//        System.out.println(championNameBox.getText());
        gameType.setText("On " + gameList.get(position).gameType);
//        System.out.println(gameType.getText());
        System.out.println("Picture can be found at" +gameList.get(position).championImageLocation);
        Ion.with(championFaceBox)
                .placeholder(R.drawable.profile_icon_tsm)
                .error(R.drawable.icon)
//                .animateLoad(spinAnimation)
//                .animateIn(fadeInAnimation)
                .fitXY()
                .load(gameList.get(position).championImageLocation);
        kcBox.setText("Kills: " + gameList.get(position).kc);
        dcBox.setText("Deaths: "+gameList.get(position).dc);
        acBox.setText("Assists: "+gameList.get(position).ac);
        csBox.setText("CS: "+gameList.get(position).cs);
        gameDurationBox.setText(timeConversion(gameList.get(position).gameDuration));

        return view;
    }

    public String timeConversion(int seconds) {
        int minutes = seconds / SECONDS_IN_A_MINUTE;
        seconds -= minutes * SECONDS_IN_A_MINUTE;

        int hours = minutes / MINUTES_IN_AN_HOUR;
        minutes -= hours * MINUTES_IN_AN_HOUR;

        return "Duration: " + minutes + ":" + seconds;
    }
}

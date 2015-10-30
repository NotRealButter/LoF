package com.notrealbutter.leaguefitness.lof.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.notrealbutter.leaguefitness.lof.R;

import java.util.ArrayList;

public class MatchListAdapter extends BaseAdapter {

    Context mContext;
    ArrayList<MatchListItem> gameList;

    public MatchListAdapter(Context context, ArrayList<MatchListItem> gameList) {
        this.mContext = context;
        this.gameList = gameList;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.game_view, null);
        } else {
            view = convertView;
        }

        TextView championNameBox = (TextView)view.findViewById(R.id.champion_name);
        TextView gameType = (TextView)view.findViewById(R.id.game_type);
//        ImageView championFaceBox = (ImageView)view.findViewById(R.id.champion_face_box);
        TextView kcBox = (TextView)view.findViewById(R.id.kc_box);
        TextView dcBox = (TextView)view.findViewById(R.id.death_count_box);
        TextView acBox = (TextView)view.findViewById(R.id.assist_count_box);
        TextView csBox = (TextView)view.findViewById(R.id.cs_box);
        TextView gameDurationBox = (TextView)view.findViewById(R.id.game_duration_box);

        championNameBox.setText(gameList.get(position).champName);
        gameType.setText(gameList.get(position).gameType);
        kcBox.setText(gameList.get(position).kc);
        dcBox.setText(gameList.get(position).dc);
        acBox.setText(gameList.get(position).ac);
        csBox.setText(gameList.get(position).cs);
        gameDurationBox.setText(gameList.get(position).gameDuration);
        return view;    }
}

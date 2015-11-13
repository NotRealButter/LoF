package com.notrealbutter.leaguefitness.lof.View;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.ion.Ion;
import com.notrealbutter.leaguefitness.lof.Control.ExerciseController;
import com.notrealbutter.leaguefitness.lof.Control.RiotController;
import com.notrealbutter.leaguefitness.lof.Model.MatchListAdapter;
import com.notrealbutter.leaguefitness.lof.R;

public class GameStatActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Intent mainIntent;
    Intent gameStatIntent;
    Intent exerciseIntent;

    DrawerLayout mDrawerLayout;
    String[] navMenuTitles;


    public RiotController riotController;
    public ExerciseController exerciseController;
    private TextView summNameBox;
    private TextView summIDBox;
    private TextView summLVLBox;

    MatchListAdapter matchListAdapter;
    ListView matchListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMenus();
    }

    @Override
    public void onStart()
    {
        super.onStart();
        summNameBox.setText(riotController.summonerAccount.getNameCollected());
        summLVLBox.setText(" " + riotController.summonerAccount.getSummonerLevelCollected());
        summIDBox.setText(" " + riotController.summonerAccount.getSummonerIDCollected());
    }

    @Override
    public void onResume()
    {
        super.onResume();
        initMatchList();
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            startActivity(mainIntent);
            Toast toast1 = Toast.makeText(getApplicationContext(), "this works1", Toast.LENGTH_LONG);
            toast1.show();
        } else if (id == R.id.nav_game_stat) {
            Toast toast2 = Toast.makeText(getApplicationContext(),"this works2",Toast.LENGTH_LONG);
            toast2.show();
        } else if (id == R.id.nav_exercise) {
            startActivity(exerciseIntent);
            Toast toast3 = Toast.makeText(getApplicationContext(),"this works3",Toast.LENGTH_LONG);
            toast3.show();
        } else if (id == R.id.nav_about) {
            Toast toast4 = Toast.makeText(getApplicationContext(),"this works4",Toast.LENGTH_LONG);
            toast4.show();
        } else if (id == R.id.nav_share) {
            Toast toast5= Toast.makeText(getApplicationContext(),"this works5",Toast.LENGTH_LONG);
            toast5.show();
        } else if (id == R.id.nav_send) {
            Toast toast6 = Toast.makeText(getApplicationContext(),"this works6",Toast.LENGTH_LONG);
            toast6.show();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void initMenus(){
        setContentView(R.layout.activity_game_stat);
        setTheme(R.style.AppTheme);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.riotController = MainActivity.riotControl;
        this.exerciseController = MainActivity.exerciseControl;

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mainIntent = new Intent(mDrawerLayout.getContext(), MainActivity.class);
        gameStatIntent = new Intent(mDrawerLayout.getContext(), GameStatActivity.class);
        exerciseIntent = new Intent(mDrawerLayout.getContext(), ExerciseActivity.class);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_gs);
        navigationView.setNavigationItemSelectedListener(this);
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

        matchListView = (ListView)findViewById(R.id.recentMatchListBoxGS);

        initViews();
        initMatchList();

        matchListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> av, View view, int i, long l) {
                Toast.makeText(GameStatActivity.this, "myPos "+i, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void initViews()
    {
        summNameBox = (TextView) findViewById(R.id.summonerNameBoxGS);
        summIDBox = (TextView) findViewById(R.id.summonerIDBoxGS);
        summLVLBox = (TextView) findViewById(R.id.summonerLevelBoxGS);
    }

    public void initMatchList(){
        System.out.println("Init Match List is Starting");

        riotController.initMatchList();

        matchListAdapter = new MatchListAdapter(getApplicationContext(), R.layout.game_view, riotController.getMatchListItems());
        matchListView.setAdapter(matchListAdapter);
        matchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectGame(position);
            }
        });
    }
    public void selectGame(int i) {
        final int selected = i;
        LayoutInflater li = LayoutInflater.from(GameStatActivity.this);

        View promptView = li.inflate(R.layout.expanded_game_layout, null);

        ImageView championImageBox = (ImageView) promptView.findViewById(R.id.championImageBox);
        ImageView item0Box = (ImageView) promptView.findViewById(R.id.item_0_box);
        ImageView item1Box = (ImageView) promptView.findViewById(R.id.item_1_box);
        ImageView item2Box = (ImageView) promptView.findViewById(R.id.item_2_box);
        ImageView item3Box = (ImageView) promptView.findViewById(R.id.item_3_box);
        ImageView item4Box = (ImageView) promptView.findViewById(R.id.item_4_box);
        ImageView item5Box = (ImageView) promptView.findViewById(R.id.item_5_box);
        ImageView item6Box = (ImageView) promptView.findViewById(R.id.item_6_box);
        TextView championNameBox = (TextView) promptView.findViewById(R.id.championNameBox);
        TextView mapName = (TextView) promptView.findViewById(R.id.map_name);
        TextView kda = (TextView) promptView.findViewById(R.id.kda_box);
        TextView goldBox = (TextView) promptView.findViewById(R.id.gold_earned);


        Ion.with(championImageBox)
                .placeholder(R.drawable.profile_icon_tsm)
                .error(R.drawable.icon)
//                .animateLoad(spinAnimation)
//                .animateIn(fadeInAnimation)
                .fitXY()
                .load(matchListAdapter.gameList.get(selected).championImageLocation);
        Ion.with(item0Box)
                .placeholder(R.drawable.profile_icon_tsm)
                .error(R.drawable.icon)
//                .animateLoad(spinAnimation)
//                .animateIn(fadeInAnimation)
                .fitXY()
                .load(matchListAdapter.gameList.get(selected).item0Location);
        Ion.with(item1Box)
                .placeholder(R.drawable.profile_icon_tsm)
                .error(R.drawable.icon)
//                .animateLoad(spinAnimation)
//                .animateIn(fadeInAnimation)
                .fitXY()
                .load(matchListAdapter.gameList.get(selected).item1Location);
        Ion.with(item2Box)
                .placeholder(R.drawable.profile_icon_tsm)
                .error(R.drawable.icon)
//                .animateLoad(spinAnimation)
//                .animateIn(fadeInAnimation)
                .fitXY()
                .load(matchListAdapter.gameList.get(selected).item2Location);
        Ion.with(item3Box)
                .placeholder(R.drawable.profile_icon_tsm)
                .error(R.drawable.icon)
//                .animateLoad(spinAnimation)
//                .animateIn(fadeInAnimation)
                .fitXY()
                .load(matchListAdapter.gameList.get(selected).item3Location);
        Ion.with(item4Box)
                .placeholder(R.drawable.profile_icon_tsm)
                .error(R.drawable.icon)
//                .animateLoad(spinAnimation)
//                .animateIn(fadeInAnimation)
                .fitXY()
                .load(matchListAdapter.gameList.get(selected).item4Location);
        Ion.with(item5Box)
                .placeholder(R.drawable.profile_icon_tsm)
                .error(R.drawable.icon)
//                .animateLoad(spinAnimation)
//                .animateIn(fadeInAnimation)
                .fitXY()
                .load(matchListAdapter.gameList.get(selected).item5Location);
        Ion.with(item6Box)
                .placeholder(R.drawable.profile_icon_tsm)
                .error(R.drawable.icon)
//                .animateLoad(spinAnimation)
//                .animateIn(fadeInAnimation)
                .fitXY()
                .load(matchListAdapter.gameList.get(selected).item6Location);
        championNameBox.setText(matchListAdapter.gameList.get(selected).champName);
        mapName.setText(matchListAdapter.gameList.get(selected).gameType);
        kda.setText(matchListAdapter.gameList.get(selected).kc + " / " + matchListAdapter.gameList.get(selected).dc + " / " + matchListAdapter.gameList.get(selected).ac);
        goldBox.setText(""+matchListAdapter.gameList.get(selected).goldEarned + " Gold ");

        AlertDialog.Builder gsAlertBuild = new AlertDialog.Builder(
                getSupportActionBar().getThemedContext());

        gsAlertBuild.setView(promptView);

        gsAlertBuild
                .setCancelable(false)
                .setPositiveButton("Use This Game",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                int kdaCount = ((matchListAdapter.gameList.get(selected).kc+matchListAdapter.gameList.get(selected).ac)/matchListAdapter.gameList.get(selected).dc);
                                exerciseController.setPushupCount(exerciseController.calculator(exerciseController.PUSH_UP_MAX, kdaCount));
                                System.out.println(kdaCount + "is the kda");
                                exerciseController.setSitUpCount(exerciseController.calculator(exerciseController.SIT_UP_MAX, kdaCount));
                                exerciseController.setSquatCount(exerciseController.calculator(exerciseController.SQUAT_MAX, kdaCount));
                                exerciseController.setRunDuration(exerciseController.calculator(exerciseController.MAX_RUN_DURATION,kdaCount));
                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog gsAlertDialog = gsAlertBuild.create();
        gsAlertDialog.show();
    }
}

package com.notrealbutter.leaguefitness.lof.View;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.notrealbutter.leaguefitness.lof.Control.RiotController;
import com.notrealbutter.leaguefitness.lof.Control.BasicMatchListAdapter;
import com.notrealbutter.leaguefitness.lof.R;

public class GameStatActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Intent mainIntent;
    Intent gameStatIntent;
    Intent exerciseIntent;
    Intent accountIntent;

    DrawerLayout mDrawerLayout;
    String[] navMenuTitles;

    public RiotController riotController;
    private TextView summNameBox;
    private TextView summIDBox;
    private TextView summLVLBox;

    BasicMatchListAdapter basicMatchListAdapter;
    RecyclerView matchListView;


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
        } else if (id==R.id.nav_account_information) {
            startActivity(accountIntent);
        } else if (id == R.id.nav_game_stat) {
        } else if (id == R.id.nav_exercise) {
            startActivity(exerciseIntent);
        } else if (id == R.id.nav_about) {
        } else if (id == R.id.nav_share) {
        } else if (id == R.id.nav_send) {

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void initMenus(){
        setContentView(R.layout.activity_game_stat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbar;


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(getResources().getString(R.string.gamestat));
        collapsingToolbar.setExpandedTitleColor(Color.WHITE);
        ImageView header = (ImageView) findViewById(R.id.header);


        setSupportActionBar(toolbar);

        this.riotController = MainActivity.riotControl;

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mainIntent = new Intent(mDrawerLayout.getContext(), MainActivity.class);
        gameStatIntent = new Intent(mDrawerLayout.getContext(), GameStatActivity.class);
        exerciseIntent = new Intent(mDrawerLayout.getContext(), ExerciseActivity.class);
        accountIntent = new Intent(mDrawerLayout.getContext(), AccountActivity.class);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_gs);
        navigationView.setNavigationItemSelectedListener(this);
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

        matchListView = (RecyclerView) findViewById(R.id.recentMatchListBoxGS);

        initViews();
        initMatchList();
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

        basicMatchListAdapter = new BasicMatchListAdapter(getApplicationContext(), riotController.getBasicMatchListItems());
        matchListView.setAdapter(basicMatchListAdapter);
        matchListView.setLayoutManager(new LinearLayoutManager(this));
    }
}

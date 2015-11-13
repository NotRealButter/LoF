package com.notrealbutter.leaguefitness.lof.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.notrealbutter.leaguefitness.lof.Control.ExerciseController;
import com.notrealbutter.leaguefitness.lof.Control.RiotController;
import com.notrealbutter.leaguefitness.lof.R;

public class ExerciseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Intent mainIntent;
    Intent gameStatIntent;
    Intent exerciseIntent;

    DrawerLayout mDrawerLayout;
    String[] navMenuTitles;

    ExerciseController exerciseController;
    RiotController riotController;

    TextView exerciseInitiation,crunchBox,pushUpBox,squatBox,runBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMenus();
    }


    @Override
    public void onResume()
    {
        super.onResume();
        afterSummon();
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            startActivity(mainIntent);
            Toast toast1 = Toast.makeText(getApplicationContext(), "this works1", Toast.LENGTH_LONG);
            toast1.show();
        } else if (id == R.id.nav_game_stat) {
            startActivity(gameStatIntent);
            Toast toast2 = Toast.makeText(getApplicationContext(),"this works2",Toast.LENGTH_LONG);
            toast2.show();
        } else if (id == R.id.nav_exercise) {
            Toast toast3 = Toast.makeText(getApplicationContext()," Already There",Toast.LENGTH_LONG);
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
        setContentView(R.layout.activity_exercise);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        this.exerciseController = MainActivity.exerciseControl;
        this.riotController = MainActivity.riotControl;

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

        exerciseInitiation = (TextView) findViewById(R.id.exerciseInitiation);
        crunchBox = (TextView) findViewById(R.id.crunch_view);
        pushUpBox = (TextView) findViewById(R.id.push_up_view);
        squatBox = (TextView) findViewById(R.id.squat_view);
        runBox = (TextView) findViewById(R.id.run_duration_view);
    }

    public void afterSummon(){
        if(exerciseController.getSquatCount() > 0) {
            exerciseInitiation.setText("");
            crunchBox.setText("Crunches: " + exerciseController.getSitUpCount());
            pushUpBox.setText("Push Ups: " + exerciseController.getPushupCount());
            squatBox.setText("Squats: " + exerciseController.getSquatCount());
            runBox.setText("Run Duration: " + exerciseController.getRunDuration());
        }
    }
}


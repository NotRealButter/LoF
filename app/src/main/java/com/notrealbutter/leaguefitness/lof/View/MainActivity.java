package com.notrealbutter.leaguefitness.lof.View;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.notrealbutter.leaguefitness.lof.Control.RiotController;
import com.notrealbutter.leaguefitness.lof.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout mDrawerLayout;
    CoordinatorLayout coordinatorLayout;

    Intent gameStatIntent;
    Intent exerciseIntent;
    Intent mainIntent;
    Intent accountIntent;

    String[] navMenuTitles;
    FloatingActionButton button;
    public static RiotController riotControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initMenus();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            startActivity(mainIntent);
            Toast toast1 = Toast.makeText(getApplicationContext(), "this works1", Toast.LENGTH_LONG);
            toast1.show();
        } else if (id==R.id.nav_account_information) {
            startActivity(accountIntent);
        } else if (id == R.id.nav_game_stat) {
            startActivity(gameStatIntent);
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

    public void initMenus() {
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        riotControl = new RiotController();
        riotControl.apiInit();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mainIntent = new Intent(mDrawerLayout.getContext(), MainActivity.class);
        gameStatIntent = new Intent(mDrawerLayout.getContext(), GameStatActivity.class);
        exerciseIntent = new Intent(mDrawerLayout.getContext(), ExerciseActivity.class);
        accountIntent = new Intent(mDrawerLayout.getContext(), AccountActivity.class);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

        initFAB();
    }

    public void initPrompt() {
        // get prompts.xml view
        LayoutInflater li = LayoutInflater.from(MainActivity.this);
        View promptsView = li.inflate(R.layout.prompts, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                MainActivity.this);

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText userInput = (EditText) promptsView
                .findViewById(R.id.editTextDialogUserInput);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // get user input and set it to result
                                // edit text
                                riotControl.summonerAccount.setNameCollected(userInput.getText().toString());
                                riotControl.initMatchList();
                                new FetchGameInfo().execute();

                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


    public void initFAB() {
        button = (FloatingActionButton) findViewById(R.id.fab);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                initPrompt();
            }
        });
    }

    public class FetchGameInfo extends AsyncTask<String, Void, Boolean> {
        RiotController riotControl = MainActivity.riotControl;

        private ProgressDialog dialog = new ProgressDialog(MainActivity.this);

        @Override
        protected void onPreExecute() {
            this.dialog.setMessage(getResources().getString(R.string.please_wait));
            this.dialog.show();
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {
                riotControl.leagueInit(riotControl.summonerAccount.getSummonerName());
                int random = (int)(Math.random()*1000);
                try {
                    Thread.sleep(2000 + random);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                return true;
            } catch (Exception e) {
                Log.e("tag", "error", e);
                return false;
            }
        }
        @Override
        protected void onPostExecute(final Boolean success) {

            if (dialog.isShowing()) {
                dialog.dismiss();

                SpannableStringBuilder snackbarText = new SpannableStringBuilder();
                snackbarText.append("Account ");
                snackbarText.setSpan(new ForegroundColorSpan(Color.WHITE), 0, snackbarText.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                int boldStart = snackbarText.length();
                snackbarText.append(riotControl.summonerAccount.getSummonerName());
                snackbarText.setSpan(new ForegroundColorSpan(Color.YELLOW), boldStart, snackbarText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                snackbarText.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), boldStart, snackbarText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                snackbarText.append(" has been Summoned");
                Snackbar.make(mDrawerLayout, snackbarText, Snackbar.LENGTH_LONG).setActionTextColor(Color.WHITE).show();
            }
        }
    }
}

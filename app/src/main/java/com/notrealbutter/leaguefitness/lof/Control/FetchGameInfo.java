//package com.notrealbutter.leaguefitness.lof.Control;
//
//import android.app.ProgressDialog;
//import android.os.AsyncTask;
//import android.util.Log;
//
//import com.notrealbutter.leaguefitness.lof.View.MainActivity;
//
///**
// * Created by hites on 10/30/2015.
// */
//public class FetchGameInfo extends AsyncTask<String, Void, Boolean> {
//    RiotController riotControl = MainActivity.riotControl;
//
//    private ProgressDialog dialog = new ProgressDialog(MainActivity.this);
//
//
//    /** progress dialog to show user that the backup is processing. */
//    /** application context. */
//    @Override
//    protected void onPreExecute() {
//        this.dialog.setMessage("Please wait");
//        this.dialog.show();
//    }
//
//    @Override
//    protected Boolean doInBackground(String... params) {
//        try{
//            riotControl.leagueInit(riotControl.summonerAccount.getSummonerName());
//        } catch (Exception e){
//            Log.e("tag", "error", e);
//        }
//        return null;
//    }
//}

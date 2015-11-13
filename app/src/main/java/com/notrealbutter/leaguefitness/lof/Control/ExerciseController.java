package com.notrealbutter.leaguefitness.lof.Control;

/**
 * Created by hites on 11/12/2015.
 */
public class ExerciseController {

    private int sitUpCount;
    private int squatCount;
    private int runDuration;
    private int pushupCount;
    public final int PUSH_UP_MAX = 50;
    public final int SIT_UP_MAX = 50;
    public final int SQUAT_MAX = 50;
    public final int MAX_RUN_DURATION = 4500;

    public ExerciseController(){
        setSitUpCount(0);
        setRunDuration(0);
        setPushupCount(0);
        setSquatCount(0);
    }

    public int getSitUpCount() {
        return sitUpCount;
    }

    public void setSitUpCount(int sitUpCount) {
        this.sitUpCount = sitUpCount;
    }

    public int getSquatCount() {
        return squatCount;
    }

    public void setSquatCount(int squatCount) {
        this.squatCount = squatCount;
    }

    public int getRunDuration() {
        return runDuration;
    }

    public void setRunDuration(int runDuration) {
        this.runDuration = runDuration;
    }

    public int getPushupCount() {
        return pushupCount;
    }

    public void setPushupCount(int pushupCount) {
        this.pushupCount = pushupCount;
    }

    public int calculator(int  maximum, int score){
        int internal = 0;

        internal = 5*((score));
        return internal;
    }


}

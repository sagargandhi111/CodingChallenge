package com.competition.challenge;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

/**
 * Created by Sagar Gandhi on 4/12/2018.This screen is displayed first time and last for fraction of second.
 */
public class SplashScreen extends Activity {

    //time till splash should be displayed
    private static final int SPLASH_TIME = 3 * 1000;// 1 seconds
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        RelativeLayout layout=(RelativeLayout)findViewById(R.id.splashlay);

        //load the animation from res folder
        Animation anim_fadeout=  AnimationUtils.loadAnimation( this, R.anim.fade_out);

        layout.startAnimation(anim_fadeout);

        //as soon as the time is finished,action in this particular section will be performed
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent i=new Intent(SplashScreen.this,HomeScreen.class);
                i.putExtra("splash",true);
                startActivity(i);


                SplashScreen.this.finish();

            }
        }, SPLASH_TIME);

    }
}

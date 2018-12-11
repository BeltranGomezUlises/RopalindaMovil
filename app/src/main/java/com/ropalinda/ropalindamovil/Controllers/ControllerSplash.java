package com.ropalinda.ropalindamovil.Controllers;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ropalinda.ropalindamovil.R;

public class ControllerSplash extends AppCompatActivity {

    ProgressBar progressbar_splash;
    ImageView img_logo;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_splash);

        View decorView = getWindow().getDecorView();
        // Hide both the navigation bar and the status bar.
        // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
        // a general rule, you should design your app to hide the status bar whenever you
        // hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        //checkinDB.initializeInstance();

        img_logo = findViewById(R.id.img_logo);
        img_logo.startAnimation(AnimationUtils.loadAnimation(this,R.animator.fade_in));

        progressbar_splash = findViewById(R.id.progressbar_splash);
        progressbar_splash.setIndeterminate(true);
        progressbar_splash.getIndeterminateDrawable().setColorFilter(getResources().getColor(R.color.pink),PorterDuff.Mode.SRC_IN);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);

                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{

                    Intent intent = new Intent(ControllerSplash.this, ControllerInicio.class);
                    startActivity(intent);

                }
            }                                              
        };
        timerThread.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

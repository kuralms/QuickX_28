package quick.kural.quickstart.activitys;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


import quick.kural.quickstart.Utils.SharedPrefUtils;


public class SplashActivity extends AppCompatActivity {
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 1000;  //1 Seconds
    SharedPreferences sharedpreferences;
    Intent i;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedpreferences = getSharedPreferences(SharedPrefUtils.AppPreference, Context.MODE_PRIVATE);
        Boolean RegisterSuccess = sharedpreferences.getBoolean(SharedPrefUtils.RegisterSuccess, false);
        Boolean OtpVerifySuccess = sharedpreferences.getBoolean(SharedPrefUtils.OtpVerify, false);

        OtpVerifySuccess = false;  //for testing . remove it

        if (OtpVerifySuccess) {
            i = new Intent(SplashActivity.this, SearchActivity.class);
        } else {

            i = new Intent(SplashActivity.this, SearchActivity.class);
        }

        Intent2Activity();


    }


    private void Intent2Activity() {



        new Handler().postDelayed(new Runnable() {
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                startActivity(i);
                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }


   }
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
    public static Context _context;
    String Permission4;
    private static final int PERMISSION_REQUEST_CODE = 1;
    Activity _activity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedpreferences = getSharedPreferences(SharedPrefUtils.MyPREFERENCES, Context.MODE_PRIVATE);
        Boolean RegisterSuccess = sharedpreferences.getBoolean(SharedPrefUtils.SpRegisterSuccess, false);
        Boolean OtpVerifySuccess = sharedpreferences.getBoolean(SharedPrefUtils.SpOtpVerify, false);
        // OtpVerifiedSuccess = true;  //for testing . remove it
      //  Permission4 = PermissionStrings.WRITE_EXTERNAL_STORAGE;
        if (OtpVerifySuccess) {
            i = new Intent(SplashActivity.this, MainActivity.class);
        } else {

            i = new Intent(SplashActivity.this, RegistrationActivity.class);
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
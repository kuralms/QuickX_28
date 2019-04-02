package quickstartx.kural.activitys.splash;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import quickstartx.kural.activitys.home.MainActivity;
import quickstartx.kural.activitys.home.TabbedActivity;
import quickstartx.kural.utils.BaseActivity;


public class ActSplash extends BaseActivity {
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 1000;  //1 Seconds
    Intent i;
    Boolean LoggedInUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        LoggedInUser = false;  //for testing . remove it

        if (LoggedInUser) {

            i = new Intent(ActSplash.this, TabbedActivity.class);

        } else {

            i = new Intent(ActSplash.this, TabbedActivity.class);
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
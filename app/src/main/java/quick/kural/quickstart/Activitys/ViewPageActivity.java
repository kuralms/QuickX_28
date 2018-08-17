package quick.kural.quickstart.Activitys;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import quick.kural.quickstart.Adapters.ViewPagerAdapter;
import quick.kural.quickstart.R;
import quick.kural.quickstart.Utils.SharedPrefUtils;


public class ViewPageActivity{}/* extends AppCompatActivity {

    int[] images;
    String[] text1, text2,text3;
    ImageButton btn_done;

    Button btn_Proceed;
    ViewPager viewPager;
    int pos;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }



    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_viewpager);


        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);


        viewPager = (ViewPager) findViewById(R.id.view_pager);
        //ViewPagerAdapter adapter = new ViewPagerAdapter(, text3);
        viewPager.setAdapter(adapter);

        SharedPreferences sp = getSharedPreferences(SharedPrefUtils.MyPREFERENCES, Context.MODE_PRIVATE);







    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
*/
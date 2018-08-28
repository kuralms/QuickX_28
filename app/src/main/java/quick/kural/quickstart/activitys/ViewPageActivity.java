package quick.kural.quickstart.activitys;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import quick.kural.quickstart.Adapters.ViewPagerAdapter;
import quick.kural.quickstart.R;
import quick.kural.quickstart.Retrofit.Objects.Obj_vp_data;
import quick.kural.quickstart.Utils.SharedPrefUtils;


public class ViewPageActivity extends AppCompatActivity implements ViewPagerAdapter.ViewpagerInterface{

    Obj_vp_data viewPagerDatas;
    ArrayList<Obj_vp_data> viewPagerDataslist = new ArrayList<>();
    ViewPager viewPager;
    SharedPreferences sp;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }



    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_viewpager);

        sp = getSharedPreferences(SharedPrefUtils.AppPreference, Context.MODE_PRIVATE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);


        viewPager = (ViewPager) findViewById(R.id.view_pager);
        //Set Static data
        viewPagerDatas = new Obj_vp_data("https://upload.wikimedia.org/wikipedia/commons/3/33/PasserPyrrhonotusKeulemans.jpg","one");
        for (int i = 0; i < 6 ; i++) {
            viewPagerDataslist.add(viewPagerDatas);
        }


        ViewPagerAdapter adapter = new ViewPagerAdapter(getApplicationContext(), ViewPageActivity.this,viewPagerDataslist);
        viewPager.setAdapter(adapter);








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

    @Override
    public void onViewPagerItemClick() {
        Toast.makeText(this, "ViewPager Item Clicked", Toast.LENGTH_SHORT).show();
    }
}

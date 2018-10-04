package quick.kural.quickstart.activitys;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import quick.kural.quickstart.Adapters.AdapterSearchResults;
import quick.kural.quickstart.R;
import quick.kural.quickstart.Retrofit.Objects.Obj_vp_data;
import quick.kural.quickstart.activitys.FragmentDialouge.GdprFragmentDialougePrivacyandTerms;


public class SearchActivity extends BaseActivity
        implements AdapterSearchResults.RecylerGridInterface,
        GdprFragmentDialougePrivacyandTerms.AcceptGdprInterface, BottomNavigationView.OnNavigationItemReselectedListener {

    @BindView(R.id.spinner_search_cat)
    Spinner spinner_cat;

    @BindView(R.id.recycler_view_grid)
    RecyclerView rv_grid;

    @BindView(R.id.editText_search_string)
    EditText et_searchbar;

    @BindView(R.id.bottom_navigation_view)
    BottomNavigationView btmView;

    AdapterSearchResults rv_adapter;
    ArrayList<Obj_vp_data> listDatas = new ArrayList<>();
    Obj_vp_data listData;
    private static final int TIME_INTERVAL = 1500;
    private long mBackPressed;
    private GdprFragmentDialougePrivacyandTerms dialougeGdpr;
    SlidingMenu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.RIGHT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.com_facebook_auth_dialog_background);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.sliding_menu);

        btmView.setOnNavigationItemReselectedListener(this);

        mtd_list_sample();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.select_dialog_item);
// Apply the adapter to the spinner
        spinner_cat.setAdapter(adapter);



    }

    private float mtd_calc_width() {

        DisplayMetrics displayMetrics = getApplicationContext().getResources().getDisplayMetrics();
        float dpHeight = displayMetrics.heightPixels / displayMetrics.density;
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;

        return dpWidth;
    }

    @OnClick(R.id.tb_normal_menu)
        void show_hide_menu(){
            menu.toggle();
        }

        @OnClick(R.id.editText_search_string)
        void  get_search_string(){
        et_searchbar.requestFocus();


        }

    private void mtd_list_sample() {

        listData = new Obj_vp_data("http://ih2.redbubble.net/image.9594795.6298/flat,550x550,075,f.jpg","one");
        for (int i = 0; i < 6 ; i++) {
            listDatas.add(listData);
        }
        rv_grid.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
        rv_adapter = new AdapterSearchResults(getApplicationContext(),SearchActivity.this,listDatas);
        rv_grid.setAdapter(rv_adapter);


    }




    public void ShowDialougeFragment(){

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment prev = getSupportFragmentManager().findFragmentByTag("dialog");
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);
        dialougeGdpr = GdprFragmentDialougePrivacyandTerms.newInstance("Gdpr",1);
        dialougeGdpr.setCancelable(false);
        dialougeGdpr.show(ft, "verify");


    }



    @Override
    public void recyclerItemClicked(int position) {
        Toast.makeText(this, "Recycler Item CLicked---"+position, Toast.LENGTH_SHORT).show();
        Intent in_map = new Intent(SearchActivity.this,ActivityRunMapper.class);
        startActivity(in_map);


    }

    @Override
    public void onBackPressed() {



        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis())
        {
            super.onBackPressed();
            return;
        }
        else { Toast.makeText(getBaseContext(), "Tap Back again to exit.", Toast.LENGTH_SHORT).show(); }

        mBackPressed = System.currentTimeMillis();


    }

    @Override
    public void btn_accept_gdpr(Boolean accepted) {
            dialougeGdpr.dismiss();
    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.action_search: {
            }
            break;
            case R.id.action_settings: {

                Intent settingsIntent = new Intent(SearchActivity.this,SettingsActivity.class);
                startActivity(settingsIntent);

            }
            break;
            case R.id.action_navigation: {
            }
            break;

        }
    }
}

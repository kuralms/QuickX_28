package quick.kural.quickstart.activitys;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import quick.kural.quickstart.Adapters.RecyclerViewGridAdapter;
import quick.kural.quickstart.R;
import quick.kural.quickstart.Retrofit.Objects.Obj_vp_data;
import quick.kural.quickstart.activitys.FragmentDialouge.GdprFragmentDialougePrivacyandTerms;


public class SearchActivity extends AppCompatActivity
        implements RecyclerViewGridAdapter.RecylerGridInterface,
        GdprFragmentDialougePrivacyandTerms.AcceptGdprInterface{

    @BindView(R.id.recycler_view_grid)
    RecyclerView rv_grid;
    RecyclerViewGridAdapter rv_adapter;
    ArrayList<Obj_vp_data> listDatas = new ArrayList<>();
    Obj_vp_data listData;
    private static final int TIME_INTERVAL = 1500;
    private long mBackPressed;
    private GdprFragmentDialougePrivacyandTerms dialougeGdpr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);



        mtd_list_sample();



    }

    private void mtd_list_sample() {

        listData = new Obj_vp_data("https://upload.wikimedia.org/wikipedia/commons/3/33" +
                "                               /PasserPyrrhonotusKeulemans.jpg","one");
        for (int i = 0; i < 6 ; i++) {
            listDatas.add(listData);
        }
        rv_grid.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        rv_adapter = new RecyclerViewGridAdapter(getApplicationContext(),SearchActivity.this,listDatas);
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
}

package quick.kural.quickstart.activitys;

import android.content.Intent;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import quick.kural.quickstart.Adapters.RecyclerViewGridAdapter;
import quick.kural.quickstart.R;
import quick.kural.quickstart.Retrofit.Objects.Obj_vp_data;
import quick.kural.quickstart.activitys.FragmentDialouge.GdprFragmentDialougePrivacyandTerms;
import quick.kural.quickstart.activitys.TabbedActivity.TabbedActivity;

public class MainActivity extends AppCompatActivity implements RecyclerViewGridAdapter.RecylerGridInterface,
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
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent PermissionReqest = new Intent(MainActivity.this,PermissonRequesterActivity.class);
                startActivity(PermissionReqest);

            }
        });

        listData = new Obj_vp_data("https://upload.wikimedia.org/wikipedia/commons/3/33" +
                "                               /PasserPyrrhonotusKeulemans.jpg","one");
        for (int i = 0; i < 6 ; i++) {
            listDatas.add(listData);
        }
        rv_grid.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        rv_adapter = new RecyclerViewGridAdapter(getApplicationContext(),MainActivity.this,listDatas);
        rv_grid.setAdapter(rv_adapter);






    }


    @OnClick(R.id.btn_view_pager)
    public void Launch_vp_act(){
        Intent in_vp = new Intent(MainActivity.this, ViewPageActivity.class);
        startActivity(in_vp);


    }

    @OnClick(R.id.btn_tab)
    public void ShowTabs(){

        Intent in_tab  = new Intent(MainActivity.this,TabbedActivity.class);
        startActivity(in_tab);

    }


    @OnClick(R.id.btn_fragment_dialouge)
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void recyclerItemClicked() {
        Toast.makeText(this, "Recycler Item CLicked", Toast.LENGTH_SHORT).show();
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

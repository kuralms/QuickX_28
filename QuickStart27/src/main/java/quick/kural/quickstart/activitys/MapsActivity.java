package quick.kural.quickstart.activitys;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import quick.kural.quickstart.Adapters.AdapterHorizontalScroller;
import quick.kural.quickstart.Adapters.AdapterSearchResults;
import quick.kural.quickstart.R;
import quick.kural.quickstart.Retrofit.Objects.Obj_vp_data;

public class MapsActivity extends
        FragmentActivity implements
        OnMapReadyCallback,
        AdapterHorizontalScroller.RecylerGridInterface {

    private GoogleMap mMap;
    BottomSheetBehavior bottomSheetBehaviort;

    @BindView(R.id.recycler_view_map)
    RecyclerView rv_grid;
    AdapterHorizontalScroller rv_adapter;
    ArrayList<Obj_vp_data> listDatas = new ArrayList<>();
    Obj_vp_data listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);
        ButterKnife.bind(this);

        mtd_list_sample();

        View bottomsheet = findViewById(R.id.bootom_shett_with_recycler);
        bottomSheetBehaviort = BottomSheetBehavior.from(bottomsheet);
        bottomSheetBehaviort.setState(BottomSheetBehavior.STATE_EXPANDED);
        bottomSheetBehaviort.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {

            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void mtd_list_sample() {

         listData = new Obj_vp_data("http://ih2.redbubble.net/image.9594795.6298/flat,550x550,075,f.jpg", "one");
        for (int i = 0; i < 16 ; i++) {
            listDatas.add(listData);
        }
        //rv_grid.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);


        DividerItemDecoration itemDecorator = new DividerItemDecoration(getApplicationContext(),
                DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(getApplicationContext(),
                                                   R.drawable.grid_recycler_divider));
        rv_grid.addItemDecoration(itemDecorator);
        rv_grid.setLayoutManager(gridLayoutManager);
        rv_adapter = new AdapterHorizontalScroller(getApplicationContext(),MapsActivity.this,listDatas);
        rv_grid.setAdapter(rv_adapter);


    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void recyclerItemClicked(int positionOfClick) {

    }
}

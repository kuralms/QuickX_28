package quick.kural.quickstart.activitys;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;


import butterknife.OnClick;
import quick.kural.quickstart.R;
import butterknife.BindView;
import butterknife.ButterKnife;


public class ActivityRunMapper extends
        FragmentActivity implements
        OnMapReadyCallback, LocationListener{

    private GoogleMap gMap;
    LocationManager locationManager;
    LocationListener locationListener;
    ArrayList<String> lat_long = new ArrayList<>();
    Polyline line;
    LatLng placeLocation;


    @BindView(R.id.tv_gps_logger)
    TextView tv_gps_logger;


    @BindView(R.id.toggleButton_gps)
    ToggleButton toggleButtonGps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps_tracker);
        ButterKnife.bind(this);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Toast.makeText(this, "Grant Location Permission", Toast.LENGTH_SHORT).show();

            return;
        }


        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);


        toggleButtonGps.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){



                }else {
                    locationManager.removeUpdates(ActivityRunMapper.this);
                }

            }
        });



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

        gMap = googleMap;

        // Add a marker in Sydney and move the camera
        gMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        try {
            googleMap.setMyLocationEnabled(true);
        } catch (SecurityException se) {

        }

        //Edit the following as per you needs
        googleMap.setTrafficEnabled(false);
        googleMap.setIndoorEnabled(true);
        googleMap.setBuildingsEnabled(true);
        googleMap.getUiSettings().setZoomControlsEnabled(true);
    }


    @OnClick(R.id.btn_add_polyline)
    void addline(){

        if(toggleButtonGps.isChecked()){

            startDrawing(placeLocation);


        }




    }


    private void startDrawing(LatLng placeLocation) {

        line = gMap.addPolyline(new PolylineOptions()
                .add(new LatLng(placeLocation.latitude, -0.1), new LatLng(placeLocation.longitude, -74.0))
                .width(5)
                .color(Color.RED));
        gMap.moveCamera(CameraUpdateFactory.newLatLng(placeLocation));
    }

    @Override
    public void onLocationChanged(Location location) {

        placeLocation = new LatLng(location.getLatitude(),location.getLongitude()); //Make them global
        /*gMap.addMarker(new MarkerOptions().position(placeLocation)
                .title("YOu Are here"));*/
       // gMap.moveCamera(CameraUpdateFactory.newLatLng(placeLocation));
       // gMap.animateCamera(CameraUpdateFactory.zoomTo(17), 5000, null);

        lat_long.add("--"+placeLocation.latitude+"--"+placeLocation.longitude);

        tv_gps_logger.setText(lat_long.toString());


    }




    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}

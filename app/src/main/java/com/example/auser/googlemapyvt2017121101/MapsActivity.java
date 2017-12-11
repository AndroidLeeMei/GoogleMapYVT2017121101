package com.example.auser.googlemapyvt2017121101;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.common.SignInButton;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        //在activity_maps.xml裏的fragement的name是 SupportMapFragment
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);//mapFragment與   步要同
    }

    public void trainStation(View target){
        LatLng taipei2 = new LatLng(25.060, 121.556);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(taipei2, 16));
    }
//因為目前沒有extends AppCompatActivity 所以tool bar會不見
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        menu.add("Move");
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getTitle().equals("Move"))
//        {
//
//        }
//        return super.onOptionsItemSelected(item);
//    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override// mapFragment.getMapAsync(this);在同步之後才有onMapReady()
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);//緯度,經度
        LatLng taipei = new LatLng(25.05, 121.55);//台北,按位control可以縮放,模擬兩隻手指的操作
        mMap.addMarker(new MarkerOptions().position(taipei).title("Marker in Taipei"));
        taipei = new LatLng(25.051, 121.55);//台北,按位control可以縮放,模擬兩隻手指的操作
        mMap.addMarker(new MarkerOptions().position(taipei).title("Marker in Taipei2")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        taipei = new LatLng(25.0515, 121.56);//台北,按位control可以縮放,模擬兩隻手指的操作
        mMap.addMarker(
                new MarkerOptions().position(taipei)
                        .title("Marker in Taipei2")
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.mylocation))

        );

//        mMap.moveCamera(CameraUpdateFactory.newLatLng(taipei));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(taipei,14));
    }
}

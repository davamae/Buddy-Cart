package com.example.buddycart;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.buddycart.databinding.ActivityMapBinding;

public class Map extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



        //ImageButtons
        //cartimageButton clicklistener
        ImageButton cartImageButton = findViewById(R.id.cartImageButton);
        cartImageButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //navigate to checkoutscreen when cartImageButton clicked
                Intent intent = new Intent(Map.this, CheckoutScreen.class);
                startActivity(intent);
            }
        });

        //bellimageButton clicklistener
        ImageButton bellImageButton = findViewById(R.id.bellimageButton);
        bellImageButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //navigate to Contacts screen when bellImageButton clicked
                Intent intent = new Intent(Map.this, Contacts.class);
                startActivity(intent);
            }
        });

        //mapimageButton clicklistener
        ImageButton mapImageButton = findViewById(R.id.houseImageButton);
        mapImageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //navigate to map screen when mapImageButton clicked
                Intent intent = new Intent(Map.this, MainActivity2.class);
                startActivity(intent);
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
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng kelowna = new LatLng(50, 120);
        mMap.addMarker(new MarkerOptions().position(kelowna).title("Marker in Kelowna"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kelowna));
    }
}
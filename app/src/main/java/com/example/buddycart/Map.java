package com.example.buddycart;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//BottomSheet
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;


import android.widget.ImageButton;
import android.widget.LinearLayout;

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
                //navigate to main screen when housImageButton clicked
                Intent intent = new Intent(Map.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        // Functionality for the pull up menu
        LinearLayout bottomSheet = findViewById(R.id.bottom_sheet);
        BottomSheetBehavior<LinearLayout> behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Kelowna and move the camera
        LatLng kelowna = new LatLng(50, -120);
        mMap.addMarker(new MarkerOptions().position(kelowna).title("Marker in Kelowna"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kelowna));
    }
}
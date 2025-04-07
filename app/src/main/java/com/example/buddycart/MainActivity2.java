package com.example.buddycart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        //cartimageButton clicklistener
        ImageButton cartImageButton = findViewById(R.id.cartImageButton);
        cartImageButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //navigate to checkoutscreen when cartImageButton clicked
                Intent intent = new Intent(MainActivity2.this, CheckoutScreen.class);
                startActivity(intent);
            }
        });

        //bellimageButton clicklistener
        ImageButton bellImageButton = findViewById(R.id.bellimageButton);
        bellImageButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //navigate to Contacts screen when bellImageButton clicked
                Intent intent = new Intent(MainActivity2.this, Contacts.class);
                startActivity(intent);
            }
        });

        //mapimageButton clicklistener
        ImageButton mapImageButton = findViewById(R.id.mapImageButton);
        mapImageButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //navigate to map screen when mapImageButton clicked
                Intent intent = new Intent(MainActivity2.this, Map.class);
                startActivity(intent);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
package com.example.buddycart;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LoginCodeActivity extends AppCompatActivity {

    String phoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_code);


        //getting phone number from intent
        phoneNumber = getIntent().getStringExtra("phone");

        //generate random 5-digit number
        Random random = new Random();
        int randomCode = 10000 + random.nextInt(90000);//ensures 5-digit num is between 10000 and 99999

        //display phone number in toast
        if(phoneNumber != null) {
            Toast.makeText(getApplicationContext(), "Your code is: " + randomCode, Toast.LENGTH_SHORT).show();

        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
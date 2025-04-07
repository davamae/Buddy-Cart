package com.example.buddycart;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Contacts extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ImageButton searchButton;

    ChatFragment chatFragment;
    ProfileFragment profileFragment;

    //contacts
    LinearLayout jayContact;
    LinearLayout sophiaContact;
    LinearLayout benContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contacts);

        chatFragment = new ChatFragment();
        profileFragment = new ProfileFragment();


        //initializing views
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        searchButton = findViewById(R.id.main_search_button);
        jayContact = findViewById(R.id.jay_contact);
        sophiaContact = findViewById(R.id.sophia_contact);
        benContact = findViewById(R.id.ben_contact);

        //set onClickListener for jaycontact
        jayContact.setOnClickListener((v)->{
            //start chatMessagingBox activity
            Intent intent = new Intent(Contacts.this, ChatMessagingBox.class);
            startActivity(intent);
        });

        //set onClickListener for sophiacontact
        sophiaContact.setOnClickListener((v)->{
            //start chatMessagingBox2 activity
            Intent intent = new Intent(Contacts.this, ChatMessagingBox2.class);
            startActivity(intent);
        });

        //set onClickListener for bencontact
        benContact.setOnClickListener((v)->{
            //start chatMessagingBox2 activity
            Intent intent = new Intent(Contacts.this, ChatMessagingBox3.class);
            startActivity(intent);
        });

        searchButton.setOnClickListener((v)->{
            startActivity(new Intent(Contacts.this, SearchUserActivity.class));
        });

        bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.menu_chat){
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_layout, chatFragment).commit();
                }
                if(item.getItemId() == R.id.menu_home){
                    Intent intent2 = new Intent(Contacts.this, MainActivity2.class);
                    startActivity(intent2);
                }
                if(item.getItemId() == R.id.menu_add){
                    Intent intent = new Intent(Contacts.this, LoginPhoneNumberActivity.class);
                    startActivity(intent);
                }

            }
        });

        bottomNavigationView.setSelectedItemId(R.id.menu_chat);




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
package com.example.buddycart;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class SearchUserActivity extends AppCompatActivity {

    EditText searchInput;
    ImageButton searchButton;
    ImageButton backButton;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search_user);

        searchInput = findViewById(R.id.search_name_input);
        searchButton = findViewById(R.id.search_user_button);
        backButton = findViewById(R.id.back_button);
        recyclerView = findViewById(R.id.search_user_recycler_view);

        //backbutton pressed, returns to prev screen
        backButton.setOnClickListener(v->{
            Intent intent = new Intent(SearchUserActivity.this, Contacts.class);
            startActivity(intent);
        });

        //search button pressed
        searchButton.setOnClickListener(v ->{
            String searchTerm = searchInput.getText().toString();
            if(searchTerm.isEmpty()){
                searchInput.setError("Invalid Name");
                return;
            }
            setupSearchRecyclerView(searchTerm);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    void setupSearchRecyclerView(String searchTerm){

    }
}
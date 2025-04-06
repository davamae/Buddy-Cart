package com.example.buddycart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.buddycart.model.UserModel;

public class LoginUsernameActivity extends AppCompatActivity {

    EditText nameInput;
    Button nextBtn;
    ProgressBar progressBar;
    String phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_username);

        nameInput = findViewById(R.id.login_name);
        nextBtn = findViewById(R.id.login_next_btn);
        progressBar = findViewById(R.id.login_progress_bar);

        progressBar.setVisibility(View.GONE);

        //get phonenumber from intent
        phoneNumber = getIntent().getStringExtra("phone");
        String name = nameInput.getText().toString();

        //create User object
        UserModel user = new UserModel(name, phoneNumber);

        //save user to a list
        UserData.getInstance().addUser(user);


        //setup next button to navigate to LoginUsernameActivity
        nextBtn.setOnClickListener(v ->{
            //start LoginUsernameActivity when next btn pressed
            Intent intent2 = new Intent(LoginUsernameActivity.this, Contacts.class);
            startActivity(intent2);
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }



    void setInProgress(boolean inProgress){
        if(inProgress){
            progressBar.setVisibility(View.VISIBLE);
            nextBtn.setVisibility(View.GONE);
        } else{
            progressBar.setVisibility(View.GONE);
            nextBtn.setVisibility(View.VISIBLE);
        }
    }
}
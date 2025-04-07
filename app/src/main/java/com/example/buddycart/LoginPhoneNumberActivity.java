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

public class LoginPhoneNumberActivity extends AppCompatActivity {

    EditText phoneInput;
    Button sendCodeBtn;
    Button backBtn;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_phone_number);

        phoneInput = findViewById(R.id.login_mobile_number);
        sendCodeBtn = findViewById(R.id.send_code_btn);
        backBtn = findViewById(R.id.back_btn);

        //backbutton pressed, returns to prev screen
        backBtn.setOnClickListener(v->{
            Intent intent = new Intent(LoginPhoneNumberActivity.this, Contacts.class);
            startActivity(intent);
        });


        sendCodeBtn.setOnClickListener((v)->{

            //intent to start LoginCodeActivity
            Intent intent = new Intent(LoginPhoneNumberActivity.this, LoginCodeActivity.class);

            //get phone number entered in editText
            String phoneNumber = phoneInput.getText().toString();

            //pass phone number as an extra in the intent
            intent.putExtra("phone", phoneNumber);
            Intent intent2 = new Intent(LoginPhoneNumberActivity.this, LoginUsernameActivity.class);
            intent2.putExtra("phone", phoneNumber);
            startActivity(intent);

            //start loginCodeActivity
            startActivity(intent);
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
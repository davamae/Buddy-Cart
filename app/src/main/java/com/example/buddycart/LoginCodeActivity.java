package com.example.buddycart;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
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
    TextView resendCodeTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_code);


        //getting phone number from intent
        phoneNumber = getIntent().getStringExtra("phone");

        //setup resend code TextView
        resendCodeTextView = findViewById(R.id.resend_code_textview);

        //generate random 5-digit number
        Random random = new Random();
        int randomCode = 10000 + random.nextInt(90000);//ensures 5-digit num is between 10000 and 99999

        //display phone number in toast
        if(phoneNumber != null) {
            Toast.makeText(getApplicationContext(), "Your code is: " + randomCode, Toast.LENGTH_SHORT).show();
        }

        //setup next button to navigate to LoginUsernameActivity
        Button nextButton = findViewById(R.id.login_next_btn);
        nextButton.setOnClickListener(v ->{
            //start LoginUsernameActivity when next btn pressed
            Intent intent = new Intent(LoginCodeActivity.this, LoginUsernameActivity.class);
            startActivity(intent);
        });

        //setup countdown timer for 30secs
        new CountDownTimer(30000, 1000){ //30 secs, 1 sec interval
            public void onTick(long millisUntilFinished){
                //update "resend code" text with the remaining time
                int secondsRemaining = (int)millisUntilFinished / 1000;
                resendCodeTextView.setText("Resend Code in " + secondsRemaining + " secs");
            }

            public void onFinish(){
                //once countdown finishes, generate new random code
                Random random = new Random();
                int newRandomCode = 10000 + random.nextInt(90000);
                Toast.makeText(getApplicationContext(), "New Code: " + newRandomCode, Toast.LENGTH_SHORT).show();

                //reset the resend code text to show countdown again
                resendCodeTextView.setText("Resend Code in 30 secs");

                //optionally, restart code if you want it to loop continuously
                start();
            }
        } .start();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
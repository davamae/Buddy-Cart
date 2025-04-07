package com.example.buddycart;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.BitSet;

public class shoppingPage extends AppCompatActivity {

    //Data Collection
    public static ArrayList<String> cartContents;// array of strings naming each item in the cart
    public static ArrayList<Integer> ammountInCart;//array of ints telling how much of each item is in cart
    public static ArrayList<Double> costItem;//array of item costs per item

    //Selected item data
    public static String itemName;//name of selected item
    public static double cost; //maluable cost of item
    public static Drawable imagePlace;//store the src of an image

    //Page Features
    private ImageButton apple;
    private ImageButton banana;
    private ImageButton eggs;
    private ImageButton honey;
    private ImageButton soap;
    private ImageButton shirt;
    private ImageButton watermellon;
    private Button fav;
    private Button history;
    private Button sales;
    private Button seeMore1;
    private Button seeMore2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shopping_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Handles when a user presses one of the shopping items
        apple = findViewById(R.id.appleBtn);
        apple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagePlace = apple.getDrawable();
                cost = 0.99;
                itemName = "Apple";
                sendToConfirmPage();
            }
        });
        banana = findViewById(R.id.banBtn);
        banana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagePlace = banana.getDrawable();
                cost = 1.35;
                itemName = "Banana";
                sendToConfirmPage();
            }
        });
        eggs = findViewById(R.id.eggBtn);
        eggs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagePlace = eggs.getDrawable();
                cost = 4.17;
                itemName = "Eggs";
                sendToConfirmPage();
            }
        });
        honey = findViewById(R.id.honBtn);
        honey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagePlace = honey.getDrawable();
                cost = 6.77;
                itemName = "Honey";
                sendToConfirmPage();
            }
        });
        soap = findViewById(R.id.soapBtn);
        soap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagePlace = soap.getDrawable();
                cost = 11.78;
                itemName = "Soap";
                sendToConfirmPage();
            }
        });
        shirt = findViewById(R.id.shiBtn);
        shirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagePlace = shirt.getDrawable();
                cost = 27.99;
                itemName = "Shirt";
                sendToConfirmPage();
            }
        });
        watermellon = findViewById(R.id.watBtn);
        watermellon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagePlace = watermellon.getDrawable();
                cost = 5.97;
                itemName = "Watermellon";
                sendToConfirmPage();
            }
        });













    }






// Whenever an image button is selected it loads its information to the relative fields and then calls this method to go to the confirm screen
    private void sendToConfirmPage (){
        Intent intent = new Intent(shoppingPage.this, shopConfirm.class);
        startActivity(intent);
    }






}
package com.example.buddycart;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

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
    private ImageButton cartBtn;


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

        //make sure shopping list has been created
        if (cartContents==null){
            cartContents = new ArrayList<String>();
        }
        if (ammountInCart==null){
            ammountInCart = new ArrayList<Integer>();
        }
        if (costItem==null){
            costItem = new ArrayList<Double>();
        }


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

        //other important buttons
        cartBtn = findViewById(R.id.cartBtn);
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(shoppingPage.this, checkout.class);
                startActivity(intent);
            }
        });


        //non functional buttons
        fav = findViewById(R.id.favBtn);
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(shoppingPage.this, "Will one day lead to a page of favourited items", Toast.LENGTH_SHORT).show();
            }
        });

        history = findViewById(R.id.historyBtn);
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(shoppingPage.this, "Will one day lead to a previously purchased page", Toast.LENGTH_SHORT).show();
            }
        });

        sales = findViewById(R.id.ordersBtn);
        sales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(shoppingPage.this, "Will one day lead to a page with ongoing sales", Toast.LENGTH_SHORT).show();
            }
        });


        //OnCreate bottom bar functions
        //bellimageButton clicklistener
        ImageButton bellImageButton = findViewById(R.id.bellimageButton3);
        bellImageButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //navigate to Contacts screen when bellImageButton clicked
                Intent intent = new Intent(shoppingPage.this, Contacts.class);
                startActivity(intent);
            }
        });

        //mapimageButton clicklistener
        ImageButton mapImageButton = findViewById(R.id.mapBtn1);
        mapImageButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //navigate to map screen when mapImageButton clicked
                Intent intent = new Intent(shoppingPage.this, Map.class);
                startActivity(intent);
            }
        });

        // personImageButton click listener
        ImageButton personImageButton = findViewById(R.id.personImageButton3);
        personImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to GroupAddActivity when personImageButton is clicked
                Intent intent = new Intent(shoppingPage.this, GroupAddActivity.class);
                startActivity(intent);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });




    }






// Whenever an image button is selected it loads its information to the relative fields and then calls this method to go to the confirm screen
    private void sendToConfirmPage (){
        Intent intent = new Intent(shoppingPage.this, shopConfirm.class);
        startActivity(intent);
    }






}
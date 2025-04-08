package com.example.buddycart;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.List;

public class checkout extends AppCompatActivity {


    private Button done;
    private ImageButton newPayment;
    private TextView subtotalView;
    private TextView taxView;
    private TextView totalView;
    private TextView cartList;
    private Button returnC;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_checkout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Gather relevent information

        //starting at zero, add the sum of all items together
        double subtotal = 0;
        for(int i = 0; i < shoppingPage.costItem.size(); i++){
            double temp = shoppingPage.costItem.get(i);
            temp = temp * shoppingPage.ammountInCart.get(i); //multiply price of item by number purchaced

            subtotal += temp; //after all loops well have the sub total
        }

        //determine taxes and total
        double taxes = subtotal * 0.0725;
        double total = subtotal + taxes;

        //make sure total and taxes dont have too many trailing numbers
        taxes = Math.floor(taxes*100)/100;
        total = Math.floor(total*100)/100;

        //Show list of items on screen
        int numOfItems = shoppingPage.costItem.size(); //record number of items in list

        String showItems = "";
        for (int j = 0; j < numOfItems; j++){
            double thisItemPrice = shoppingPage.costItem.get(j) * shoppingPage.ammountInCart.get(j);
            showItems = showItems + "Item " + j+1 + ": " + shoppingPage.cartContents.get(j) + " Quantity: " + shoppingPage.ammountInCart.get(j) + " Total Price: " + thisItemPrice + "\n";
        }

        //TextView updates
        subtotalView = findViewById(R.id.subtotalHere);
        taxView = findViewById(R.id.taxesHere);
        totalView = findViewById(R.id.totalHere);
        cartList = findViewById(R.id.cartListHere);

        if (shoppingPage.costItem.size() > 0) { //set to updated values
            subtotalView.setText(subtotal + "$");
            taxView.setText(taxes + "$");
            totalView.setText(total + "$");
            cartList.setText(showItems);
        } else { //have a basic retun that informs the user the cart is empty
            subtotalView.setText("" + 0.00 + "$");
            taxView.setText(0.00 + "$");
            totalView.setText("" + 0.00 + "$");
            cartList.setText("Cart is empty");
        }

        //Buttons
        newPayment = findViewById(R.id.changePayBtn);
        newPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(checkout.this, "Would allow a user to manage cards used for payment", Toast.LENGTH_SHORT).show();
            }
        });

        done = findViewById(R.id.doneBtn);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(checkout.this, "Confirms and sends payment in a real situation", Toast.LENGTH_SHORT).show();

                //after purcase is complete empty all the arrays and go back to home
                shoppingPage.cartContents.clear();
                shoppingPage.ammountInCart.clear();
                shoppingPage.costItem.clear();

                finish();
            }
        });

        returnC = findViewById(R.id.canclBtn);
        returnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });











    }
}
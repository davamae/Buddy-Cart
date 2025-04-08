package com.example.buddycart;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class shopConfirm extends AppCompatActivity {

    //counter
    private static int counter;

    //features
    private ImageButton add;
    private ImageButton sub;
    private Button confirm;
    private Button cancel;

    //setup features
    private TextView wantToBuyX;
    private ImageView showBuy;
    private TextView sumCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shop_confirm);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //set up on instantiation

        wantToBuyX = findViewById(R.id.addToCart);
        wantToBuyX.setText("Add " + shoppingPage.itemName + " to cart?"); //sets top of page text to say item name

        showBuy = findViewById(R.id.showItemImg);
        showBuy.setImageDrawable(shoppingPage.imagePlace);




        // do activities
        counter = 1;
        add = findViewById(R.id.plusBtn);
        sub = findViewById(R.id.minusBtn);
        confirm = findViewById(R.id.confirmBtn);
        cancel = findViewById(R.id.cancelBtn);
        sumCount = findViewById(R.id.sumCounter);

        //add and subtraction commands
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                sumCount.setText(counter + "");
            }

        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter > 1) {
                    counter--;
                    sumCount.setText(counter + "");
                }
            }
        });
        //Goes back to previous screen
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //confirm and add to list
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //makes a new spot in all the arrays, new index (i) is the information for that item in the cart
                shoppingPage.cartContents.add(shoppingPage.itemName);
                shoppingPage.ammountInCart.add(counter);
                shoppingPage.costItem.add(shoppingPage.cost);

                finish();
            }
        });












    }
}
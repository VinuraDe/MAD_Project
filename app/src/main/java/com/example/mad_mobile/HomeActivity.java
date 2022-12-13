package com.example.mad_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

public class HomeActivity extends AppCompatActivity {
    private ImageView option;
    private ImageView supplier;
    private ImageView customer;
    private ImageView inventory;
    private ImageView billing;
    private ImageView user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //option = (ImageView)findViewById(R.id.option_icon);
        //option.setOnClickListener(this);

        supplier = findViewById(R.id.imageView5);
        customer =  findViewById(R.id.imageView7);
        inventory = findViewById(R.id.imageView4);
        billing = findViewById(R.id.imageView6);
        user = findViewById(R.id.imageView8);


        supplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, SupplierView.class));
            }
        });

        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        billing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent());
            }
        });


    }
}
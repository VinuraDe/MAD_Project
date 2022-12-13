package com.example.mad_mobile;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SupplierView extends AppCompatActivity {

    FloatingActionButton addbutton;
    RecyclerView recyclerV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_view);

        addbutton = findViewById(R.id.addButton);
        recyclerV = findViewById(R.id.recyler_view);

//        addbutton.setOnClickListener((v)-> startActivity(new Intent(SupplierView.this, AddSupplierActivity.class)));
//        setupRecyclerView();

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddSupplierActivity.class);
                startActivity(intent);
            }
        });
    }

    void setupRecyclerView() {


    }

}
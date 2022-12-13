package com.example.mad_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;

import org.w3c.dom.Document;

import java.sql.Timestamp;

public class AddSupplierActivity extends AppCompatActivity {

    EditText email,name,phone,des;
    Button savebtn, view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_supplier);

        email = findViewById(R.id.supplierEmail);
        name = findViewById(R.id.supplierName);
        phone = findViewById(R.id.supplierPhone);
        des = findViewById(R.id.supplierDes);
        view = findViewById(R.id.view);

        savebtn = findViewById(R.id.saveSupplier);
        savebtn.setOnClickListener((v)-> saveSupplier());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SupplierView.class);
                startActivity(intent);
            }
        });

    }

    void saveSupplier() {
        String supName = email.getText().toString();
        String supEmail = name.getText().toString();
        String supPhone = phone.getText().toString();
        String supDes = des.getText().toString();




        if(supName.length() <=0 || supName.isEmpty()){
            name.setError("Supplier Name is required....");
            name.requestFocus();
            return;
        }
        if(supEmail == null || supEmail.isEmpty()){
            email.setError("Supplier email is required....");
            email.requestFocus();
            return;
        }
        if(supPhone == null || supPhone.isEmpty()){
            phone.setError("Supplier phone is required....");
            phone.requestFocus();
            return;
        }

        Supplier supplier = new Supplier();
        supplier.setName(supName);
        supplier.setEmail(supEmail);
        supplier.setPhone(supPhone);
        supplier.setDescription(supDes);
        //supplier.setRegtime(Timestamp.now());
        

        saveSupplierToFirebase(supplier);
    }

    void saveSupplierToFirebase(Supplier supplier){

        DocumentReference documentReference;
        documentReference = SupplierUtility.getCollectionReferenceForSupplier().document();

        documentReference.set(supplier).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(AddSupplierActivity.this,"Supplier added....",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(AddSupplierActivity.this, SupplierView.class));
                    finish();
                }
                else{
                    Toast.makeText(AddSupplierActivity.this,"Adding failed....",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}
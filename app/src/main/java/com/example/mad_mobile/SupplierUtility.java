package com.example.mad_mobile;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class SupplierUtility {


    static CollectionReference getCollectionReferenceForSupplier(){
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        return FirebaseFirestore.getInstance().collection("suppliers")
                .document(currentUser.getUid()).collection("My suppliers");

    }
}

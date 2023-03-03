package com.example.irite;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity {

    public static ArrayList<modelclass> list;

//    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity_main);


        list = new ArrayList<>();


//        databaseReference = FirebaseDatabase.getInstance().getReference("Question");
//
//
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                    modelclass modelclass = dataSnapshot.getValue(com.example.irite.modelclass.class);
//                    list.add(modelclass);
//                }
//                Intent intent = new Intent(SplashActivity.this, DashboardActivity.class);
//                startActivity(intent);
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
        list.add(new modelclass("For which planet, it is said that the water is present in the form of ice?", "Moon", "Mercury", "Mars", " Venus", "Mars"));
        list.add(new modelclass("According to the scientists, the world’s largest animal is", "Orca", "Blue Whale", "Camel", " African elephant", "Blue Whale"));
        list.add(new modelclass("Moldova is a landlocked country bordered by Romania and Ukraine. It is located in the", "Central Europe", "Western Europe", "Eastern Europe", " Northern Europe", "Eastern Europe"));
        list.add(new modelclass("Which is the coldest city in the world?", "Antarctica", "Yakutsk", "Alaska", "Dalarna", "Yakutsk"));
        list.add(new modelclass("On 6 February 2023, a deadly earthquake struck some parts of", "Turkey", "Lebanon", "Ukraine", "Turkey and Syria", "Turkey and Syria"));
        list.add(new modelclass("Leopard Tanks are advanced battle tanks manufactured by", " Germany", "China", "Russia", "United States", "Germany"));
        list.add(new modelclass("Which of the following country shares land border with Ukraine?", "Germany", "Croatia", "Estonia", "Poland", "Poland"));
        list.add(new modelclass("International Hockey World Cup 2023 is currently being played in", "Australia", "England", "India", "Pakistan", "India"));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        }, 1500);
    }
}

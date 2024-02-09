package com.example.smartdiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityMore extends AppCompatActivity {

    CardView locationCard, homeCard, messageCard, profileCard, expenseCard, settingCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        locationCard = findViewById(R.id.locationcard);
        locationCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityMore.this, NearPlaceViewActivity.class);
                startActivity(intent);
            }
        });

        homeCard = findViewById(R.id.homecard);
        homeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityMore.this, MainActivity.class);
                startActivity(intent);
            }
        });

        messageCard = findViewById(R.id.messagecard);
        messageCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityMore.this, TrackMessageActivity.class);
                startActivity(intent);
            }
        });

        profileCard = findViewById(R.id.profilecard);
        profileCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityMore.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        expenseCard = findViewById(R.id.addcard);
        expenseCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityMore.this, AddExpenseActivity.class);
                startActivity(intent);
            }
        });

        settingCard = findViewById(R.id.settingcard);
        settingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityMore.this, SettingActivity.class);
                startActivity(intent);
            }
        });
    }
}

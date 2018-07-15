package com.example.hasnainali.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Toast;

import static java.lang.Thread.sleep;

public class RateActivity extends AppCompatActivity {
    RatingBar ratebar;
    Button btRating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        ratebar=(RatingBar)findViewById(R.id.ratingBar);
        btRating=(Button)findViewById(R.id.btRating);
        btRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Rating=String.valueOf(ratebar.getRating());
                Toast.makeText(getApplicationContext(), Rating +"\nThanks For YourRating", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}

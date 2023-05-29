package com.example.chat_bot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class StartActivity extends AppCompatActivity {

    private static final int SPLASH_DELAY = 2000; //2 second
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        // Create a Handler
        Handler handler = new Handler();
        // Execute a task with a delay
        Runnable runnable = () -> {
            // Intent for the next activity after the delay
            Intent intent = new Intent(StartActivity.this, RulesActivity.class);
            startActivity(intent);
            finish();
        };
        handler.postDelayed(runnable, SPLASH_DELAY);
    }
}
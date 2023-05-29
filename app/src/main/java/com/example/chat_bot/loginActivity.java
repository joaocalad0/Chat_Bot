package com.example.chat_bot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void submit (View view) {
        Intent submit = new Intent(this, MainActivity.class);
        startActivity(submit);
        finish();
    }

    public void create (View view) {
        Intent create = new Intent(this, CreateAccountActivity.class);
        startActivity(create);
        finish();
    }
}
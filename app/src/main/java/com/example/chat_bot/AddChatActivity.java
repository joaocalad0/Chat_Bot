package com.example.chat_bot;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chat_bot.daos.ChatDao;
import com.example.chat_bot.db.AppDatabase;

public class AddChatActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, AddChatActivity.class);
        intent.putExtra("Key1", 100);
        intent.putExtra("Key2", "Uma String Qualquer");
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chat);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase db = AppDatabase.getInstance(getApplicationContext());
                ChatDao chatDao = db.getChatDao();
                Chat newChat = new Chat("Friendly", "message",
                        ""+System.currentTimeMillis(), 1);
                chatDao.insert(newChat);
                Intent aggressive = new Intent(getApplicationContext(), MainActivity.class);
                aggressive.putExtra(ChatDetailsActivity.KEY_CHAT_ID, newChat.getBotId());
                startActivity(aggressive);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase db = AppDatabase.getInstance(getApplicationContext());
                ChatDao chatDao = db.getChatDao();
                Chat newChat = new Chat("Agressive", "message",
                        ""+System.currentTimeMillis(), 2);
                chatDao.insert(newChat);
                Intent aggressive = new Intent(getApplicationContext(), MainActivity.class);
                aggressive.putExtra(ChatDetailsActivity.KEY_CHAT_ID, newChat.getBotId());
                startActivity(aggressive);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase db = AppDatabase.getInstance(getApplicationContext());
                ChatDao chatDao = db.getChatDao();
                Chat newChat = new Chat("Random", "message",
                        ""+System.currentTimeMillis(), 3);
                chatDao.insert(newChat);
                Intent random = new Intent(getApplicationContext(), MainActivity.class);
                random.putExtra(ChatDetailsActivity.KEY_CHAT_ID, newChat.getBotId());
                startActivity(random);
            }
        });
    }

}
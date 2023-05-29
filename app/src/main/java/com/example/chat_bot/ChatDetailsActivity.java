package com.example.chat_bot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ChatDetailsActivity extends AppCompatActivity {


        private static final String KEY_CHAT_ID = "chatId";

        public static void startActivity(Context context, long chatId) {
            Intent intent = new Intent(context, ChatDetailsActivity.class);
            intent.putExtra(ChatDetailsActivity.KEY_CHAT_ID, chatId);
            context.startActivity(intent);
        }

        private Chat chat;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_chat_details);

            Intent intent = getIntent();
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                long contactId = bundle.getLong(KEY_CHAT_ID, -1);

                AppDatabase db = AppDatabase.getInstance(this);
                ChatDao dao = db.getChatDao();
                this.chat = dao.getById(contactId);
                // Chat chat = MemoryDatabase.getChatForPosition(position);
                //ImageView imageViewAvatar = findViewById(R.id.imageViewAvatar);
                TextView textViewName = findViewById(R.id.textViewName);
                //TextView textViewPhoneNumber = findViewById(R.id.textViewPhoneNumber);

                //Glide.with(this).load(chat.getAvatar()).into(imageViewAvatar);
                //textViewName.setText(chat.getName());
                //textViewPhoneNumber.setText(chat.getPhoneNumber());
            } else {
                finish();
            }
        }

        public void deleteChat(View view) {
            AppDatabase.getInstance(this).getChatDao().delete(this.chat);
            finish();
        }
    }
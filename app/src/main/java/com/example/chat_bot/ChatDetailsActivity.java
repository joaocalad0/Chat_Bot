package com.example.chat_bot;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;

import java.util.Date;
import java.util.List;

public class ChatDetailsActivity extends AppCompatActivity {
    public static void startActivity(Context context, int id) {
        Intent intent = new Intent(context, ChatDetailsActivity.class);
        intent.putExtra(KEY_CHAT_ID, id);
        context.startActivity(intent);
    }

    private static final String KEY_CHAT_ID = "CHAT_ID";
    private RecyclerView recyclerView;
    private Chat chat;
    private MessageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_details);

        int chatId = -1;
        if (getIntent().getExtras() != null) {
            chatId = getIntent().getExtras().getInt(KEY_CHAT_ID, -1);
        }

        if (chatId == -1) {
            finish();
            return;
        }

        ActionBar actionBar = getSupportActionBar();
        recyclerView = findViewById(R.id.recyclerView1);

        this.chat = AppDatabase.getInstance(this).getChatDao().getChatById(chatId);
        if (chat != null) {
            List<Message> messageList = (List<Message>) AppDatabase.getInstance(this).getMessageDao().getMessageByChatId(chat.getId());
            adapter = new MessageAdapter(messageList, this, this);
            actionBar.setTitle(chat.getName());
        } else {
            finish();
        }

        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    public void sendMessage(View view) {
        EditText editText = findViewById(R.id.editMessage);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy\nHH:mm:ss");
        Date date = new Date();

        final Message[] message = {new Message(0, chat.getId(), editText.getText().toString(), false, formatter.format(date))};
        AppDatabase.getInstance(this).getMessageDao().add(message[0]);
        editText.setText("");
        List<Message> messageList = AppDatabase.getInstance(this).getMessageDao().getAll();
        new CountDownTimer(2000, 1000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy\nHH:mm:ss");
                Date date = new Date();
                if (messageList.get(messageList.size() - 1).getText().equalsIgnoreCase("Hello matrix")) {
                    message[0] = new Message(0, chat.getId(), "Hello my old friend", true, format.format(date));

                } else if (messageList.get(messageList.size() - 1).getText().equalsIgnoreCase("How you doing")) {
                    message[0] = new Message(0, chat.getId(), "Fine thanks!", true, format.format(date));


                } else if (messageList.get(messageList.size() - 1).getText().equalsIgnoreCase("Hello")) {
                    message[0] = new Message(0, chat.getId(), "Hello and good morning", true, format.format(date));


                } else if (messageList.get(messageList.size() -1).getText().equalsIgnoreCase("How are you?")) {
                    message[0] = new Message(0, chat.getId(), "How are you?", true, format.format(date));


                } else if (messageList.get(messageList.size() -1).getText().equalsIgnoreCase("Good and you?")) {
                    message[0] = new Message(0, chat.getId(), "Good an you?", true, format.format(date));

                

            } else {
                    message[0] = new Message(0, chat.getId(), message[0].getText(), true, format.format(date));
                }
                AppDatabase.getInstance(ChatDetailsActivity.this).getMessageDao().add(message[0]);
                adapter.notifyDataSetChanged();
                recyclerView.smoothScrollToPosition(adapter.getItemCount() - 1);
                //AppDatabase.getInstance(ChatDetailsActivity.this).getChatDao().update(message.);
            }
        }.start();
    }
}

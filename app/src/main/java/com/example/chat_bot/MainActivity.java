package com.example.chat_bot;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ChatAdapter.ChatAdapterEventListener {

    public static MainActivity mainActivity;
    private ChatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivity = this;

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        AppDatabase db = AppDatabase.getInstance(this);
        ChatDao chatDao = db.getChatDao();
        adapter = new ChatAdapter(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        List<Chat> newChatList = AppDatabase.getInstance(this).getChatDao().getAll();
        adapter.refreshList(newChatList);
    }

    public void addChat(View view) {
        AddChatActivity.start(this);
    }

    @Override
    public void onChatClicked(long chatId) {
        Intent intent = new Intent(this, ChatDetailsActivity.class);
        intent.putExtra("KEY_CHAT_ID", chatId);
        startActivity(intent);
    }

    @Override
    public void onChatLongClicked(long chatId) {
        ChatDao chatDao = AppDatabase.getInstance(MainActivity.this).getChatDao();
        Chat chat = chatDao.getById(chatId);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete Chat");
        builder.setMessage("Do you really want to delete " + chat.getName() + "?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                chatDao.delete(chat);
                List<Chat> newList = chatDao.getAll();
                adapter.refreshList(newList);
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

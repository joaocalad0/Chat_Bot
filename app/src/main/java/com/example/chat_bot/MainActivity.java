package com.example.chat_bot;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ChatAdapter.ChatAdapterEventListener {

    private ChatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // obter uma referência para a RecyclerView que existe no layout da MainActivity
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // obter uma instância do ContactDao
        AppDatabase db = AppDatabase.getInstance(this);
        ChatDao chatDao = db.getChatDao();

        // criar um objeto do tipo ContactAdapter (que extende Adapter)
        // ChatAdapter adapter = new ChatAdapter(MemoryDatabase.getAllContacts());
        this.adapter = new ChatAdapter(this);
        // ChatAdapter adapter = new ChatAdapter(AppDatabase.getInstance(this).getChatDao().getAll());

        // criar um objecto do tipo LinearLayoutManager para ser utilizado na RecyclerView
        // o LinearLayoutManager tem como orientação default a orientação Vertical
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        // Definir que a RecyclerView utiliza como Adapter o objeto que criámos anteriormente
        recyclerView.setAdapter(this.adapter);
        // Definir que a RecyclerView utiliza como LayoutManager o objeto que criámos anteriormente
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    protected void onStart() {
        super.onStart();
        List<Chat> newChatList = AppDatabase.getInstance(this).getChatDao().getAll();
        this.adapter.refreshList(newChatList);
    }

    public void addChat(View view) {
        AddChatActivity.start(this);
    }

    @Override
    public void onChatClicked(long chatId) {
        ChatDetailsActivity.startActivity(this, chatId);
    }

    @Override
    public void onChatLongClicked(long chatId) {
        // TODO add AlertDialog here
        ChatDao chatDao = AppDatabase.getInstance(MainActivity.this).getChatDao();
        Chat chat = chatDao.getById(chatId);

        // 1. Instantiate an <code><a href="/reference/android/app/AlertDialog.Builder.html">AlertDialog.Builder</a></code> with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // 2. Chain together various setter methods to set the dialog characteristics
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

        // 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
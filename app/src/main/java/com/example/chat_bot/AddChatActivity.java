package com.example.chat_bot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddChatActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, AddChatActivity.class);
        intent.putExtra("Key1", 100);
        intent.putExtra("Key2", "Uma String Qualquer");
        context.startActivity(intent);
    }

    private Button button4;
    private Button button5;
    private Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chat);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String teste1 = bundle.getString("Key2");
        int teste2 = bundle.getInt("Key1");

        this.button4 = findViewById(R.id.button4);
        this.button5 = findViewById(R.id.button5);
        this.button6 = findViewById(R.id.button6);

        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = button4.getText().toString();


                AppDatabase db = AppDatabase.getInstance(getApplicationContext());
                ChatDao chatDao = db.getChatDao();

                int botId = chatDao.getBotIdByTipeName(name);

                Chat newChat = new Chat(name, "", "", botId);

                AppDatabase.getInstance(getApplicationContext()).getChatDao().insert(newChat);
                Intent agressive = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(agressive);
            }
        });



        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = button5.getText().toString();


                AppDatabase db = AppDatabase.getInstance(getApplicationContext());
                ChatDao chatDao = db.getChatDao();

                int botId = chatDao.getBotIdByTipeName(name);

                Chat newChat = new Chat(name, "", "", botId);


                AppDatabase.getInstance(getApplicationContext()).getChatDao().insert(newChat);
                Intent friendly = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(friendly);
            }


        });



        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = button6.getText().toString();


                AppDatabase db = AppDatabase.getInstance(getApplicationContext());
                ChatDao chatDao = db.getChatDao();

                int botId = chatDao.getBotIdByTipeName(name);

                Chat newChat = new Chat(name, "", "", botId);

                AppDatabase.getInstance(getApplicationContext()).getChatDao().insert(newChat);
                Intent random = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(random);
            }


        });
    }

    public void addChatAgressive(View view) {
        // save chat to Database and finish Activity
        String name = this.button4.getText().toString();


        AppDatabase db = AppDatabase.getInstance(this);
        ChatDao chatDao = db.getChatDao();

        int botId = chatDao.getBotIdByTipeName(name);

        Chat newChat = new Chat( name, "", "", botId);

        AppDatabase.getInstance(this).getChatDao().insert(newChat);

    }



    public void addChatFriendly(View view) {
        // save chat to Database and finish Activity
        String name = this.button5.getText().toString();


        AppDatabase db = AppDatabase.getInstance(this);
        ChatDao chatDao = db.getChatDao();

        int botId = chatDao.getBotIdByTipeName(name);

        Chat newChat = new Chat( name, "", "", botId);

        AppDatabase.getInstance(this).getChatDao().insert(newChat);

    }



    public void addChatRandom(View view) {
        // save chat to Database and finish Activity
        String name = this.button6.getText().toString();


        AppDatabase db = AppDatabase.getInstance(this);
        ChatDao chatDao = db.getChatDao();

        int botId = chatDao.getBotIdByTipeName(name);

        Chat newChat = new Chat( name, "", "", botId);

        AppDatabase.getInstance(this).getChatDao().insert(newChat);
        finish();
    }


}
package com.example.chat_bot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddChatActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, AddChatActivity.class);
        intent.putExtra("Key1", 100);
        intent.putExtra("Key2", "Uma String Qualquer");
        context.startActivity(intent);
    }

    private EditText editTextName;
    private EditText editTextPhoneNumber;
    private EditText editTextAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chat);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String teste1 = bundle.getString("Key2");
        int teste2 = bundle.getInt("Key1");

        this.editTextName = findViewById(R.id.editTextName);
        this.editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        this.editTextAvatar = findViewById(R.id.editTextAvatar);
    }

    public void addChat(View view) {
        // save chat to Database and finish Activity
        String name = this.editTextName.getText().toString();
        String phoneNumber = this.editTextPhoneNumber.getText().toString();
        String avatar = this.editTextAvatar.getText().toString();

        Chat newChat = new Chat(0, name, phoneNumber, false);

//        AppDatabase appDatabase = AppDatabase.getInstance(this);
//        ChatDao chatDao = appDatabase.getChatDao();
//        chatDao.insert(newChat);

        AppDatabase.getInstance(this).getChatDao().insert(newChat);
        finish();
    }
}
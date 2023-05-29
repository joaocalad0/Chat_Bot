package com.example.chat_bot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ChatDetailsActivity extends AppCompatActivity {


        private static final String KEY_CHAT_ID = "chatId";
    private MessageAdapter adapter;

    public ChatDetailsActivity(MessageAdapter adapter) {
        Adapter = adapter;
    }


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


                // obter uma referência para a RecyclerView que existe no layout da ChatDetailsActivity
                RecyclerView recyclerView = findViewById(R.id.recyclerView1);

                // obter uma instância do ContactDao
                AppDatabase db = AppDatabase.getInstance(this);
                MessageDao contactDao = db.getMessageDao();

                // criar um objeto do tipo ContactAdapter (que extende Adapter)
                // ContactAdapter adapter = new ContactAdapter(MemoryDatabase.getAllContacts());
                this.adapter = new MessageAdapter(this);
                // ContactAdapter adapter = new ContactAdapter(AppDatabase.getInstance(this).getContactDao().getAll());

                // criar um objecto do tipo LinearLayoutManager para ser utilizado na RecyclerView
                // o LinearLayoutManager tem como orientação default a orientação Vertical
                LinearLayoutManager layoutManager = new LinearLayoutManager(this);

                // Definir que a RecyclerView utiliza como Adapter o objeto que criámos anteriormente
                recyclerView.setAdapter(this.adapter);
                // Definir que a RecyclerView utiliza como LayoutManager o objeto que criámos anteriormente
                recyclerView.setLayoutManager(layoutManager);

            }



        public void deleteChat(View view) {
            AppDatabase.getInstance(this).getChatDao().delete(this.chat);
            finish();
        }
    }
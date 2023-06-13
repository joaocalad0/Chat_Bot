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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class ChatDetailsActivity extends AppCompatActivity {

    private static final String KEY_CHAT_ID = "CHAT_ID";

    private Button buttonSend;
    private EditText editTextMessage;

    private RecyclerView recyclerView;
    private Chat chat;
    private MessageAdapter adapter;
    private long chatId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_details);

        this.chatId = getIntent().getIntExtra(KEY_CHAT_ID, 0);

        ActionBar actionBar = getSupportActionBar();
        recyclerView = findViewById(R.id.recyclerView1);
        buttonSend = findViewById(R.id.button_send);
        editTextMessage = findViewById(R.id.edit_text_message);

        this.chat = AppDatabase.getInstance(this).getChatDao().getById(chatId);
        if (chat != null) {
            List<Message> messageList = AppDatabase.getInstance(this).getMessageDao().getMessageByChatId(chat.getId());
            adapter = new MessageAdapter(messageList, this);
            actionBar.setTitle(chat.getName());
        }

        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String messageContent = editTextMessage.getText().toString();
                editTextMessage.setText("");
                if (!messageContent.isEmpty()) {
                    // Cria uma nova instância de Message
                    long timestamp = System.currentTimeMillis();
                    Message userMessage = new Message(chatId, "", messageContent, timestamp);

                    // Adiciona a mensagem a appdatabase
                    AppDatabase db = AppDatabase.getInstance(ChatDetailsActivity.this);
                    MessageDao messageDao = db.getMessageDao();
                    messageDao.add(userMessage);

                    // Verifica se o bot é do tipo "Random"
                    Bot bot = db.getBotDao().getById((int) chat.getBotId());
                    if (bot != null && bot.getBotTipeId() == 3) {
                        Message randomBotMessage = getRandomBotMessage(db, bot.getId());
                        if (randomBotMessage != null) {
                            randomBotMessage.setTimestamp(timestamp + 1000); // Adiciona um pequeno atraso à mensagem do bot
                            messageDao.add(randomBotMessage);
                        }
                    }

                    // Atualizar a lista de mensagens exibidas na RecyclerView
                    adapter.refreshList(messageDao.getMessageByChatId(chat.getId()));
                }
            }
        });
    }

    private Message getRandomBotMessage(AppDatabase db, int botId) {
        List<BotMessage> botMessages = db.getBotMessageDao().getBotMessagesByBotId(botId);
        if (botMessages != null && !botMessages.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(botMessages.size());
            BotMessage randomBotMessage = botMessages.get(randomIndex);
            return new Message(chatId, "Bot", randomBotMessage.getQuestion(), randomBotMessage.getAnswer());





        }
        return null;
    }
}

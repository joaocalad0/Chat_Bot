package com.example.chat_bot;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chat_bot.daos.MessageDao;
import com.example.chat_bot.db.AppDatabase;

import java.util.List;

public class ChatDetailsActivity extends AppCompatActivity {

    public static final String KEY_CHAT_ID = "CHAT_ID";

    private static final String SENDER = "APP_USER";

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


        this.chatId = getIntent().getLongExtra(KEY_CHAT_ID, 0L);
        recyclerView = findViewById(R.id.recyclerView1);
        buttonSend = findViewById(R.id.button_send);
        editTextMessage = findViewById(R.id.edit_text_message);

        this.chat = AppDatabase.getInstance(this).getChatDao().getById(chatId);
        List<Message> messageList = AppDatabase.getInstance(this).getMessageDao().getMessageByChatId(chat.getId());
        adapter = new MessageAdapter(messageList, this);

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
                    Message userMessage = new Message(chatId, SENDER, messageContent, timestamp);

                    // Adiciona a mensagem a appdatabase
                    AppDatabase db = AppDatabase.getInstance(ChatDetailsActivity.this);
                    MessageDao messageDao = db.getMessageDao();
                    messageDao.add(userMessage);


                    Bot bot = db.getBotDao().getById((int) chat.getBotId());
                    List<BotMessage> botMessages = db.getBotMessageDao().getBotMessagesByBotId(bot.getBotId());
                    Message botMessage = getAnswer(messageContent, bot.getId(), botMessages);
                    messageDao.add(botMessage);

                    // Atualizar a lista de mensagens exibidas na RecyclerView
                    adapter.refreshList(messageDao.getMessageByChatId(chat.getId()));
                }
            }
        });
    }

    private Message getAnswer(String userQuestion, int botId, List<BotMessage> botMessages) {
        return botMessages.stream()
                .filter(it -> it.getQuestion().equalsIgnoreCase(userQuestion))
                .findAny()
                .map(it -> new Message(chatId, "Bot:" + botId, it.getAnswer(), System.currentTimeMillis()))
                .orElseGet(() -> new Message(chatId, "Bot:" + botId, "Default response", System.currentTimeMillis()));
    }

}

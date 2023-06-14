package com.example.chat_bot;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Message {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "message_id")
    private Long messageId;

    @ColumnInfo(name = "chat_id")
    private Long chatId;

    @ColumnInfo(name = "sender")
    private String sender;

    @ColumnInfo(name = "content")
    private String content;

    @ColumnInfo(name = "timestamp")
    private Long timestamp;

    // Construtor e métodos getters/setters
    public Message(Long chatId, String sender, String content, Long timestamp) {
        this.chatId = chatId;
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
    }

    public Message() {

    }

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    // Retorna o texto da mensagem (utilizado no RecyclerView)
    public String getText() {
        return content;
    }

    // Retorna a data da mensagem (utilizado no RecyclerView)
    public Object getDate() {
        return new Date(timestamp);
    }
}








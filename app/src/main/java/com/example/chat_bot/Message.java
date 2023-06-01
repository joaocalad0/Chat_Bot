package com.example.chat_bot;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Message {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "message_id")
    private long messageId;

    @ColumnInfo(name = "chat_id")
    private long chatId;

    @ColumnInfo(name = "sender")
    private String sender;

    @ColumnInfo(name = "content")
    private String content;

    @ColumnInfo(name = "timestamp")
    private long timestamp;

    // Construtor e métodos getters/setters

    public Message(long chatId, String sender, String content, long timestamp) {
        this.chatId = chatId;
        this.sender = sender;
        this.content = content;
        this.timestamp = timestamp;
    }

    public Message(int chatId, long id, String content, boolean b, String format) {

    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }


    public String getText() {
        return null;
    }

    public Object getDate() {
        return null;
    }
}








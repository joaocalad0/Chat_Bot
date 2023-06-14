package com.example.chat_bot;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Chat {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String text;
    private String date;
    private long BotId;

    public Chat(String name, String text, String date, long BotId) {
        this.name = name;
        this.text = text;
        this.date = date;
        this.BotId = BotId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getBotId() {
        return BotId;
    }

    public void setBotId(long botId) {
        BotId = botId;
    }
}

package com.example.chat_bot;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "BotTipe")
public class BotTipe {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "botTipeId")
    private int BotTipeId;


    @ColumnInfo(name = "botTipe")
    private String BotTipe;

    @ColumnInfo(name = "botMessageId")
    private int BotMessageId;


    public BotTipe(int botTipeId, String botTipe, int botMessageId) {
        BotTipeId = botTipeId;
        BotTipe = botTipe;
        BotMessageId = botMessageId;
    }

    public int getBotTipeId() {
        return BotTipeId;
    }

    public void setBotTipeId(int botTipeId) {
        BotTipeId = botTipeId;
    }

    public String getBotTipe() {
        return BotTipe;
    }

    public void setBotTipe(String botTipe) {
        BotTipe = botTipe;
    }

    public int getBotMessageId() {
        return BotMessageId;
    }

    public void setBotMessageId(int botMessageId) {
        BotMessageId = botMessageId;
    }
}

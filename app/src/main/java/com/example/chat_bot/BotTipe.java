package com.example.chat_bot;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "BotTipe")
public class BotTipe {
    @PrimaryKey
    @ColumnInfo(name = "botTipeId")
    private int botTipeId;

    @ColumnInfo(name = "botTipeName")
    private String botTipeName;

    public BotTipe(int botTipeId, String botTipeName) {
        this.botTipeId = botTipeId;
        this.botTipeName = botTipeName;
    }

    // getters e setters

    public int getBotTipeId() {
        return botTipeId;
    }

    public void setBotTipeId(int botTipeId) {
        this.botTipeId = botTipeId;
    }

    public String getBotTipeName() {
        return botTipeName;
    }

    public void setBotTipeName(String botTipeName) {
        this.botTipeName = botTipeName;
    }
}
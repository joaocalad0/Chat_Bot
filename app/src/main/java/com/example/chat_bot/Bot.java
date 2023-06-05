package com.example.chat_bot;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Bot", foreignKeys = {@ForeignKey(entity = BotTipe.class, parentColumns = "botTipeId", childColumns = "botTipeId")})
public class Bot {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "botId")
    private int botId;

    @ColumnInfo(name = "BotName")
    private String BotName;

    @ColumnInfo(name = "botTipeId")
    private int botTipeId;


    public Bot(int botId, String botName, int botTipeId) {
        this.botId = botId;
        BotName = botName;
        this.botTipeId = botTipeId;
    }


    public int getBotId() {
        return botId;
    }

    public void setBotId(int botId) {
        this.botId = botId;
    }

    public String getBotName() {
        return BotName;
    }

    public void setBotName(String botName) {
        BotName = botName;
    }

    public int getBotTipeId() {
        return botTipeId;
    }

    public void setBotTipeId(int botTipeId) {
        this.botTipeId = botTipeId;
    }
}

package com.example.chat_bot;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "BotMessage", foreignKeys = {@ForeignKey(entity = BotTipe.class, parentColumns = "botTipeId", childColumns = "botTipeId")})
public class BotMessage {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "botMessageId")
    private int botMessageId;

    @ColumnInfo(name = "botTipe")
    private String botTipe;

    @ColumnInfo(name = "messageReceive")
    private String messageReceive;

    @ColumnInfo(name = "messageContent")
    private String messageContent;

    public BotMessage(String botTipe, String messageContent) {
        this.botTipe = botTipe;
        this.messageContent = messageContent;
    }

    // getters e setters


    public int getBotMessageId() {
        return botMessageId;
    }

    public void setBotMessageId(int botMessageId) {
        this.botMessageId = botMessageId;
    }

    public String getBotType() {
        return botTipe;
    }

    public void setBotType(String botType) {
        this.botTipe = botType;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public BotMessage(String messageReceive) {
        this.messageReceive = messageReceive;
    }

    public String getMessageReceive() {
        return messageReceive;
    }

    public void setMessageReceive(String messageReceive) {
        this.messageReceive = messageReceive;
    }
}



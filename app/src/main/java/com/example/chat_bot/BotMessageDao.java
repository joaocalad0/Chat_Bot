package com.example.chat_bot;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BotMessageDao {
    @Insert
    void insert(BotMessage botMessage);

    @Query("SELECT * FROM BotMessage WHERE botTipe = 'Agressive'")
    List<BotMessage> getAgressiveBotMessages();

    @Query("SELECT * FROM BotMessage WHERE botTipe = 'Friendly'")
    List<BotMessage> getFriendlyBotMessages();

    @Query("SELECT * FROM BotMessage WHERE botTipe = 'Random'")
    List<BotMessage> getRandomBotMessages();

    @Query("SELECT * FROM BotMessage WHERE botTipe = 'Eco'")
    List<BotMessage> getEcoBotMessages();

    @Query("SELECT * FROM BotMessage WHERE botTipe = 'Output'")
    List<BotMessage> getOutputBotMessages();
}


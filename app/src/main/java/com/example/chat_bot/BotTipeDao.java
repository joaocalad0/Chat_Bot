package com.example.chat_bot;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BotTipeDao {
    @Query("SELECT * FROM BotTipe WHERE botTipeName = 'Agressive'")
    List<BotTipe> getAgressiveBotTipes();

    @Query("SELECT * FROM BotTipe WHERE botTipeName = 'Friendly'")
    List<BotTipe> getFriendlyBotTipes();

    @Query("SELECT * FROM BotTipe WHERE botTipeName = 'Random'")
    List<BotTipe> getRandomBotTipes();


}

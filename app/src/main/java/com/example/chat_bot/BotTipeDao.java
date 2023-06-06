package com.example.chat_bot;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BotTipeDao {
    @Query("SELECT * FROM BotTipe WHERE botTipeName = 'Agressive'")
    List<BotTipe> getAgressivoBotTipes();

    @Query("SELECT * FROM BotTipe WHERE botTipeName = 'Friendly'")
    List<BotTipe> getFriendlyBotTypes();

    @Query("SELECT * FROM BotTipe WHERE botTipeName = 'Random'")
    List<BotTipe> getRandomBotTypes();

    @Query("SELECT * FROM BotTipe WHERE botTipeName = 'Eco'")
    List<BotTipe> getEcoBotTypes();
}

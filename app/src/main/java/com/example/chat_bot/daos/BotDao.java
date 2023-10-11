package com.example.chat_bot.daos;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.chat_bot.Bot;

import java.util.List;

@Dao
public interface BotDao {

    @Query("SELECT * FROM Bot")
    List<Bot>getAllBots();

    @Query("SELECT * FROM Bot WHERE botId = :id")
    Bot getById(int id);

}

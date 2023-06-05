package com.example.chat_bot;

import androidx.room.Query;

import java.util.List;

public interface BotDao {

    @Query("SELECT * FROM Bot")
    List<Bot>getAllBots();
}

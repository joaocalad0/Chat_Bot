package com.example.chat_bot.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.chat_bot.Chat;

import java.util.List;

@Dao
public interface ChatDao {

    @Query("SELECT * FROM chat")
    List<Chat> getAll();

    @Query("SELECT * FROM chat WHERE id = :Id")
    Chat getById(long Id);
    @Query("SELECT b.botId FROM Bot b INNER JOIN BotTipe bt ON b.botTipeId = bt.botTipeId WHERE bt.botTipeName = :tipeName")
    int getBotIdByTipeName(String tipeName);

    @Insert
    void insert(Chat chat);

    @Update
    void update(Chat chat);

    @Delete
    void delete(Chat chat);
}

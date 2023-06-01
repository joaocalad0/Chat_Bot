package com.example.chat_bot;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ChatDao {

    @Query("SELECT * FROM chat")
    List<Chat> getAll();

    @Query("SELECT * FROM chat WHERE id = :chatId")
    Chat getById(long chatId);

    @Insert
    void insert(Chat chat);

    @Insert
    void insert(List<Chat> chatList);

    @Update
    void update(Chat chat);

    @Delete
    void delete(Chat chat);


    @Query("SELECT * FROM chat WHERE id = :chatId")
    Chat getChatById(int chatId);


}

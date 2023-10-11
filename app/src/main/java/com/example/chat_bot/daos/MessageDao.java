package com.example.chat_bot.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.chat_bot.Message;

import java.util.List;

@Dao
public interface MessageDao {

    @Query("SELECT * FROM message")
    List<Message> getAll();

    @Query("SELECT * FROM message WHERE message.chat_id = :chat_id")
    List<Message> getMessageByChatId(long chat_id);

    @Insert
    void insert(Message message);

    @Update
    void update(Message message);

     @Insert
    void add(Message message);


}

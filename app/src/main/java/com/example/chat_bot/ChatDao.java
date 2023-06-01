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

    @Query("SELECT * FROM chat WHERE id = :Id")
    Chat getById(long Id);

    @Insert
    void insert(Chat chat);

    @Update
    void update(Chat chat);

    @Delete
    void delete(Chat chat);
}

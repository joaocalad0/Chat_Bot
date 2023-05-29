package com.example.chat_bot;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Chat {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String phoneNumber;

    private boolean favorite;

    public Chat(long id, String name, String phoneNumber, boolean favorite) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.favorite = favorite;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public boolean isFavorite() {
        return favorite;
    }
}


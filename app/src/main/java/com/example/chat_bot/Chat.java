package com.example.chat_bot;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Chat {
    @PrimaryKey(autoGenerate = true)

    private String name;
    private String phoneNumber;

    private boolean favorite;

    public Chat( String name, String phoneNumber, boolean favorite) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.favorite = favorite;
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


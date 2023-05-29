package com.example.chat_bot;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Chat.class, Message.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ChatDao getChatDao();
    public abstract MessageDao getMessageDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "chatsDB").allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                            //db.execSQL("INSERT INTO chat VALUES (1, 'Friendly', '12345678',  1)");
                            //db.execSQL("INSERT INTO chat VALUES (2, 'Agressive', '12345678',  0)");
                            //db.execSQL("INSERT INTO chat VALUES (3, 'Random', '12345678',  0)");

                        }
                    })
                    .build();
        }
        return INSTANCE;
    }
}
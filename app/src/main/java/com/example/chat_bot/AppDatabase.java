package com.example.chat_bot;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Database(entities = {Chat.class, Message.class, BotMessage.class, Bot.class, BotTipe.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ChatDao getChatDao();
    public abstract MessageDao getMessageDao();
    public abstract BotTipeDao getBotTipeDao();
    public abstract BotMessageDao getBotMessageDao();
    public abstract BotDao getBotDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "chatsDB").allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);

                            // friendly
                            db.execSQL("INSERT INTO BotTipe VALUES(1, 'Friendly')");
                            db.execSQL("INSERT INTO Bot VALUES(1, 'Friendly', 1)");

                            // agressive
                            db.execSQL("INSERT INTO BotTipe VALUES(2, 'Agressive')");
                            db.execSQL("INSERT INTO Bot VALUES(2, 'Agressive', 2)");

                            // random
                            db.execSQL("INSERT INTO BotTipe VALUES(3,'Random')");
                            db.execSQL("INSERT INTO Bot VALUES(3, 'Random', 3)");

                            // chats
//                            db.execSQL("INSERT INTO chat VALUES(1, 'Friendly', 'message',  NULL, 1)");
//                            db.execSQL("INSERT INTO chat VALUES(2, 'Agressive', 'message',  NULL, 2)");
//                            db.execSQL("INSERT INTO chat VALUES(3, 'Random', 'message', NULL, 3)");

                            //segundo valor é o id do tipo de bot
                            db.execSQL("INSERT INTO BotMessage VALUES(1,1, 'Hi', 'Hi budy! im Friendly')");
                            db.execSQL("INSERT INTO BotMessage VALUES(4,1, 'How are you?', 'Good and you?')");
                            db.execSQL("INSERT INTO BotMessage VALUES(7,1, 'Good', 'how can i help you?')");


                            db.execSQL("INSERT INTO BotMessage VALUES(2,2, 'Hello', 'Get out')");
                            db.execSQL("INSERT INTO BotMessage VALUES(5,2, 'why?', 'i  dont wanna talk to you')");
                            db.execSQL("INSERT INTO BotMessage VALUES(8,2, 'Hi', 'Hi')");


                            db.execSQL("INSERT INTO BotMessage VALUES(3,3, 'Wsup', 'Wsup')");
                            db.execSQL("INSERT INTO BotMessage VALUES(6,3, 'hows your day?', 'hey dear, good')");
                            db.execSQL("INSERT INTO BotMessage VALUES(9,3, 'good morning', 'good morning')");

                        }
                    })
                    .setQueryCallback((sql, args) -> System.out.println(String.format("SQL Query: %s SQL Args: %s", sql, args)), Executors.newSingleThreadExecutor())
                    .build();
        }
        return INSTANCE;
    }
}
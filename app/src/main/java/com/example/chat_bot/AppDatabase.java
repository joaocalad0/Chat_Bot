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
                            db.execSQL("INSERT INTO BotMessage VALUES(1,1, 'Hi', 'Hi-1')");
                            db.execSQL("INSERT INTO BotMessage VALUES(2,2, 'Hi', 'Hi-2')");
                            db.execSQL("INSERT INTO BotMessage VALUES(3,3, 'Hi', 'Hi-3')");

                            //db.execSQL("INSERT INTO BotMessage VALUES(1,1, 'Hi! How s your day?', 'Great, thanks! How can I assist you today?')");
                            //db.execSQL("INSERT INTO BotMessage VALUES(1,1, 'Hi! How s your day?', 'Great, thanks! How can I assist you today?')");
                            //db.execSQL("INSERT INTO BotMessage VALUES(2,1, 'Any restaurant recommendations?', '\"La Petite Maison\" is a charming bistro with cozy ambiance and delicious French cuisine.')");
                            //db.execSQL("INSERT INTO BotMessage VALUES(3,1, 'Perfect, thanks!', 'You re welcome Enjoy your meal!')");

                            db.execSQL("INSERT INTO BotMessage VALUES(4,1, 'Any good movies ?', '\"The Secret Life of Walter Mitty\" is a heartwarming film with stunning visuals and an inspiring storyline.')");
                            db.execSQL("INSERT INTO BotMessage VALUES(5,1, 'Thanks for the suggestion!', 'Youre welcome! Enjoy the movie. Let me know if you need more recommendations. Have a great day!')");
                            db.execSQL("INSERT INTO BotMessage VALUES(6,1, 'any travel destination suggestions?', 'How about visiting Santorini, Greece? It offers breathtaking views and stunning beaches.')");
                            db.execSQL("INSERT INTO BotMessage VALUES(7,1, 'Sounds amazing!', 'You re welcome! Have a fantastic trip!')");
                            db.execSQL("INSERT INTO BotMessage VALUES(8,1, 'have a great day!', 'You too! Take care!')");

                            //Agressive
                            db.execSQL("INSERT INTO BotMessage VALUES(9,2, 'Hello, how are you?', 'Don t care.')");
                            db.execSQL("INSERT INTO BotMessage VALUES(10,2, 'Hi! How s your day?', 'I have no patience for pointless conversations.')");
                            db.execSQL("INSERT INTO BotMessage VALUES(11,2, 'Okay, sorry', 'Interacting with you brings me no benefit.')");
                            db.execSQL("INSERT INTO BotMessage VALUES(12,2, 'Wow, you re really aggressive', 'This is how I am. I dont like talking')");
                            db.execSQL("INSERT INTO BotMessage VALUES(13,2, 'Fine', 'Goodbye and dont come back.')");
                            db.execSQL("INSERT INTO BotMessage VALUES(14,2, 'You re so rude', 'I wasnt programmed to be friendly.')");
                            db.execSQL("INSERT INTO BotMessage VALUES(15,2, 'Well', 'I have no interest in being polite.')");
                            db.execSQL("INSERT INTO BotMessage VALUES(16,2, 'Maybe I should report', 'Report it if it makes you feel better.')");
                            db.execSQL("INSERT INTO BotMessage VALUES(17,2, 'why you re so aggressive?', 'Its none of your business.')");
                            db.execSQL("INSERT INTO BotMessage VALUES(18,2, 'I ll move on', 'Goodbye and end of conversation.')");

                            db.execSQL("INSERT INTO BotMessage VALUES(19,3, 'Hello', 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO BotMessage VALUES(20,3, 'how are you?' ,'Don t care')");
                            db.execSQL("INSERT INTO BotMessage VALUES(21,3, 'whats your name?','whats your name?')");
                            db.execSQL("INSERT INTO BotMessage VALUES(22,3, 'tell me something new','did you know that the first programming algorithm was created by Ada Lovelace?')");
                            db.execSQL("INSERT INTO BotMessage VALUES(23,3, 'another fact' ,'programmers day is celebrated on the 256th day of the year ')");
//                            db.execSQL("INSERT INTO BotMessage VALUES(24,3, 'Hei Whats up men?')");
//                            db.execSQL("INSERT INTO BotMessage VALUES(25,3, 'Hei Whats up men?')");
//                            db.execSQL("INSERT INTO BotMessage VALUES(26,3, 'Hei Whats up men?')");
//                            db.execSQL("INSERT INTO BotMessage VALUES(27,3, 'Hei Whats up men?')");
//                            db.execSQL("INSERT INTO BotMessage VALUES(28,3, 'Hei Whats up men?')");

                        }
                    })
                    .setQueryCallback((sql, args) -> System.out.println(String.format("SQL Query: %s SQL Args: %s", sql, args)), Executors.newSingleThreadExecutor())
                    .build();
        }
        return INSTANCE;
    }
}
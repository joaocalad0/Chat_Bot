package com.example.chat_bot;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Chat.class, Message.class, BotMessage.class, BotTipe.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ChatDao getChatDao();
    public abstract MessageDao getMessageDao();
    public abstract BotTipeDao getBotTipeDao();
    public abstract BotMessageDao getBotMessage();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "chatsDB").allowMainThreadQueries()
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);

                            //friendly

                            db.execSQL("INSERT INTO Friendly VALUES(0, 'hello')");
                            db.execSQL("INSERT INTO Friendly VALUES(1, 'hi')");
                            db.execSQL("INSERT INTO Friendly VALUES(2, 'hey')");
                            db.execSQL("INSERT INTO Friendly VALUES(3, 'how are you?')");
                            db.execSQL("INSERT INTO Friendly VALUES(4, 'how have you been?')");
                            db.execSQL("INSERT INTO Friendly VALUES(5, 'good')");
                            db.execSQL("INSERT INTO Friendly VALUES(6, 'i am not feeling good')");
                            db.execSQL("INSERT INTO Friendly VALUES(7, 'i am feeling bad')");
                            db.execSQL("INSERT INTO Friendly VALUES(8, 'i am sad')");
                            db.execSQL("INSERT INTO Friendly VALUES(9, 'bad')");
                            db.execSQL("INSERT INTO Friendly VALUES(10, 'Good morning')");
                            db.execSQL("INSERT INTO Friendly VALUES(11, 'Good evening')");
                            db.execSQL("INSERT INTO Friendly VALUES(12, 'Good night')");
                            db.execSQL("INSERT INTO Friendly VALUES(13, 'Whats up?')");
                            db.execSQL("INSERT INTO Friendly VALUES(14, 'its good to see you')");
                            db.execSQL("INSERT INTO Friendly VALUES(15, 'hi there')");
                            db.execSQL("INSERT INTO Friendly VALUES(16, 'tell me a joke')");
                            db.execSQL("INSERT INTO Friendly VALUES(17, 'make me laugh')");
                            db.execSQL("INSERT INTO Friendly VALUES(18, 'whats your favorite movie')");



                            //agresive

                            db.execSQL("INSERT INTO Agressive VALUES(19, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Agressive VALUES(20, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Agressive VALUES(21, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Agressive VALUES(22, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Agressive VALUES(23, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Agressive VALUES(24, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Agressive VALUES(25, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Agressive VALUES(26, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Agressive VALUES(27, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Agressive VALUES(28, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Agressive VALUES(29, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Agressive VALUES(30, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Agressive VALUES(31, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Agressive VALUES(32, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Agressive VALUES(33, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Agressive VALUES(34, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Agressive VALUES(35, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Agressive VALUES(36, 'Hei Whats up men?')");




                            //random

                            db.execSQL("INSERT INTO Random VALUES(37, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Random VALUES(38, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Random VALUES(39, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Random VALUES(40, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Random VALUES(41, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Random VALUES(42, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Random VALUES(43, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Random VALUES(44, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Random VALUES(45, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Random VALUES(46, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Random VALUES(47, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Random VALUES(48, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Random VALUES(49, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Random VALUES(50, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Random VALUES(51, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Random VALUES(52, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Random VALUES(53, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Random VALUES(54, 'Hei Whats up men?')");




                            //eco

                            db.execSQL("INSERT INTO Eco VALUES(37, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Eco VALUES(38, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Eco VALUES(39, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Eco VALUES(40, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Eco VALUES(41, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Eco VALUES(42, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Eco VALUES(43, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Eco VALUES(44, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Eco VALUES(45, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Eco VALUES(46, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Eco VALUES(47, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Eco VALUES(48, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Eco VALUES(49, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Eco VALUES(50, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Eco VALUES(51, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Eco VALUES(52, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Eco VALUES(53, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO Eco VALUES(54, 'Hei Whats up men?')");




                        }
                    })
                    .build();
        }
        return INSTANCE;
    }
}
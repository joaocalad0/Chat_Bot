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
                            db.execSQL("INSERT INTO friendly VALUES(0, 'hello')");
                            db.execSQL("INSERT INTO friendly VALUES(1, 'hi')");
                            db.execSQL("INSERT INTO friendly VALUES(2, 'hey')");
                            db.execSQL("INSERT INTO friendly VALUES(3, 'how are you?')");
                            db.execSQL("INSERT INTO friendly VALUES(4, 'how have you been?')");
                            db.execSQL("INSERT INTO friendly VALUES(5, 'good')");
                            db.execSQL("INSERT INTO friendly VALUES(6, 'i am not feeling good')");
                            db.execSQL("INSERT INTO friendly VALUES(7, 'i am feeling bad')");
                            db.execSQL("INSERT INTO friendly VALUES(8, 'i am sad')");
                            db.execSQL("INSERT INTO friendly VALUES(9, 'bad')");
                            db.execSQL("INSERT INTO friendly VALUES(10, 'Good morning')");
                            db.execSQL("INSERT INTO friendly VALUES(11, 'Good evening')");
                            db.execSQL("INSERT INTO friendly VALUES(12, 'Good night')");
                            db.execSQL("INSERT INTO friendly VALUES(13, 'Whats up?')");
                            db.execSQL("INSERT INTO friendly VALUES(14, 'its good to see you')");
                            db.execSQL("INSERT INTO friendly VALUES(15, 'hi there')");
                            db.execSQL("INSERT INTO friendly VALUES(16, 'tell me a joke')");
                            db.execSQL("INSERT INTO friendly VALUES(17, 'make me laugh')");
                            db.execSQL("INSERT INTO friendly VALUES(18, 'whats your favorite movie')");



                            //

                            db.execSQL("INSERT INTO agressive VALUES(19, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO agressive VALUES(20, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO agressive VALUES(21, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO agressive VALUES(22, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO agressive VALUES(23, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO agressive VALUES(24, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO agressive VALUES(25, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO agressive VALUES(26, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO agressive VALUES(27, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO agressive VALUES(28, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO agressive VALUES(29, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO agressive VALUES(30, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO agressive VALUES(31, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO agressive VALUES(32, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO agressive VALUES(33, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO agressive VALUES(34, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO agressive VALUES(35, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO agressive VALUES(36, 'Hei Whats up men?')");

                            //



                            db.execSQL("INSERT INTO random VALUES(37, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO random VALUES(38, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO random VALUES(39, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO random VALUES(40, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO random VALUES(41, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO random VALUES(42, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO random VALUES(43, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO random VALUES(44, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO random VALUES(45, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO random VALUES(46, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO random VALUES(47, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO random VALUES(48, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO random VALUES(49, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO random VALUES(50, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO random VALUES(51, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO random VALUES(52, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO random VALUES(53, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO random VALUES(54, 'Hei Whats up men?')");




                            //


                            db.execSQL("INSERT INTO eco VALUES(37, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO eco VALUES(38, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO eco VALUES(39, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO eco VALUES(40, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO eco VALUES(41, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO eco VALUES(42, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO eco VALUES(43, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO eco VALUES(44, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO eco VALUES(45, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO eco VALUES(46, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO eco VALUES(47, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO eco VALUES(48, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO eco VALUES(49, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO eco VALUES(50, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO eco VALUES(51, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO eco VALUES(52, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO eco VALUES(53, 'Hei Whats up men?')");
                            db.execSQL("INSERT INTO eco VALUES(54, 'Hei Whats up men?')");



                            //

                        }
                    })
                    .build();
        }
        return INSTANCE;
    }
}
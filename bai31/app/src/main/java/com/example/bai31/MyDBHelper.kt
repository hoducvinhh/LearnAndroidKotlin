package com.example.bai31

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class MyDBHelper(context: Context):SQLiteOpenHelper(context, "UserDB",null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        // tao bang
        db?.execSQL("CREATE TABLE Users(UserID INTEGER PRIMARY KEY AUTOINCREMENT,uname text, pwd text )")
        // add data
        db?.execSQL("insert into Users(Uname,pwd) values ('teo@gmail.com','12345')")
        db?.execSQL("insert into Users(Uname,pwd) values ('ti@gmail.com','12345789')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}
package com.sahas.roomsetup.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sahas.roomsetup.model.User
import com.sahas.roomsetup.repositories.UserDao

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

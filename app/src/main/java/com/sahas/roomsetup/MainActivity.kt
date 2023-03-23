package com.sahas.roomsetup

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.sahas.roomsetup.config.AppDatabase
import com.sahas.roomsetup.model.User
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.tv)
        tv.setText("")

        val db = Room.databaseBuilder(
            this, AppDatabase::class.java,
            "mydatabase"
        ).build()
        val userDao = db.userDao()

        runBlocking {
            launch {
                val user = User(1, "John", "Smith")
                val user2 = User(2, "Helen", "Jones")
                val user3 = User(3, "Mary", "Popkins")
                userDao.insertUsers(user, user2, user3)
                val users: List<User> = userDao.getAll()
                for (u in users) {
                    tv.append("\n ${u.firstName} ${u.lastName}")
                }
            }
        }
    }
}
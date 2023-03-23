package com.sahas.roomsetup.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User(
    @PrimaryKey val id: Int,
    val firstName: String?,
    val lastName: String?
)
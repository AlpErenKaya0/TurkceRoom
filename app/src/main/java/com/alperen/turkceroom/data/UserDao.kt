package com.alperen.turkceroom.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {
    //oluşturduğumuz entity tipinde bir livedata olması lazım
    //tüm veri çekiliyor, ilgili veri değil
    @Query(value="SELECT * FROM users ORDER BY id ASC ")
    fun readAllData():LiveData<List<User>>
    //Conflict strategy'si önemli! şu anlık ignore
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user:User)
    //delete update gibi işlemlerin yapılabilmesi için primary key lazım
    @Update
    suspend fun updateUser(user: User)
    @Delete
    suspend fun deleteUser(user: User)
}
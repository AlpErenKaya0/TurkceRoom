package com.alperen.turkceroom.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.alperen.turkceroom.data.User
import com.alperen.turkceroom.data.UserDatabase
import com.alperen.turkceroom.data.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application):AndroidViewModel(application)
{
    val readAllData:LiveData<List<User>>
    private val repository:UserRepository
    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = userDao.readAllData()
    }
    fun addUser(user: User){
        viewModelScope.launch( Dispatchers.IO) {
            //yapılacak işlemlerin fonksiyonlarını kullandık
            repository.addUser(user)
        }
    }
    fun updateUser(user: User){
        viewModelScope.launch( Dispatchers.IO) {
            //yapılacak işlemlerin fonksiyonlarını kullandık
            repository.updateUser(user)
        }
    }
    fun deleteUser(user: User){
        viewModelScope.launch( Dispatchers.IO) {
            //yapılacak işlemlerin fonksiyonlarını kullandık
            repository.deleteUser(user)
        }
    }
}
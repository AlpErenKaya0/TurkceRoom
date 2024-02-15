package com.alperen.turkceroom

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.alperen.turkceroom.data.User
import com.alperen.turkceroom.viewModel.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        // Yeni bir User nesnesi oluşturup veritabanına ekleyelim
        val newUser = User(0, "Alperen", 25)
        userViewModel.addUser(newUser)

        // Eklediğimiz kullanıcıyı tekrar çekerek doğru bir şekilde eklenip eklenmediğini kontrol edelim
        userViewModel.readAllData.observe(this, { userList ->
            val itemsList = mutableListOf<String>()
            userList.forEach { user ->
                itemsList.add(user.toString())
            }
            Log.d("MainActivity", "User List: $itemsList")
        })
    }
}
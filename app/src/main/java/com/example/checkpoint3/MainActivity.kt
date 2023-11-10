package com.example.checkpoint3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.checkpoint3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UserAdapter
    private lateinit var users :List<User>


    val db = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java, "database-name"
    ).build()

    val userDao = db.userDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        getUsers();

        binding.rvRecycler.layoutManager = LinearLayoutManager(this)
        adapter = UserAdapter(users)
        binding.rvRecycler.adapter = adapter


    }

    private fun getUsers() {
        users = userDao.getAll()
    }

    private fun saveUser() {
        val user: User = User(0, binding.editTextNome.toString(), binding.editTextEmail.toString());

        userDao.insertAll(user);
    }
}
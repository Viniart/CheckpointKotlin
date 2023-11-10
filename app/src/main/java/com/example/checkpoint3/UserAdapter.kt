package com.example.checkpoint3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.checkpoint3.databinding.TextRowItemBinding

class UserAdapter(var datalist:List<User>): RecyclerView.Adapter<UserAdapter.UserHolder>() {


    class UserHolder(val binding: TextRowItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(get: User) {
            binding.name.text = get.nome
            binding.email.text = get.email

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val binding = TextRowItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return UserHolder(binding)
    }



    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind(datalist.get(position))
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

}
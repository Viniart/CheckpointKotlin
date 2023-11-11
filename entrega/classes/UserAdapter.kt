package com.example.checkpoint3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.checkpoint3.databinding.TextRowItemBinding

class UserAdapter(var datalist:MutableList<User>): RecyclerView.Adapter<UserAdapter.UserHolder>() {

    class UserHolder(val binding: TextRowItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(get: User) {
            binding.name.text = get.id.toString()
            binding.email.text = get.nome + get.email

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val binding = TextRowItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return UserHolder(binding)
    }



    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.binding.imagem.setOnClickListener{deleteItem(Integer.parseInt(holder.binding.name.text.toString()))}
        holder.bind(datalist.get(position))

    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    fun deleteItem(index: Int){
        datalist.removeAt(index)
        notifyDataSetChanged()
    }

}
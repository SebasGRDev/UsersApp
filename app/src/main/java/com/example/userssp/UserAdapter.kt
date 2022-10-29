package com.example.userssp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.userssp.databinding.ItemUsersBinding

class UserAdapter(private val users: List<User>): RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_users, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]

        with(holder){
            binding.tvOrder.text = (position + 1).toString()
            binding.tvName.text = user.getFullName()
            Glide.with(context)
                .load(user.url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .circleCrop()
                .into(binding.ivPhoto)
        }
    }

    override fun getItemCount(): Int = users.size

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var binding = ItemUsersBinding.bind(view)
    }
}
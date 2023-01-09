package com.example.c1_pokemoncards

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.c1_pokemoncards.databinding.ActivityMainBinding



class MyAdaptor(val context: Context, val userList: My_Data) : RecyclerView.Adapter<MyAdaptor.Viewholder>() {
    class Viewholder(itemView : View) : RecyclerView.ViewHolder(itemView){

//          var NationalPokedexNumber : TextView
          var ImageUrlHiRes : ImageView

         init {
//             NationalPokedexNumber = itemView.findViewById(R.id.ID)
             ImageUrlHiRes = itemView.findViewById(R.id.imageView_CardView)
         }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {

        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_view , parent , false)
        return Viewholder(itemView)

    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {

//        val currentItem = userList.cards[position].nationalPokedexNumber
//        holder.NationalPokedexNumber.text = currentItem.toString()

        Glide.with(context)
            .load(userList.cards[position].imageUrlHiRes)
            .into(holder.ImageUrlHiRes)



    }

    override fun getItemCount(): Int {

        return userList.cards.size

    }

}

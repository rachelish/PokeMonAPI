package com.example.pokemonapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class pokeAdapter(private val pokeList: List<String>) : RecyclerView.Adapter<pokeAdapter.ViewHolder>() {

      class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val pokeImage: TextView

        init {
            // Find our RecyclerView item's ImageView for future use
            pokeImage = view.findViewById(R.id.poke_list)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): pokeAdapter.ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.poke_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: pokeAdapter.ViewHolder, position: Int) {
//        Glide.with(holder.itemView)
//            .load(pokeList[position])
//            .centerCrop()
//            .into(holder.pokeImage)


    }

    override fun getItemCount() = pokeList.size

}




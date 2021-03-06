package com.example.artists.presentations.artists

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.artists.databinding.FragmentItemArtistBinding
import com.example.artists.viewmodels.Artist

/**
 * [RecyclerView.Adapter] that can display a [Artist].
 */
class ArtistsRecyclerViewAdapter(
    private val artists: List<Artist>,
) : RecyclerView.Adapter<ArtistsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(FragmentItemArtistBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
    var onEndOfListReached: (() -> Unit)? = null


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = artists[position]
        holder.idView.text = position.toString()
        holder.contentView.text = item.name
        if (position == artists.size - 1) {
            onEndOfListReached?.invoke()
        }
    }

    override fun getItemCount(): Int = artists.size

    inner class ViewHolder(binding: FragmentItemArtistBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }
}
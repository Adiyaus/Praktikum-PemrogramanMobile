package com.example.m3xml.ui.theme

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.m3xml.data.Film
import com.example.m3xml.databinding.ListItemBinding

class FilmAdapter(
    private val onDetailClick: (Film) -> Unit,
    private val onImdbClick: (Film) -> Unit
) : ListAdapter<Film, FilmAdapter.FilmViewHolder>(FilmDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = getItem(position)
        holder.bind(film)
    }

    inner class FilmViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(film: Film) {
            binding.ivItemPoster.setImageResource(film.poster)
            binding.tvItemTitle.text = film.title

            binding.buttonItemDetail.setOnClickListener {
                onDetailClick(film)
            }

            binding.buttonItemImdb.setOnClickListener {
                onImdbClick(film)
            }
        }
    }
}

class FilmDiffCallback : DiffUtil.ItemCallback<Film>() {
    override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean {
        return oldItem == newItem
    }
}
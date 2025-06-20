package com.example.m3xml.ui.theme

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.m3xml.databinding.ListItemBinding
import com.example.m3xml.data.Film

class FilmAdapter(private val filmList: List<Film>) :
    RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {

    var onDetailClick: ((Int) -> Unit)? = null

    inner class FilmViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = filmList[position]
        with(holder.binding) {
            ivPoster.setImageResource(film.poster)
            tvTitle.text = film.title
            tvYear.text = film.year
            tvPlot.text = film.plot

            btnImdb.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(film.imdbUrl)
                holder.itemView.context.startActivity(intent)
            }

            btnDetail.setOnClickListener {
                onDetailClick?.invoke(film.id)
            }
        }
    }

    override fun getItemCount() = filmList.size
}
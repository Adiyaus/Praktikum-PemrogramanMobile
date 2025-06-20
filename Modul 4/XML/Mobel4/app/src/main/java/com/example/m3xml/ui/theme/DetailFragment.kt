package com.example.m3xml.ui.theme

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.m3xml.R
import com.example.m3xml.data.Film
import com.example.m3xml.databinding.FragmentDetailBinding
import com.example.m3xml.viewmodel.FilmViewModel
import com.example.m3xml.viewmodel.ViewModelFactory
import timber.log.Timber

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FilmViewModel by activityViewModels {
        ViewModelFactory("Ini dari DetailFragment")
    }
    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDetailBinding.bind(view)

        val filmId = args.filmId

        val film: Film? = viewModel.getFilmById(filmId)

        if (film != null) {
            Timber.d("Membuka halaman detail untuk film: ID=${film.id}, Nama='${film.title}'")
            binding.ivDetailPoster.setImageResource(film.poster)
            binding.tvDetailTitle.text = "${film.title} (${film.year})"
            binding.tvDetailPlot.text = film.plot
            binding.ivDetailPoster.setOnClickListener {
                Timber.d("Poster '${film.title}' diklik, membuka URL IMDb.")
                val openUrlIntent = Intent(Intent.ACTION_VIEW, Uri.parse(film.imdbUrl))
                startActivity(openUrlIntent)
            }
        } else {
            Timber.e("Film dengan ID $filmId tidak ditemukan.")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
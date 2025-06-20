package com.example.m3xml.ui.theme

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.m3xml.databinding.FragmentDetailBinding
import com.example.m3xml.viewmodel.FilmViewModel

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FilmViewModel by activityViewModels()
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val filmId = args.filmId
        val film = viewModel.getFilmById(filmId)

        film?.let {
            binding.ivDetailPoster.setImageResource(it.poster)
            binding.tvDetailTitle.text = "${it.title} (${it.year})"
            binding.tvDetailPlot.text = it.plot
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
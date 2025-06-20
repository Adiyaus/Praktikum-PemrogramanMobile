package com.example.m3xml.ui.theme

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.m3xml.R
import com.example.m3xml.databinding.FragmentListBinding
import com.example.m3xml.viewmodel.FilmViewModel
import com.example.m3xml.viewmodel.ViewModelFactory
import kotlinx.coroutines.launch
import timber.log.Timber

class ListFragment : Fragment(R.layout.fragment_list) {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FilmViewModel by activityViewModels {
        ViewModelFactory("Ini dari ListFragment")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentListBinding.bind(view)

        val filmAdapter = FilmAdapter(
            onDetailClick = { film ->
                Timber.d("Tombol detail untuk film '${film.title}' ditekan.")
                viewModel.onFilmClicked(film)
            },
            onImdbClick = { film ->
                Timber.d("Tombol IMDb untuk film '${film.title}' ditekan.")
                val openUrlIntent = Intent(Intent.ACTION_VIEW, Uri.parse(film.imdbUrl))
                startActivity(openUrlIntent)
            }
        )

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = filmAdapter
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.filmList.collect { filmList ->
                        filmAdapter.submitList(filmList)
                    }
                }
                launch {
                    viewModel.navigateToDetail.collect { film ->
                        film?.let {
                            val action = ListFragmentDirections.actionListFragmentToDetailFragment(it.id)
                            findNavController().navigate(action)
                            viewModel.onNavigateToDetailComplete()
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
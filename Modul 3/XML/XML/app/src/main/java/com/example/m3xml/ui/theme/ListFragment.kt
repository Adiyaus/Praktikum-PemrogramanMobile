package com.example.m3xml.ui.theme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.m3xml.databinding.FragmentListBinding
import com.example.m3xml.viewmodel.FilmViewModel

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private val filmViewModel: FilmViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val filmAdapter = FilmAdapter(emptyList())

        val orientation = resources.configuration.orientation
        if (orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE) {
            binding.recyclerView.layoutManager = GridLayoutManager(context, 2)
        } else {
            binding.recyclerView.layoutManager = LinearLayoutManager(context)
        }

        binding.recyclerView.adapter = filmAdapter

        filmViewModel.films.observe(viewLifecycleOwner) { films ->
            val adapter = FilmAdapter(films)
            binding.recyclerView.adapter = adapter
            adapter.onDetailClick = { filmId ->
                val action = ListFragmentDirections.actionListFragmentToDetailFragment(filmId)
                findNavController().navigate(action)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
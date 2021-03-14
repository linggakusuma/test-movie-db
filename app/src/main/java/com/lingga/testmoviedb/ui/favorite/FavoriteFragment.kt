package com.lingga.testmoviedb.ui.favorite

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.LinearLayoutManager
import com.lingga.testmoviedb.R
import com.lingga.testmoviedb.core.domain.model.Movie
import com.lingga.testmoviedb.databinding.FragmentHomeBinding
import com.lingga.testmoviedb.ui.base.BaseFragment
import com.lingga.testmoviedb.ui.home.MovieAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class FavoriteFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val favoriteViewModel: FavoriteViewModel by viewModel()

    private val adapter by lazy { MovieAdapter { navigationToDetailMovie(it) } }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeUi()
        init()
    }

    private fun init() {
        binding.recyclerViewMovie.apply {
            adapter = this@FavoriteFragment.adapter
            layoutManager = LinearLayoutManager(context)

        }
    }

    private fun subscribeUi() {
        favoriteViewModel.movie.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }

    private fun navigationToDetailMovie(movie: Movie) {
        val options = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }
        findNavController().navigate(
            FavoriteFragmentDirections.actionFavoriteFragmentToMovieDetailFragment(
                movie,
                movie.title ?: ""
            ), options
        )
    }

}
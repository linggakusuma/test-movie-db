package com.lingga.testmoviedb.ui.home

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.lingga.testmoviedb.R
import com.lingga.testmoviedb.core.domain.model.Movie
import com.lingga.testmoviedb.databinding.FragmentHomeBinding
import com.lingga.testmoviedb.ui.base.BaseFragment
import com.lingga.testmoviedb.utils.ext.hide
import com.lingga.testmoviedb.utils.ext.show
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val homeViewModel: HomeViewModel by viewModel()

    private val adapter by lazy { MovieAdapter { navigationToDetailMovie(it) } }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeUi()
        init()
        setHasOptionsMenu(true)
    }

    private fun init() {
        binding.recyclerViewMovie.apply {
            adapter = this@HomeFragment.adapter
            layoutManager = LinearLayoutManager(context)

        }
    }

    private fun subscribeUi() {
        homeViewModel.movie.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })

        homeViewModel.getLoading().observe(viewLifecycleOwner, { loading ->
            binding.loading.shimmer.apply {
                if (loading) show() else hide()
            }
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
            HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(
                movie,
                movie.title ?: ""
            ), options
        )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.favorite -> navigateToFavorite(HomeFragmentDirections.actionHomeFragmentToFavoriteFragment())
        }
        return NavigationUI.onNavDestinationSelected(
            item, view?.findNavController() ?: findNavController()
        ) || super.onOptionsItemSelected(item)
    }
}
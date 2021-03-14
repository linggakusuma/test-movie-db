package com.lingga.testmoviedb.ui.detail

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.lingga.testmoviedb.R
import com.lingga.testmoviedb.databinding.FragmentMovieDetailBinding
import com.lingga.testmoviedb.ui.base.BaseFragment
import com.lingga.testmoviedb.utils.ext.hide
import org.koin.android.viewmodel.ext.android.viewModel


class MovieDetailFragment :
    BaseFragment<FragmentMovieDetailBinding>(R.layout.fragment_movie_detail) {

    private val detailViewModel: MovieDetailViewModel by viewModel()

    private val args: MovieDetailFragmentArgs by navArgs()

    private val adapter by lazy { ReviewAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeUi()
        init()
    }

    private fun init() {
        binding.apply {
            viewModel = detailViewModel
            recyclerViewReview.apply {
                adapter = this@MovieDetailFragment.adapter
                layoutManager = LinearLayoutManager(context)
            }
            readMore.setOnClickListener {
                overview.maxLines = 0
                readMore.hide()
            }
        }
    }

    private fun subscribeUi() {
        val id = args.movie.id
        detailViewModel.apply {
            getDetailMovie(id)
            getReviews(id)
            getMovieFavorite(id)
        }

        detailViewModel.reviews.observe(viewLifecycleOwner, {
            if (!it.isNullOrEmpty()) {
                binding.labelEmptyReview.hide()
                adapter.submitList(it)
            }
        })

        detailViewModel.movieFavorite.observe(viewLifecycleOwner, { favorite ->
            setStatusFavorite(favorite.isFavorite)
            detailViewModel.movie.observe(viewLifecycleOwner, { movie ->
                var state = favorite.isFavorite
                binding.buttonFavorite.setOnClickListener {
                    state = !state
                    detailViewModel.setFavoriteMovie(movie, state)
                    setStatusFavorite(state)
                }
            })
        })
    }

    private fun setStatusFavorite(state: Boolean) {
        binding.buttonFavorite.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                if (state) R.drawable.ic_baseline_favorite else R.drawable.ic_baseline_favorite_border
            )
        )
    }
}
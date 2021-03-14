package com.lingga.testmoviedb.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lingga.testmoviedb.core.domain.model.Review
import com.lingga.testmoviedb.databinding.ItemListReviewBinding
import com.lingga.testmoviedb.utils.ext.hide

class ReviewAdapter : RecyclerView.Adapter<ReviewAdapter.ViewHolder>() {

    private var reviews = emptyList<Review>()

    internal fun submitList(reviews: List<Review>) {
        this.reviews = reviews
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewAdapter.ViewHolder =
        ViewHolder(
            ItemListReviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ReviewAdapter.ViewHolder, position: Int) {
        val review = reviews[position]
        holder.bind(review)
    }

    override fun getItemCount(): Int = reviews.size

    inner class ViewHolder(private val binding: ItemListReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(review: Review) {
            binding.apply {
                item = review
                executePendingBindings()
                readMore.setOnClickListener {
                    content.maxLines = 0
                    readMore.hide()
                }
            }
        }
    }
}
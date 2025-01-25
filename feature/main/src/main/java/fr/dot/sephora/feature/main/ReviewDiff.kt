package fr.dot.sephora.feature.main

import androidx.recyclerview.widget.DiffUtil.ItemCallback
import fr.dot.sephora.library.domain.models.Reviews

internal class ReviewDiff : ItemCallback<Reviews.Review>() {

    override fun areItemsTheSame(oldItem: Reviews.Review, newItem: Reviews.Review): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Reviews.Review, newItem: Reviews.Review): Boolean {
        return oldItem == newItem
    }

}
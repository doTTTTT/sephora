package fr.dot.sephora.feature.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import fr.dot.sephora.feature.main.databinding.ItemReviewBinding
import fr.dot.sephora.library.domain.models.Reviews

internal class ReviewAdapter : ListAdapter<Reviews.Review, ReviewAdapter.ViewHolder>(ReviewDiff())  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemReviewBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    data class ViewHolder(
        private val binding: ItemReviewBinding
    ) : RecyclerView.ViewHolder(binding.root)

}
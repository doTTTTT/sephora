package fr.dot.sephora.feature.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import fr.dot.sephora.feature.main.databinding.ItemReviewBinding
import fr.dot.sephora.library.domain.models.Reviews

internal class ReviewAdapter : ListAdapter<Reviews.Review, ReviewAdapter.ViewHolder>(ReviewDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemReviewBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        val context = holder.binding.root.context

        holder.binding.textName.text = item.name ?: context.getString(R.string.common_unknown)
        holder.binding.textDescription.text =
            item.text ?: context.getString(R.string.common_unknown)
        holder.binding.textRating.text =
            item.rating?.toString() ?: context.getString(R.string.common_unknown)
    }

    data class ViewHolder(
        val binding: ItemReviewBinding
    ) : RecyclerView.ViewHolder(binding.root)

}
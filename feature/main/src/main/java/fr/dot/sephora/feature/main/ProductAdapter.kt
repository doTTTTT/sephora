package fr.dot.sephora.feature.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import fr.dot.sephora.feature.main.databinding.ItemProductBinding

internal class ProductAdapter :
    ListAdapter<ProductWithReviews, ProductAdapter.ViewHolder>(ProductDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProductBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        holder.binding.textName.text = item.product.name
        holder.binding.textDescription.text = item.product.description
        holder.binding.textPrice.text = "${item.product.price}€"
        if (!item.hidden && holder.expanded) {
            holder.adapter.submitList(item.reviews)
        } else {
            holder.adapter.submitList(emptyList())
        }
        holder.binding.root.setOnClickListener {
            if (holder.expanded) {
                holder.adapter.submitList(emptyList())
            } else {
                holder.adapter.submitList(item.reviews)
            }
            holder.expanded = !holder.expanded
        }
    }

    data class ViewHolder(
        val binding: ItemProductBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        val adapter = ReviewAdapter()

        var expanded: Boolean = false

        init {
            binding.recycler.adapter = adapter
        }

    }

}
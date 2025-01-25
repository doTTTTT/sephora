package fr.dot.sephora.feature.main

import androidx.recyclerview.widget.DiffUtil.ItemCallback

internal class ProductDiff : ItemCallback<ProductWithReviews>() {

    override fun areItemsTheSame(
        oldItem: ProductWithReviews,
        newItem: ProductWithReviews
    ): Boolean {
        return oldItem.product.id == newItem.product.id
    }

    override fun areContentsTheSame(
        oldItem: ProductWithReviews,
        newItem: ProductWithReviews
    ): Boolean {
        return oldItem == newItem
    }

}
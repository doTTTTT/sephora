package fr.dot.sephora.feature.main

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ProductItemDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom = 16
        outRect.top = 16
    }

}
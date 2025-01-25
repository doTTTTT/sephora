package fr.dot.sephora.library.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = ReviewEntity.TABLE_NAME
)
data class ReviewEntity(

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "product_id")
    val productId: Int,

    @ColumnInfo("name")
    val name: String? = null,

    @ColumnInfo("text")
    val text: String? = null,

    @ColumnInfo("rating")
    val rating: Float? = null

) {

    companion object {

        const val TABLE_NAME = "review"

    }

}
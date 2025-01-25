package fr.dot.sephora.library.local.dao

import androidx.room.Dao
import androidx.room.Query
import fr.dot.sephora.library.local.entity.ReviewEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface ReviewDao : BaseDao<ReviewEntity> {

    @Query("SELECT * FROM ${ReviewEntity.TABLE_NAME}")
    suspend fun getReviews(): List<ReviewEntity>

    @Query("SELECT * FROM ${ReviewEntity.TABLE_NAME} WHERE id = :id")
    suspend fun getReview(id: Int): ReviewEntity?

    @Query("SELECT * FROM ${ReviewEntity.TABLE_NAME} WHERE product_id = :productId")
    fun flowOfReviews(productId: Int): Flow<List<ReviewEntity>>

    @Query("SELECT * FROM ${ReviewEntity.TABLE_NAME} WHERE id = :id")
    fun flowOfReview(id: Int): Flow<ReviewEntity?>

}
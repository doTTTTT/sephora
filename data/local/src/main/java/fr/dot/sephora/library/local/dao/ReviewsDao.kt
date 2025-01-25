package fr.dot.sephora.library.local.dao

import androidx.room.Dao
import androidx.room.Query
import fr.dot.sephora.library.local.entity.ReviewsEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface ReviewsDao : BaseDao<ReviewsEntity> {

    @Query("SELECT * FROM ${ReviewsEntity.TABLE_NAME}")
    suspend fun getReviews(): List<ReviewsEntity>

    @Query("SELECT * FROM ${ReviewsEntity.TABLE_NAME} WHERE product_id = :id")
    suspend fun getReview(id: Int): ReviewsEntity?

    @Query("SELECT * FROM ${ReviewsEntity.TABLE_NAME}")
    fun flowOfReviews(): Flow<List<ReviewsEntity>>

    @Query("SELECT * FROM ${ReviewsEntity.TABLE_NAME} WHERE product_id = :id")
    fun flowOfReview(id: Int): Flow<ReviewsEntity?>

}
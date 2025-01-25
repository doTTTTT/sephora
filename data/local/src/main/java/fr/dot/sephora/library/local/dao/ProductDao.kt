package fr.dot.sephora.library.local.dao

import androidx.room.Dao
import androidx.room.Query
import fr.dot.sephora.library.domain.models.Product
import fr.dot.sephora.library.local.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface ProductDao : BaseDao<ProductEntity> {

    @Query("SELECT * FROM ${ProductEntity.TABLE_NAME}")
    suspend fun getProducts(): List<ProductEntity>

    @Query("SELECT * FROM ${ProductEntity.TABLE_NAME} WHERE product_id = :id")
    suspend fun getProduct(id: Int): ProductEntity?

    @Query("SELECT * FROM ${ProductEntity.TABLE_NAME}")
    fun flowOfProducts(): Flow<List<ProductEntity>>

    @Query("SELECT * FROM ${ProductEntity.TABLE_NAME} WHERE product_id = :id")
    fun flowOfProduct(id: Int): Flow<ProductEntity?>

}
package fr.dot.sephora.library.local.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import fr.dot.sephora.library.domain.models.Product

@Entity(
    tableName = ProductEntity.TABLE_NAME
)
internal data class ProductEntity(

    @ColumnInfo(name = "product_id")
    @PrimaryKey(autoGenerate = false)
    val id: Int,

    @ColumnInfo(name = "product_name")
    val name: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "price")
    val price: Double,

    @Embedded(prefix = "images_url_")
    val imageUrl: ImageUrl? = null,

    @Embedded("c_brand_")
    val cBrand: Brand,

    @ColumnInfo(name = "is_productSet")
    val isProductSet: Boolean,

    @ColumnInfo(name = "is_special_brand")
    val isSpecialBrand: Boolean

) {

    data class ImageUrl(

        @ColumnInfo("small")
        val small: String,

        @ColumnInfo("large")
        val large: String

    )

    data class Brand(

        @ColumnInfo("id")
        val id: String,

        @ColumnInfo("name")
        val name: String

    )

    companion object {
        const val TABLE_NAME = "product"
    }

}

internal fun ProductEntity.toDomain() = Product(
    id = id,
    name = name,
    cBrand = Product.Brand(
        id = cBrand.id,
        name = cBrand.name
    ),
    description = description,
    isProductSet = isProductSet,
    isSpecialBrand = isSpecialBrand,
    imageUrl = imageUrl?.let {
        Product.ImageUrl(
            small = it.small,
            large = it.large
        )
    },
    price = price
)

internal fun Product.toDomain() = ProductEntity(
    id = id,
    name = name,
    cBrand = ProductEntity.Brand(
        id = cBrand.id,
        name = cBrand.name
    ),
    description = description,
    isProductSet = isProductSet,
    isSpecialBrand = isSpecialBrand,
    imageUrl = imageUrl?.let {
        ProductEntity.ImageUrl(
            small = it.small,
            large = it.large
        )
    },
    price = price
)
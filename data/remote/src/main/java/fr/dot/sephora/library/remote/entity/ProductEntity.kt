package fr.dot.sephora.library.remote.entity

import fr.dot.sephora.library.domain.models.Product
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ProductEntity(

    @SerialName("product_id")
    val id: Int,

    @SerialName("product_name")
    val name: String,

    @SerialName("description")
    val description: String,

    @SerialName("price")
    val price: Double,

    @SerialName("images_url")
    val imageUrl: ImageUrl? = null,

    @SerialName("c_brand")
    val cBrand: Brand,

    @SerialName("is_productSet")
    val isProductSet: Boolean,

    @SerialName("is_special_brand")
    val isSpecialBrand: Boolean

) {

    @Serializable
    data class ImageUrl(

        @SerialName("small")
        val small: String,

        @SerialName("large")
        val large: String

    )

    @Serializable
    data class Brand(

        @SerialName("id")
        val id: String,

        @SerialName("name")
        val name: String

    )

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
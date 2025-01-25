package fr.dot.sephora.library.domain.models

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val imageUrl: ImageUrl?,
    val cBrand: Brand,
    val isProductSet: Boolean,
    val isSpecialBrand: Boolean
) {

    data class ImageUrl(
        val small: String,
        val large: String
    )

    data class Brand(
        val id: String,
        val name: String
    )

}
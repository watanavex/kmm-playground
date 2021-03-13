package tech.watanave.kmm_playground.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Owner(
    val login: String,
    val id: Int,
    @SerialName("avatar_url")
    val avatarUrl: String
)

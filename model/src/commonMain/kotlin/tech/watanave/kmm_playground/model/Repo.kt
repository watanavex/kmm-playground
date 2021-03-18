package tech.watanave.kmm_playground.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Repo(
    val id: Int,
    val name: String,
    @SerialName("full_name")
    val fullName: String,
    val owner: Owner,
    @SerialName("html_url")
    val htmlUrl: String,
    val description: String,
    val language: String?,
    @SerialName("watchers_count")
    val watchersCount: Int,
    @SerialName("stargazers_count")
    val stargazersCount: Int,
    @SerialName("forks_count")
    val forksCount: Int
)

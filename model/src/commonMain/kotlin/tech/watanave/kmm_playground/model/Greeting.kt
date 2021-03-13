package tech.watanave.kmm_playground.model

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}
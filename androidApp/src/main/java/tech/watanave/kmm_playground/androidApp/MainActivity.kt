package tech.watanave.kmm_playground.androidApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import tech.watanave.kmm_playground.api.ApiClient

class MainActivity : AppCompatActivity() {

    private val api: ApiClient by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            val response = api.request("Kotlin")
            println(response)
        }
    }
}

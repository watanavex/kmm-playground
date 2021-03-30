package tech.watanave.kmm_playground.api

import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initKoin(searchWordProvider: SearchWordProvider) = startKoin {
    modules(module { single { searchWordProvider } }, commonModule())
}

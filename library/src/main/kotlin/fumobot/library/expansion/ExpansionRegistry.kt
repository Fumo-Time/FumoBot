package fumobot.library.expansion

import fumobot.library.CommonExpansion
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

val expansionCoroutineScope = CoroutineScope(Executors.newCachedThreadPool().asCoroutineDispatcher())

abstract class Expansion(val name: String, val common: CommonExpansion = CommonExpansion) {

    suspend fun register() = expansionCoroutineScope.launch {
        load()
        println("Loading expansion $name")
        delay(5000)

        init()
        delay(5000)
        println("Successfully initiated $name expansion")
    }

    abstract suspend fun load()

    abstract suspend fun init()

}

class ExpansionRegistry(val expansionMap: MutableMap<String, Expansion> = mutableMapOf()) {

    init {
        registerExpansions()
    }

    private fun registerExpansions() = Expansion::class.sealedSubclasses
        .forEach { println(it) }

}

suspend fun CommonExpansion.initExpansions() = expansionRegistry.expansionMap.values.forEach {
    it.register()
}
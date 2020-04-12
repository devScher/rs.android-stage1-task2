package subtask5

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {
    fun getData(blockA: Array<Any>, blockB: KClass<*>): Any {
        return when (blockB){
            String::class -> {
                val stringList = blockA.filterIsInstance<String>()
                return stringList.joinToString(separator = "")
            }
            Int::class -> {
                val intList = blockA.filterIsInstance<Int>()
                return intList.sum()
            }
            LocalDate::class -> {
                val localDate = blockA.filterIsInstance<LocalDate>().max() ?: return Any()
                return localDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
            }
            else -> Any()
        }
    }
}

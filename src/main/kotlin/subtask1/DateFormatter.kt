package subtask1

import java.text.SimpleDateFormat
import java.util.*
import java.util.Locale

class DateFormatter {
    fun toTextDay(day: String, month: String, year: String): String {
        val locale = Locale("ru")
        val dateFormat = SimpleDateFormat("d MMMM, EEEE", locale)
        if (!isDateCorrect(day, month, year)) {
            return "Такого дня не существует"
        }
        val month = month.toInt() - 1
        val calendar = GregorianCalendar(year.toInt(), month, day.toInt())
        return dateFormat.format(calendar.time)
    }

    private fun isDateCorrect(day: String, month: String, year: String): Boolean {
        val day = day.toInt()
        val month = month.toInt()
        val year = year.toInt()
        val isLeapYear = GregorianCalendar().isLeapYear(year)
        if (month < 1 || month > 12){
            return false
        }
        if (!isLeapYear && month == 2 && day > 28){
            return false
        }
        return true
    }
}
package subtask2

class TimeConverter {
    fun toTextFormat(hour: String, minute: String): String {
        val h = hour.toInt()
        val m = minute.toInt()
        val nums = arrayOf(
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen",
            "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen", "twenty", "twenty one",
            "twenty two", "twenty three", "twenty four",
            "twenty five", "twenty six", "twenty seven",
            "twenty eight", "twenty nine"
        )
        return when (m) {
            0 -> nums[h] + " o' clock"
            1 -> "one minute past " + nums[h]
            15 -> "quarter past " + nums[h]
            30 -> "half past " + nums[h]
            45 -> "quarter to " + nums[h % 12 + 1]
            59 -> "one minute to " + nums[h % 12 + 1]
            in 0..30 -> nums[m] + " minutes past " + nums[h]
            in 31..60 -> nums[60 - m] + " minutes to " + nums[h % 12 + 1]
            else -> ""
        }
    }
}
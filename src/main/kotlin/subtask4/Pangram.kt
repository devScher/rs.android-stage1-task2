package subtask4

import java.util.*
import kotlin.Comparator

class Pangram {
    fun getResult(inputString: String): String {
        var inputString = inputString.trim().replace("\n","")
        inputString = inputString.replace("[\\s]+".toRegex(), " ")
        if (inputString.isEmpty()) {
            return ""
        }
        if (isPangram(inputString)) {
            return panramMagic(inputString.split(" "))
        } else {
            return nonPanramMagic(inputString.split(" "))
        }
    }

    fun isPangram(str: String): Boolean {
        val mark = BooleanArray(26)
        var index: Int
        loop@ for (i in str.indices) {
            index = when (str[i]) {
                in 'A'..'Z' -> str[i] - 'A'
                in 'a'..'z' -> str[i] - 'a'
                else -> continue@loop
            }
            mark[index] = true
        }
        for (i in 0..25) {
            if (!mark[i]) {
                return false
            }
        }
        return true
    }

    fun sortByFirstLetter(list: MutableList<String>): List<String> {
        Collections.sort(list, object : Comparator<String> {
            override fun compare(e1: String, e2: String): Int {
                return e1[0].compareTo(e2[0])
            }
        })
        return list
    }

    fun panramMagic(inputArray: List<String>): String {
        var newList = mutableListOf<String>()
        for (i in inputArray) {
            newList.add(letterMagic(i.toCharArray(), true))
        }
        return sortByFirstLetter(newList).joinToString(separator = " ")
    }

    fun nonPanramMagic(inputArray: List<String>): String {
        var newList = mutableListOf<String>()
        for (i in inputArray) {
            newList.add(letterMagic(i.toCharArray(), false))
        }
        return sortByFirstLetter(newList).joinToString(separator = " ")
    }

    fun letterMagic(str: CharArray, isVowelNeeded: Boolean): String {
        var count = 0
        for (i in str.indices) {
            if (str[i] == '\\') {
                return ""
            }
            if (isVowel(str[i]) && isVowelNeeded) {
                str[i] = str[i].toUpperCase()
                count++
            }
            if (!isVowel(str[i]) && !isVowelNeeded && str[i].isLetter()){
                str[i] = str[i].toUpperCase()
                count++
            }
        }
        return "${count}${str.joinToString(separator = "")}"
    }

    fun isVowel(char: Char): Boolean {
        return char == 'a' || char == 'e' || char == 'i' || char == 'o' || char == 'u' || char == 'y'
                || char == 'A' || char == 'E' || char == 'I' || char == 'O' || char == 'U' || char == 'Y'
    }
}

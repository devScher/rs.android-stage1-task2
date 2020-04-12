package subtask3

class Abbreviation {

    // TODO: Complete the following function
    fun abbreviationFromA(a: String, b: String): String {
        var tempA = StringBuilder(a.toUpperCase())
        if (a.length < b.length) {
            return "NO"
        }
        var loop = true
        while (loop) {
            for (i in tempA.indices) {
                if (!b.contains(tempA[i])) {
                    tempA.deleteCharAt(i)
                    break
                }
                if (i == tempA.lastIndex) {
                    loop = false
                }
            }
        }
        if (tempA.toString() != b) {
            return "NO"
        }
        return "YES"
    }
}

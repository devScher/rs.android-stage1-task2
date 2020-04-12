package subtask6

class Fibonacci {
    fun productFibonacciSequenceFor(n: Int): IntArray {
        val output = mutableListOf(0, 1)
        var temp: Int
        while (output[0] * output[1] < n) {
            temp = output[0] + output[1]
            output[0] = output[1]
            output[1] = temp
        }
        if (output[0] * output[1] == n) {
            output.add(1)
        } else {
            output.add(0)
        }
        return output.toIntArray()
    }
}

package io.github.rusticflare.advent.one

class FrequencyTracker {

    private val seen = mutableSetOf(0)
    private var currentFrequency = 0

    fun isRepeat(delta: Int): Boolean {
        currentFrequency += delta
        return !seen.add(currentFrequency)
    }

    fun getCurrentFrequency(): Int {
        return currentFrequency
    }

}

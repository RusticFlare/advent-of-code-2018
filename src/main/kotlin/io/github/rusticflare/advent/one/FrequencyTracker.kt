package io.github.rusticflare.advent.one

import java.util.stream.Stream

class FrequencyTracker(private val changes: Stream<String>) {

    fun getFinalFrequency(): Int {
        return changes
            .mapToInt(String::toInt)
            .sum()
    }

    fun getFirstRepeatedFrequency(): Int {
        return 0
    }

}

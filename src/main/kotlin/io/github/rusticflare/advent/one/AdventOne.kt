package io.github.rusticflare.advent.one

import java.nio.file.Paths

class AdventOne {

    fun first() {
        val frequencyMonitor = frequencyMonitor()
        println("First: " + frequencyMonitor.getFinalFrequency())
    }

    fun second() {
        val frequencyMonitor = frequencyMonitor()
        println("Second: " + frequencyMonitor.getFirstRepeatedFrequency())
    }

    private fun frequencyMonitor(): FrequencyMonitor {
        val inputPath = Paths.get(this::class.java.getResource("/one/input.txt").toURI())
        val fileBackedFrequencyTracker = FileBackedFrequencyChanges(inputPath)
        return FrequencyMonitor(fileBackedFrequencyTracker)
    }

}

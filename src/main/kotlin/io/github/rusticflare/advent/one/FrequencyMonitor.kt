package io.github.rusticflare.advent.one

class FrequencyMonitor(private val frequencyChanges: FrequencyChanges) {

    fun getFinalFrequency(): Int {
        return frequencyChanges.streamDeltas()
            .sum()
    }

    fun getFirstRepeatedFrequency(): Int {
        val frequencyTracker = FrequencyTracker()
        return frequencyChanges.streamCycledDeltas()
            .filter { frequencyTracker.isRepeat(it) }
            .map { frequencyTracker.getCurrentFrequency() }
            .findFirst()
            .orElseThrow();
    }

}

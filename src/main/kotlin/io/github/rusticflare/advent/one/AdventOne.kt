package io.github.rusticflare.advent.one

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

class AdventOne {

    fun first() {
        val inputPath = Paths.get(this::class.java.getResource("/one/input.txt").toURI())
        val inputBufferedReader = Files.newBufferedReader(inputPath)
        val frequencyTracker = FrequencyTracker(inputBufferedReader.lines())
        println(frequencyTracker.getFinalFrequency())
    }

}

package io.github.rusticflare.advent.four

import java.nio.file.Files
import java.nio.file.Paths
import kotlin.streams.asSequence

class AdventFour {

    fun first() {
        val guardShifts = guardShifts()
        val mostSleepyGuard = guardShifts.mostSleepyGuard()
        val minutesMostSlept = guardShifts.minuteMostSlept(mostSleepyGuard)
        val result = mostSleepyGuard * minutesMostSlept
        println("First: $mostSleepyGuard * $minutesMostSlept = $result")
    }

    fun second() {
        println("Second: ")
    }

    private fun guardShifts(): GuardShifts {
        return guardEvents()
            .fold(
                initial = GuardShifts(),
                operation = GuardShifts::addEvent
            )
    }

    private fun guardEvents(): Sequence<GuardEvent> {
        return streamLines()
            .map { GuardEvent.create(it) }
            .sorted()
    }

    private fun streamLines(): Sequence<String> {
        val inputPath = Paths.get(this::class.java.getResource("/four/input.txt").toURI())
        return Files.newBufferedReader(inputPath).lines().asSequence()
    }

}

package io.github.rusticflare.advent.four

class GuardShift(beginsShift: BeginsShift) {

    private val isAsleepAt = (0 until 60).groupBy { it }.mapValues { false }.toMutableMap()
    val guardId = beginsShift.guardId

    fun addEvent(guardEvent: GuardEvent) {
        (guardEvent.getLocalDateTime().minute until 60)
            .forEach { isAsleepAt[it] = guardEvent is FallsAsleep }
    }

    fun isAsleepAt(minutesPastMidnight: Int): Boolean {
        return isAsleepAt.getValue(minutesPastMidnight)
    }

    fun minutesAsleep(): Int {
        return (0 until 60).count { isAsleepAt.getValue(it) }
    }

}

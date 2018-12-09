package io.github.rusticflare.advent.four

class GuardShifts {

    private val guardShifts = mutableListOf<GuardShift>()

    fun addEvent(guardEvent: GuardEvent): GuardShifts {
        if (guardEvent is BeginsShift) {
            guardShifts.add(GuardShift(guardEvent))
        } else {
            guardShifts.last().addEvent(guardEvent)
        }
        return this
    }

    fun asSequenceOfShifts(): Sequence<GuardShift> {
        return guardShifts.asSequence()
    }

    fun mostSleepyGuard(): Int {
        return guardShifts
            .groupBy { it.guardId }.mapValues { key -> key.value.sumBy { it.minutesAsleep() } }
            .maxBy { it.value }!!.key
    }

    fun minuteMostSlept(guardId: Int): Int {
        val givenGuardShifts = guardShifts
            .filter { it.guardId == guardId }
        return (0 until 60).maxBy {minute -> givenGuardShifts.count { it.isAsleepAt(minute) } }!!
    }

}

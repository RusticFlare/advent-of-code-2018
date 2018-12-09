package io.github.rusticflare.advent.four

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.streams.asStream

internal class GuardShiftsTest {

    @Test
    fun `test collecting GuardEvents`() {
        val guardShifts = sequenceOf(
            "[1518-11-01 00:00] Guard #10 begins shift",
            "[1518-11-01 00:05] falls asleep",
            "[1518-11-01 00:25] wakes up"
        )
            .map { GuardEvent.create(it) }
            .fold(
                initial = GuardShifts(),
                operation = GuardShifts::addEvent
            )

        assertThat(guardShifts.asSequenceOfShifts().asStream())
            .hasSize(1)
            .allMatch { it.isAsleepAt(10) }
            .allMatch { it.isAsleepAt(5) }
            .noneMatch { it.isAsleepAt(25) }
            .noneMatch { it.isAsleepAt(0) }
            .allMatch { it.guardId == 10 }
    }
}

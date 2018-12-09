package io.github.rusticflare.advent.four

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.Month
import java.util.stream.Stream

class GuardEventTest {

    @Test
    fun `test creating GuardEvent - StartShift`() {
        assertThat(GuardEvent.create("[1518-11-01 00:00] Guard #10 begins shift"))
            .isInstanceOf(BeginsShift::class.java)
            .hasFieldOrPropertyWithValue("guardId", 10)
            .extracting { (it as GuardEvent).getLocalDateTime() }
            .hasFieldOrPropertyWithValue("year", 1518)
            .hasFieldOrPropertyWithValue("month", Month.NOVEMBER)
            .hasFieldOrPropertyWithValue("dayOfMonth", 1)
            .hasFieldOrPropertyWithValue("hour", 0)
            .hasFieldOrPropertyWithValue("minute", 0)
    }

    @Test
    fun `test creating GuardEvent - FallsAsleep`() {
        assertThat(GuardEvent.create("[1518-11-01 00:30] falls asleep"))
            .isInstanceOf(FallsAsleep::class.java)
            .extracting { (it as GuardEvent).getLocalDateTime() }
            .hasFieldOrPropertyWithValue("year", 1518)
            .hasFieldOrPropertyWithValue("month", Month.NOVEMBER)
            .hasFieldOrPropertyWithValue("dayOfMonth", 1)
            .hasFieldOrPropertyWithValue("hour", 0)
            .hasFieldOrPropertyWithValue("minute", 30)
    }

    @Test
    fun `test creating GuardEvent - WakesUp`() {
        assertThat(GuardEvent.create("[1518-11-02 00:50] wakes up"))
            .isInstanceOf(WakesUp::class.java)
            .extracting { (it as GuardEvent).getLocalDateTime() }
            .hasFieldOrPropertyWithValue("year", 1518)
            .hasFieldOrPropertyWithValue("month", Month.NOVEMBER)
            .hasFieldOrPropertyWithValue("dayOfMonth", 2)
            .hasFieldOrPropertyWithValue("hour", 0)
            .hasFieldOrPropertyWithValue("minute", 50)
    }

    @Test
    fun `test sorting GuardEvents`() {
        assertThat(
            Stream.of(
                    "[1518-11-01 00:25] wakes up",
                    "[1518-11-01 00:00] Guard #10 begins shift",
                    "[1518-11-01 00:05] falls asleep")
                .map { GuardEvent.create(it) }
                .sorted()
                .map { it::class })
            .containsExactly(BeginsShift::class, FallsAsleep::class, WakesUp::class)
    }

}

package io.github.rusticflare.advent.one

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.util.stream.Stream

class FrequencyTrackerTest {

    @Nested
    inner class FinalFrequency {

        @Test
        fun `test empty stream is 0`() {
            val frequencyTracker = FrequencyTracker(Stream.empty())
            assertThat(frequencyTracker.getFinalFrequency())
                .isEqualTo(0)
        }

        @Test
        fun `test single "+1" stream is 1`() {
            val frequencyTracker = FrequencyTracker(Stream.of("+1"))
            assertThat(frequencyTracker.getFinalFrequency())
                .isEqualTo(1)
        }

        @Test
        fun `test single "-1" stream is -1`() {
            val frequencyTracker = FrequencyTracker(Stream.of("-1"))
            assertThat(frequencyTracker.getFinalFrequency())
                .isEqualTo(-1)
        }

        @Test
        fun `test sequence is sum of sequence`() {
            val frequencyTracker = FrequencyTracker(Stream.of("-1", "+2", "-3", "+4"))
            assertThat(frequencyTracker.getFinalFrequency())
                .isEqualTo(2)
        }
    }

    @Nested
    inner class FirstRepeatedFrequency {

        @Test
        fun `test stream of {+1, -1} is 0`() {
            val frequencyTracker = FrequencyTracker(Stream.of("+1", "-1"))
            assertThat(frequencyTracker.getFirstRepeatedFrequency())
                .isEqualTo(0)
        }

    }

}

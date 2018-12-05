package io.github.rusticflare.advent.one

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class FrequencyMonitorTest {

    @Nested
    inner class FinalFrequency {

        @Test
        fun `test empty stream is 0`() {
            val frequencyTracker = FrequencyMonitor(ListBackedFrequencyChanges())
            assertThat(frequencyTracker.getFinalFrequency())
                .isEqualTo(0)
        }

        @Test
        fun `test single "+1" stream is 1`() {
            val frequencyTracker = FrequencyMonitor(ListBackedFrequencyChanges(+1))
            assertThat(frequencyTracker.getFinalFrequency())
                .isEqualTo(1)
        }

        @Test
        fun `test single "-1" stream is -1`() {
            val frequencyTracker = FrequencyMonitor(ListBackedFrequencyChanges(-1))
            assertThat(frequencyTracker.getFinalFrequency())
                .isEqualTo(-1)
        }

        @Test
        fun `test sequence is sum of sequence`() {
            val frequencyTracker = FrequencyMonitor(ListBackedFrequencyChanges(-1, +2, -3, +4))
            assertThat(frequencyTracker.getFinalFrequency())
                .isEqualTo(2)
        }
    }

    @Nested
    inner class FirstRepeatedFrequency {

        @Test
        fun `{+1, -1} first reaches "0" twice`() {
            val frequencyTracker = FrequencyMonitor(ListBackedFrequencyChanges(+1, -1))
            assertThat(frequencyTracker.getFirstRepeatedFrequency())
                .isEqualTo(0)
        }

        @Test
        fun `{+3, +3, +4, -2, -4} first reaches "10" twice`() {
            val frequencyTracker = FrequencyMonitor(ListBackedFrequencyChanges(+3, +3, +4, -2, -4))
            assertThat(frequencyTracker.getFirstRepeatedFrequency())
                .isEqualTo(10)
        }

        @Test
        fun `{-6, +3, +8, +5, -6} first reaches "5" twice`() {
            val frequencyTracker = FrequencyMonitor(ListBackedFrequencyChanges(-6, +3, +8, +5, -6))
            assertThat(frequencyTracker.getFirstRepeatedFrequency())
                .isEqualTo(5)
        }

        @Test
        fun `{+7, +7, -2, -7, -4} first reaches "14" twice`() {
            val frequencyTracker = FrequencyMonitor(ListBackedFrequencyChanges(+7, +7, -2, -7, -4))
            assertThat(frequencyTracker.getFirstRepeatedFrequency())
                .isEqualTo(14)
        }

    }

}

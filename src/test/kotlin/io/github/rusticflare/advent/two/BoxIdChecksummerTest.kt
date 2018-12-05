package io.github.rusticflare.advent.two

import io.github.rusticflare.advent.one.FrequencyMonitor
import io.github.rusticflare.advent.one.ListBackedFrequencyChanges
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.stream.Stream

class BoxIdChecksummerTest {

    @Test
    fun `test example checksum is 12`() {
        val boxIdChecksummer = BoxIdChecksummer()
        Stream.of("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab")
            .map { BoxId(it) }
            .forEach(boxIdChecksummer::addBoxId)

        assertThat(boxIdChecksummer.checksum())
            .isEqualTo(12)
    }

}

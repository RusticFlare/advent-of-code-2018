package io.github.rusticflare.advent.three

import io.github.rusticflare.advent.two.BoxId
import io.github.rusticflare.advent.two.BoxIdChecksummer
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.stream.Stream

internal class FabricAreaClaimTest {

    @Test
    fun `test creating FabricAreaClaim`() {
        assertThat(FabricAreaClaim("#123 @ 3,2: 5x4"))
            .hasFieldOrPropertyWithValue("id", 123)
            .hasFieldOrPropertyWithValue("fromLeft", 3)
            .hasFieldOrPropertyWithValue("fromTop", 2)
            .hasFieldOrPropertyWithValue("width", 5)
            .hasFieldOrPropertyWithValue("height", 4)
    }

}

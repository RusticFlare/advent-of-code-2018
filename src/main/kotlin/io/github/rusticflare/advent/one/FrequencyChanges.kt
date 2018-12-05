package io.github.rusticflare.advent.one

import java.util.stream.IntStream

interface FrequencyChanges {

    fun streamDeltas(): IntStream

    fun streamCycledDeltas(): IntStream

}

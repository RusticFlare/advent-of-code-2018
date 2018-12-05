package io.github.rusticflare.advent.one

import java.util.stream.IntStream
import kotlin.streams.asStream

class ListBackedFrequencyChanges(private vararg val deltas: Int) : FrequencyChanges {

    override fun streamDeltas(): IntStream = IntStream.of(*deltas)

    override fun streamCycledDeltas(): IntStream {
        return deltas.asSequence().repeat().asStream()
            .mapToInt { it.toInt() }
    }

    private fun <T> Sequence<T>.repeat() = sequence { while (true) yieldAll(this@repeat) }

}

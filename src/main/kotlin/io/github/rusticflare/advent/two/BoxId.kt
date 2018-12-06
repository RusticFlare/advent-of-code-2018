package io.github.rusticflare.advent.two

import java.util.*
import java.util.stream.Collectors.counting
import java.util.stream.Collectors.groupingBy
import kotlin.streams.asStream

class BoxId(private val id: String) {

    fun hasTwo(): Boolean {
        return id.asSequence().asStream()
            .collect(groupingBy({ it }, counting()))
            .containsValue(2);
    }

    fun hasThree(): Boolean {
        return id.asSequence().asStream()
            .collect(groupingBy({ it }, counting()))
            .containsValue(3);
    }

    fun getSimilar(other: BoxId): Optional<String> {
        if (this.id.length != other.id.length) {
            return Optional.empty()
        }
        var misses = 0
        var missAt = -1
        for (i in 0 until this.id.length) {
            if (this.id[i] != other.id[i]) {
                misses++
                missAt = i
            }
        }
        if (misses == 1) {
            return Optional.of(this.id.removeRange(IntRange(missAt, missAt)))
        }
        return Optional.empty()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BoxId

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

}

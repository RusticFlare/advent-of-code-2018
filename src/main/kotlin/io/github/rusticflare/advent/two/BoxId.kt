package io.github.rusticflare.advent.two

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

}

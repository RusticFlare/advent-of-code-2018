package io.github.rusticflare.advent.two

import java.nio.file.Files
import java.nio.file.Paths
import java.util.*
import java.util.stream.Stream

class AdventTwo {

    fun first() {
        val boxIdChecksummer = BoxIdChecksummer()
        boxIds()
            .forEach(boxIdChecksummer::addBoxId)
        println("First: " + boxIdChecksummer.checksum())
    }

    fun second() {
        val match = boxIds()
            .flatMap { main -> boxIds().map { main.getSimilar(it) }.flatMap { it.stream() } }
            .findFirst()
            .orElseThrow()
        println("Second: $match")
    }

    private fun boxIds(): Stream<BoxId> {
        return streamLines()
            .map { BoxId(it) }
    }

    private fun streamLines(): Stream<String> {
        val inputPath = Paths.get(this::class.java.getResource("/two/input.txt").toURI())
        return Files.newBufferedReader(inputPath).lines()
    }

}

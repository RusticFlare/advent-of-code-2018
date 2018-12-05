package io.github.rusticflare.advent.two

import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Stream

class AdventTwo {

    fun first() {
        val boxIdChecksummer = BoxIdChecksummer()
        boxIds()
            .forEach(boxIdChecksummer::addBoxId)
        println("First: " + boxIdChecksummer.checksum())
    }

    fun second() {
        println("Second: ")
    }

    private fun boxIds(): Stream<BoxId> {
        val inputPath = Paths.get(this::class.java.getResource("/two/input.txt").toURI())
        return Files.newBufferedReader(inputPath).lines()
            .map { BoxId(it) }

    }

}

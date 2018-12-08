package io.github.rusticflare.advent.four

import java.nio.file.Files
import java.nio.file.Paths
import java.util.*
import java.util.stream.Collectors.counting
import java.util.stream.Collectors.groupingBy
import java.util.stream.Stream

class AdventFour {

    fun first() {
        println("First: ")
    }

    fun second() {
        println("Second: ")
    }

    private fun streamLines(): Stream<String> {
        val inputPath = Paths.get(this::class.java.getResource("/four/input.txt").toURI())
        return Files.newBufferedReader(inputPath).lines()
    }

}

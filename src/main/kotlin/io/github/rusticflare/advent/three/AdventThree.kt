package io.github.rusticflare.advent.three

import java.nio.file.Files
import java.nio.file.Paths
import java.util.stream.Collectors.counting
import java.util.stream.Collectors.groupingBy
import java.util.stream.Stream

class AdventThree {

    fun first() {
        val count = fabricAreaClaims()
            .flatMap { it.coordinates() }
            .collect(groupingBy({ it }, counting()))
            .values.stream()
            .filter { it > 1 }
            .count()
        println("First: $count")
    }

    fun second() {
        val coordinateToUsage = fabricAreaClaims()
            .flatMap { it.coordinates() }
            .collect(groupingBy({ coordinate -> coordinate }, counting()))
        val singleClaimId = fabricAreaClaims()
            .filter { it.coordinates().allMatch { coordinate -> coordinateToUsage[coordinate] == 1L } }
            .findFirst()
            .map { it.id }
            .orElseThrow()
        println("Second: $singleClaimId")
    }

    private fun fabricAreaClaims(): Stream<FabricAreaClaim> {
        return streamLines().map { FabricAreaClaim(it) }
    }

    private fun streamLines(): Stream<String> {
        val inputPath = Paths.get(this::class.java.getResource("/three/input.txt").toURI())
        return Files.newBufferedReader(inputPath).lines()
    }

}

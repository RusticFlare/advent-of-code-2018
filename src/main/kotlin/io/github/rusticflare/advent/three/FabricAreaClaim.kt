package io.github.rusticflare.advent.three

import java.util.stream.Collectors.toSet
import java.util.stream.IntStream
import java.util.stream.Stream

class FabricAreaClaim {

    private val id: Int
    private val fromLeft: Int
    private val fromTop: Int
    private val width: Int
    private val height: Int


    constructor(claim: String) {
        // #123 @ 3,2: 5x4
        id = claim.substring(claim.indexOf('#') + 1 until claim.indexOf(" @ ")).toInt()
        fromLeft = claim.substring(claim.indexOf(" @ ") + 3 until claim.indexOf(',')).toInt()
        fromTop = claim.substring(claim.indexOf(',') + 1 until claim.indexOf(": ")).toInt()
        width = claim.substring(claim.indexOf(": ") + 2 until claim.indexOf('x')).toInt()
        height = claim.substringAfter('x').toInt()
    }

    fun coordinates(): Stream<Coordinate> {
        return IntStream.range(fromLeft, fromLeft + width)
            .boxed()
            .flatMap { column -> IntStream.range(fromTop, fromTop + height).mapToObj {row -> Coordinate(row, column) } }
    }

}

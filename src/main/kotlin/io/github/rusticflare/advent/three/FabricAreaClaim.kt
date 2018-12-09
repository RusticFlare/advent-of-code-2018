package io.github.rusticflare.advent.three

import java.util.stream.IntStream
import java.util.stream.Stream

class FabricAreaClaim(claim: String) {

    val id: Int = claim.substring(claim.indexOf('#') + 1 until claim.indexOf(" @ ")).toInt()
    private val fromLeft: Int = claim.substring(claim.indexOf(" @ ") + 3 until claim.indexOf(',')).toInt()
    private val fromTop: Int = claim.substring(claim.indexOf(',') + 1 until claim.indexOf(": ")).toInt()
    private val width: Int = claim.substring(claim.indexOf(": ") + 2 until claim.indexOf('x')).toInt()
    private val height: Int = claim.substringAfter('x').toInt()


    fun coordinates(): Stream<Coordinate> {
        return IntStream.range(fromLeft, fromLeft + width)
            .boxed()
            .flatMap { column -> IntStream.range(fromTop, fromTop + height).mapToObj {row -> Coordinate(row, column) } }
    }

}

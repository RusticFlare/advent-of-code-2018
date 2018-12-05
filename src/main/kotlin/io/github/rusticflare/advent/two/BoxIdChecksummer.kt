package io.github.rusticflare.advent.two

class BoxIdChecksummer {

    private var twos = 0
    private var threes = 0

    fun addBoxId(boxId: BoxId) {
        if(boxId.hasTwo()) {
            twos++
        }
        if(boxId.hasThree()) {
            threes++
        }
    }

    fun checksum() : Int = twos * threes

}

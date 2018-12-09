package io.github.rusticflare.advent.four

import java.time.LocalDateTime

class BeginsShift(localDateTime: LocalDateTime, private val guardId: Int) : GuardEvent(localDateTime) {

}

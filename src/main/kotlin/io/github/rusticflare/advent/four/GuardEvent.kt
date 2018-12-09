package io.github.rusticflare.advent.four

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

abstract class GuardEvent(private val localDateTime: LocalDateTime) : Comparable<GuardEvent> {

    companion object Factory {

        fun create(string: String): GuardEvent {
            val dateTime = string.substring(string.indexOf('[') + 1 until string.indexOf(']'))
            val localDateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
            if (string.contains('#')) {
                val id = string.substring(
                    string.indexOf('#') + 1
                        until
                        string.indexOf(' ', startIndex = string.indexOf('#'))
                )
                return BeginsShift(localDateTime, id.toInt())
            } else if (string.contains("falls asleep")) {
                return FallsAsleep(localDateTime)
            }
            return WakesUp(localDateTime)
        }

    }

    fun getLocalDateTime(): LocalDateTime = localDateTime

    override fun compareTo(other: GuardEvent): Int = this.localDateTime.compareTo(other.localDateTime)

}
